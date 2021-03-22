package com.larksuite.oapi.core.api.handler;

import com.larksuite.oapi.core.AppType;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.Keys;
import com.larksuite.oapi.core.api.Constants;
import com.larksuite.oapi.core.api.exception.AccessTokenObtainException;
import com.larksuite.oapi.core.api.exception.AppTicketIsEmptyException;
import com.larksuite.oapi.core.api.request.BaseRequest;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Body;
import com.larksuite.oapi.core.api.token.*;
import com.larksuite.oapi.core.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AccessToken {

    private static final Logger log = LoggerFactory.getLogger(AccessToken.class);

    private static final int expiryDeltaOfSecond = 3 * 60;

    // get internal app access token
    public static AppAccessToken getInternalAppAccessToken(Context ctx) throws Exception {
        Config config = Config.ByCtx(ctx);
        AppAccessToken appAccessToken = new AppAccessToken();
        InternalAccessTokenReq internalAccessTokenReq = new InternalAccessTokenReq();
        internalAccessTokenReq.setAppId(config.getAppSettings().getAppID());
        internalAccessTokenReq.setAppSecret(config.getAppSettings().getAppSecret());
        Request<InternalAccessTokenReq, AppAccessToken> request = Request.newRequestByAuth(Constants.APP_ACCESS_TOKEN_INTERNAL_URL_PATH,
                "POST", internalAccessTokenReq, appAccessToken);
        Handler.DEFAULT.handle(ctx, request);
        if (request.getResponse().getCode() != Body.ErrCodeOk) {
            throw new AccessTokenObtainException("obtain internal app access token，failure information:", request.getResponse());
        }
        return request.getResponse().getData();
    }

    // get internal tenant access token
    public static TenantAccessToken getInternalTenantAccessToken(Context ctx) throws Exception {
        Config config = Config.ByCtx(ctx);
        TenantAccessToken tenantAccessToken = new TenantAccessToken();
        InternalAccessTokenReq internalAccessTokenReq = new InternalAccessTokenReq();
        internalAccessTokenReq.setAppId(config.getAppSettings().getAppID());
        internalAccessTokenReq.setAppSecret(config.getAppSettings().getAppSecret());
        Request<InternalAccessTokenReq, TenantAccessToken> request = Request.newRequestByAuth(Constants.TENANT_ACCESS_TOKEN_INTERNAL_URL_PATH,
                "POST", internalAccessTokenReq, tenantAccessToken);
        Handler.DEFAULT.handle(ctx, request);
        if (request.getResponse().getCode() != Body.ErrCodeOk) {
            throw new AccessTokenObtainException("obtain internal tenant access token，failure information:", request.getResponse());
        }
        return request.getResponse().getData();
    }

    private static String getAppTicket(Context ctx) throws Exception {
        Config config = Config.ByCtx(ctx);
        return config.getStore().get(Keys.appTicketKey(config.getAppSettings().getAppID()));
    }

    // get isv app access token
    public static AppAccessToken getIsvAppAccessToken(Context ctx) throws Exception {
        String appTicket = getAppTicket(ctx);
        if (Strings.isEmpty(appTicket)) {
            throw new AppTicketIsEmptyException();
        }
        Config config = Config.ByCtx(ctx);
        AppAccessToken appAccessToken = new AppAccessToken();
        ISVAppAccessTokenReq isvAppAccessTokenReq = new ISVAppAccessTokenReq();
        isvAppAccessTokenReq.setAppId(config.getAppSettings().getAppID());
        isvAppAccessTokenReq.setAppSecret(config.getAppSettings().getAppSecret());
        isvAppAccessTokenReq.setAppTicket(appTicket);
        Request<ISVAppAccessTokenReq, AppAccessToken> request = Request.newRequestByAuth(Constants.APP_ACCESS_TOKEN_ISV_URL_PATH,
                "POST", isvAppAccessTokenReq, appAccessToken);
        Handler.DEFAULT.handle(ctx, request);
        if (request.getResponse().getCode() != Body.ErrCodeOk) {
            throw new AccessTokenObtainException("obtain isv app access token，failure information:", request.getResponse());
        }
        return request.getResponse().getData();
    }

    // get isv tenant access token
    public static AccessTokenPair getISVTenantAccessToken(Context ctx) throws Exception {
        AppAccessToken appAccessToken = getIsvAppAccessToken(ctx);
        BaseRequest base = BaseRequest.byContext(ctx);
        TenantAccessToken tenantAccessToken = new TenantAccessToken();
        ISVTenantAccessTokenReq isvTenantAccessTokenReq = new ISVTenantAccessTokenReq();
        isvTenantAccessTokenReq.setAppAccessToken(appAccessToken.getAppAccessToken());
        isvTenantAccessTokenReq.setTenantKey(base.getTenantKey());
        Request<ISVTenantAccessTokenReq, TenantAccessToken> request = Request.newRequestByAuth(Constants.TENANT_ACCESS_TOKEN_ISV_URL_PATH,
                "POST", isvTenantAccessTokenReq, tenantAccessToken);
        Handler.DEFAULT.handle(ctx, request);
        if (request.getResponse().getCode() != Body.ErrCodeOk) {
            throw new AccessTokenObtainException("obtain isv tenant access token，failure information:", request.getResponse());
        }
        tenantAccessToken = request.getResponse().getData();
        return new AccessTokenPair(appAccessToken, tenantAccessToken);
    }

    private static void setAppAccessTokenToStore(Context ctx, AppAccessToken appAccessToken) {
        Config config = Config.ByCtx(ctx);
        int expire = appAccessToken.getExpire() - expiryDeltaOfSecond;
        try {
            config.getStore().put(Keys.appAccessTokenKey(config.getAppSettings().getAppID()), appAccessToken.getAppAccessToken(), expire, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.warn("store put happen exception, message:{}", e.getMessage());
        }
    }

    private static void setTenantAccessTokenToStore(Context ctx, TenantAccessToken tenantAccessToken) {
        Config config = Config.ByCtx(ctx);
        BaseRequest base = BaseRequest.byContext(ctx);
        int expire = tenantAccessToken.getExpire() - expiryDeltaOfSecond;
        try {
            config.getStore().put(Keys.tenantAccessTokenKey(config.getAppSettings().getAppID(),
                    base.getTenantKey() == null ? "" : base.getTenantKey()),
                    tenantAccessToken.getTenantAccessToken(), expire, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.warn("store put happen exception, message:{}", e.getMessage());
        }
    }

    public static void signApp(Context ctx, com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder) throws Exception {
        BaseRequest base = BaseRequest.byContext(ctx);
        Config config = Config.ByCtx(ctx);
        if (!base.isRetry()) {
            String tok = config.getStore().get(Keys.appAccessTokenKey(config.getAppSettings().getAppID()));
            if (!Strings.isEmpty(tok)) {
                sign(httpRequestBuilder, tok);
                return;
            }
        }
        AppAccessToken appAccessToken = null;
        if (config.getAppSettings().getAppType() == AppType.Internal) {
            appAccessToken = getInternalAppAccessToken(ctx);
        } else {
            appAccessToken = getIsvAppAccessToken(ctx);
        }
        setAppAccessTokenToStore(ctx, appAccessToken);
        sign(httpRequestBuilder, appAccessToken.getAppAccessToken());
    }

    public static void signTenant(Context ctx, com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder) throws Exception {
        BaseRequest base = BaseRequest.byContext(ctx);
        Config config = Config.ByCtx(ctx);
        String tenantKey = base.getTenantKey() == null ? "" : base.getTenantKey();
        if (!base.isRetry()) {
            String tok = config.getStore().get(Keys.tenantAccessTokenKey(config.getAppSettings().getAppID(), tenantKey));
            if (!Strings.isEmpty(tok)) {
                sign(httpRequestBuilder, tok);
                return;
            }
        }
        AppAccessToken appAccessToken;
        TenantAccessToken tenantAccessToken;
        if (config.getAppSettings().getAppType() == AppType.Internal) {
            tenantAccessToken = getInternalTenantAccessToken(ctx);
        } else {
            AccessTokenPair pair = getISVTenantAccessToken(ctx);
            appAccessToken = pair.appAccessToken;
            tenantAccessToken = pair.tenantAccessToken;
            if (appAccessToken != null) {
                setAppAccessTokenToStore(ctx, appAccessToken);
            }
        }
        setTenantAccessTokenToStore(ctx, tenantAccessToken);
        sign(httpRequestBuilder, tenantAccessToken.getTenantAccessToken());
    }

    public static void signUser(Context ctx, com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder) {
        BaseRequest base = BaseRequest.byContext(ctx);
        if (!Strings.isEmpty(base.getUserAccessToken())) {
            sign(httpRequestBuilder, base.getUserAccessToken());
        }
    }

    private static void sign(com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder, String token) {
        httpRequestBuilder.header("Authorization", "Bearer " + token);
    }

    private static class AccessTokenPair {
        private AppAccessToken appAccessToken;
        private TenantAccessToken tenantAccessToken;

        public AccessTokenPair(AppAccessToken appAccessToken, TenantAccessToken tenantAccessToken) {
            this.appAccessToken = appAccessToken;
            this.tenantAccessToken = tenantAccessToken;
        }
    }
}
