package com.larksuite.oapi.core.api.handler.subhandler;


import com.larksuite.oapi.core.AppType;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.exception.AccessTokenTypeInvalidException;
import com.larksuite.oapi.core.api.exception.TenantKeyEmptyException;
import com.larksuite.oapi.core.api.exception.UserAccessTokenKeyEmptyException;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.utils.Strings;

public class ValidateSubHandler implements SubHandler {
    @Override
    public <I, O> void handle(Context ctx, Request<I, O> req) throws Exception {
        if (req.getAccessTokenType() == AccessTokenType.None) {
            return;
        }
        if (!req.getAccessTokenTypeSet().contains(req.getAccessTokenType())) {
            throw new AccessTokenTypeInvalidException();
        }
        Config conf = Config.ByCtx(ctx);
        if (conf.getAppSettings().getAppType() == AppType.ISV) {
            if (req.getAccessTokenType() == AccessTokenType.Tenant && Strings.isEmpty(req.getTenantKey())) {
                throw new TenantKeyEmptyException();
            }
            if (req.getAccessTokenType() == AccessTokenType.User && Strings.isEmpty(req.getUserAccessToken())) {
                throw new UserAccessTokenKeyEmptyException();
            }
        }
    }
}
