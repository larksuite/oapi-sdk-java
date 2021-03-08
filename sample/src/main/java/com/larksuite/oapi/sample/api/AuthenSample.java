package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.BatchReqCall;
import com.larksuite.oapi.core.api.ReqCallResult;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.authen.v1.AuthenService;
import com.larksuite.oapi.service.authen.v1.model.AuthenAccessTokenReqBody;
import com.larksuite.oapi.service.authen.v1.model.AuthenRefreshAccessTokenReqBody;
import com.larksuite.oapi.service.authen.v1.model.UserAccessTokenInfo;
import com.larksuite.oapi.service.authen.v1.model.UserInfo;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AuthenSample {
    // for test
    private static final Config config = Config.getTestInternalConf("online");

    // for online
    // private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // private static final Config config = ConfigUtils.getConfig(com.larksuite.oapi.core.Constants.Domain.FeiShu, appSettings);

    public static void main(String[] args) throws Exception {
        testAccessToken();
        //testFreshAccessToken();
        //testUserInfo();
    }

    private static void testAccessToken() throws Exception {
        AuthenService service = new AuthenService(config);
        AuthenAccessTokenReqBody body = new AuthenAccessTokenReqBody();
        body.setGrantType("authorization_code");
        body.setCode("4QGluIQ4wY8vw9XNyyza4e");
        AuthenService.AuthenAccessTokenReqCall reqCall = service.getAuthens().accessToken(body);
        Response<UserAccessTokenInfo> response = reqCall.execute();
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
        System.out.println(Jsons.DEFAULT_GSON.toJson(response.getData()));
        System.out.println(response.getRequestID());
    }

    private static void testFreshAccessToken() throws Exception {
        AuthenService service = new AuthenService(config);
        AuthenRefreshAccessTokenReqBody body = new AuthenRefreshAccessTokenReqBody();
        body.setGrantType("refresh_token");
        body.setRefreshToken("[refresh_token]");
        AuthenService.AuthenRefreshAccessTokenReqCall reqCall = service.getAuthens().refreshAccessToken(body);
        Response<UserAccessTokenInfo> response = reqCall.execute();
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
        System.out.println(response.getRequestID());
    }

    private static void testUserInfo() throws Exception {
        AuthenService service = new AuthenService(config);
        AuthenService.AuthenUserInfoReqCall reqCall = service.getAuthens().userInfo(Request.setUserAccessToken("u-7B5D40vAJryhYyf6eigcxf"));
        Response<UserInfo> response = reqCall.execute();
        System.out.println(Jsons.DEFAULT_GSON.toJson(response.getData()));
        System.out.println(response.getRequestID());
    }

    private static void batchAccessToken() {
        AuthenService service = new AuthenService(config);
        AuthenAccessTokenReqBody body = new AuthenAccessTokenReqBody();
        body.setCode("[code]");
        body.setGrantType("authorization_code");
        AuthenService.AuthenAccessTokenReqCall reqCall1 = service.getAuthens().accessToken(body);
        AuthenService.AuthenAccessTokenReqCall reqCall2 = service.getAuthens().accessToken(body);
        BatchReqCall<AuthenAccessTokenReqBody, UserAccessTokenInfo> batchReqCall = new BatchReqCall<>(reqCall1, reqCall2);
        try {
            List<ReqCallResult<AuthenAccessTokenReqBody, UserAccessTokenInfo>> reqCallResults = batchReqCall.call();
            for (ReqCallResult<AuthenAccessTokenReqBody, UserAccessTokenInfo> reqCallResult : reqCallResults) {
                if (reqCallResult.getException() != null) {
                    System.out.println(reqCallResult.getException().getMessage());
                    return;
                }
                System.out.println(reqCallResult.getResponse().getRequestID());
                System.out.println(reqCallResult.getResponse().getHTTPStatusCode());
                System.out.println(Jsons.DEFAULT_GSON.toJson(reqCallResult.getResponse()));
            }
        } catch (ExecutionException | InterruptedException apiException) {
            apiException.printStackTrace();
        }
    }
}
