/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.token;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.exception.AppTicketIsEmptyException;
import com.lark.oapi.core.exception.ObtainAccessTokenException;
import com.lark.oapi.core.request.MarketplaceAppAccessTokenReq;
import com.lark.oapi.core.request.MarketplaceTenantAccessTokenReq;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.request.SelfBuiltAppAccessTokenReq;
import com.lark.oapi.core.response.AppAccessTokenResp;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.response.TenantAccessTokenResp;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TokenManager {

    private static final Logger log = LoggerFactory.getLogger(TokenManager.class);
    private static final int expiryDeltaOfSecond = 3 * 60;
    private static final String appAccessTokenKeyPrefix = "app_access_token";
    private static final String tenantAccessTokenKeyPrefix = "tenant_access_token";
    private ICache cache;

    public TokenManager(ICache cache) {
        this.cache = cache;
    }

    private String getAppAccessTokenKey(String appID) {
        return String.format("%s-%s", appAccessTokenKeyPrefix, appID);
    }

    public String getAppAccessToken(Config config) throws Exception {
        // 缓存里存在则直接返回
        String token = cache.get(getAppAccessTokenKey(config.getAppId()));
        if (Strings.isNotEmpty(token)) {
            return token;
        }

        // 否则发起请求，获取token，然后缓存
        if (AppType.SELF_BUILT == config.getAppType()) {
            AppAccessTokenResp resp = getInternalAppAccessToken(config);
            token = resp.getAppAccessToken();
            int timeOut = resp.getExpire();
            // 缓存
            cache.set(getAppAccessTokenKey(config.getAppId()), token, timeOut - expiryDeltaOfSecond,
                    TimeUnit.SECONDS);
            return token;

        } else {
            AppAccessTokenResp resp = getIsvAppAccessToken(config);
            token = resp.getAppAccessToken();
            int timeOut = resp.getExpire();
            // 缓存
            cache.set(getAppAccessTokenKey(config.getAppId()), token, timeOut - expiryDeltaOfSecond,
                    TimeUnit.SECONDS);
            return token;
        }
    }

    // 自建应用获取 access token
    private AppAccessTokenResp getInternalAppAccessToken(Config config) throws Exception {
        SelfBuiltAppAccessTokenReq internalAccessTokenReq = new SelfBuiltAppAccessTokenReq();
        internalAccessTokenReq.setAppId(config.getAppId());
        internalAccessTokenReq.setAppSecret(config.getAppSecret());
        RawResponse resp = Transport.send(config
                , new RequestOptions(), "POST"
                , Constants.APP_ACCESS_TOKEN_INTERNAL_URL_PATH
                , Sets.newHashSet(AccessTokenType.None), internalAccessTokenReq);

        AppAccessTokenResp appAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
                AppAccessTokenResp.class);
        if (appAccessTokenResp.getCode() != 0) {
            throw new ObtainAccessTokenException("obtain internal app access token failure: "
                    , String.format("code:%d,msg:%s", appAccessTokenResp.getCode(),
                    appAccessTokenResp.getMsg()));
        }

        return appAccessTokenResp;
    }

    private AppAccessTokenResp getIsvAppAccessToken(Config config) throws Exception {
        // 缓存中是否存在appTicket
        String appTicket = GlobalAppTicketManager.getAppTicketManager().get(config);
        if (Strings.isEmpty(appTicket)) {
            throw new AppTicketIsEmptyException();
        }

        // 发起请求，获取token
        MarketplaceAppAccessTokenReq isvAppAccessTokenReq = new MarketplaceAppAccessTokenReq();
        isvAppAccessTokenReq.setAppId(config.getAppId());
        isvAppAccessTokenReq.setAppSecret(config.getAppSecret());
        isvAppAccessTokenReq.setAppTicket(appTicket);

        RawResponse resp = Transport.send(config
                , new RequestOptions(), "POST"
                , Constants.APP_ACCESS_TOKEN_ISV_URL_PATH
                , Sets.newHashSet(AccessTokenType.None), isvAppAccessTokenReq);

        // 结果处理
        AppAccessTokenResp appAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
                AppAccessTokenResp.class);
        if (appAccessTokenResp.getCode() != 0) {
            throw new ObtainAccessTokenException("obtain isv app access token failure: "
                    , String.format("code:%d,msg:%s", appAccessTokenResp.getCode(),
                    appAccessTokenResp.getMsg()));
        }
        return appAccessTokenResp;
    }

    private String getTenantAccessTokenKey(String appID, String tenantKey) {
        return tenantAccessTokenKeyPrefix + "-" + appID + "-" + tenantKey;
    }

    public String getTenantAccessToken(Config config, String tenantKey) throws Exception {
        // 缓存中存在，则直接返回
        String token = cache.get(getTenantAccessTokenKey(config.getAppId(), tenantKey));
        if (Strings.isNotEmpty(token)) {
            return token;
        }

        // 发起请求，获取token
        TenantAccessTokenResp resp;
        if (AppType.SELF_BUILT == config.getAppType()) {
            resp = getInternalTenantAccessToken(config);
            token = resp.getTenantAccessToken();
            int timeOut = resp.getExpire();
            cache.set(getTenantAccessTokenKey(config.getAppId(), tenantKey), token,
                    timeOut - expiryDeltaOfSecond, TimeUnit.SECONDS);
        } else {
            resp = getIsvTenantAccessToken(config, tenantKey);
            token = resp.getTenantAccessToken();
            int timeOut = resp.getExpire();
            cache.set(getTenantAccessTokenKey(config.getAppId(), tenantKey), token,
                    timeOut - expiryDeltaOfSecond, TimeUnit.SECONDS);
        }
        return token;
    }

    // get internal tenant access token
    private TenantAccessTokenResp getInternalTenantAccessToken(Config config) throws Exception {
        SelfBuiltAppAccessTokenReq internalAccessTokenReq = new SelfBuiltAppAccessTokenReq();
        internalAccessTokenReq.setAppId(config.getAppId());
        internalAccessTokenReq.setAppSecret(config.getAppSecret());

        RawResponse resp = Transport.send(config
                , new RequestOptions(), "POST"
                , Constants.TENANT_ACCESS_TOKEN_INTERNAL_URL_PATH
                , Sets.newHashSet(AccessTokenType.None), internalAccessTokenReq);

        TenantAccessTokenResp tenantAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
                TenantAccessTokenResp.class);

        if (tenantAccessTokenResp.getCode() != 0) {
            throw new ObtainAccessTokenException("obtain internal tenant access token failure: "
                    , String.format("code:%d,msg:%s", tenantAccessTokenResp.getCode(),
                    tenantAccessTokenResp.getMsg()));
        }
        return tenantAccessTokenResp;
    }

    // get internal tenant access token
    private TenantAccessTokenResp getIsvTenantAccessToken(Config config, String tenantKey)
            throws Exception {
        AppAccessTokenResp appAccessToken = getIsvAppAccessToken(config);

        MarketplaceTenantAccessTokenReq isvTenantAccessTokenReq = new MarketplaceTenantAccessTokenReq();
        isvTenantAccessTokenReq.setAppAccessToken(appAccessToken.getAppAccessToken());
        isvTenantAccessTokenReq.setTenantKey(tenantKey);

        RawResponse resp = Transport.send(config
                , new RequestOptions(), "POST"
                , Constants.TENANT_ACCESS_TOKEN_ISV_URL_PATH
                , Sets.newHashSet(AccessTokenType.None), isvTenantAccessTokenReq);

        TenantAccessTokenResp tenantAccessTokenResp = UnmarshalRespUtil.unmarshalResp(resp,
                TenantAccessTokenResp.class);

        if (tenantAccessTokenResp.getCode() != 0) {
            throw new ObtainAccessTokenException("obtain isv tenant access token failure: "
                    , String.format("code:%d,msg:%s", tenantAccessTokenResp.getCode(),
                    tenantAccessTokenResp.getMsg()));
        }
        return tenantAccessTokenResp;
    }
}
