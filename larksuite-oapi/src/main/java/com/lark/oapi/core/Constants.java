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

package com.lark.oapi.core;

public interface Constants {

    String CONTENT_DISPOSITION = "Content-Disposition";
    String CONTENT_TYPE = "Content-Type";
    String APPLICATION_JSON = "application/json";
    String JSON_CONTENT_TYPE = APPLICATION_JSON + "; charset=utf-8";

    String HTTP_HEADER = "HTTP_HEADER";
    String HTTP_HEADER_KEY_REQUEST_ID = "X-Request-Id";
    String HTTP_HEADER_REQUEST_ID = "Request-Id";
    String HTTP_HEADER_KEY_LOG_ID = "X-Tt-Logid";
    String HTTP_KEY_STATUS_CODE = "http_status_code";
    String URL_VERIFICATION = "url_verification";
    String CUSTOM_REQUEST_ID = "Oapi-Sdk-Request-Id";


    public static final String X_LARK_REQUEST_TIMESTAMP = "X-Lark-Request-Timestamp";
    public static final String X_LARK_REQUEST_NONCE = "X-Lark-Request-Nonce";
    public static final String X_LARK_SIGNATURE = "X-Lark-Signature";
    public static final String X_REFRESH_TOKEN = "X-Refresh-Token";
    public static final String X_HELPDESK_AUTHORIZATION = "X-Lark-Helpdesk-Authorization";
    String VERSION = "v2.0.0";


    String APP_ACCESS_TOKEN_INTERNAL_URL_PATH = "/open-apis/auth/v3/app_access_token/internal";
    String APP_ACCESS_TOKEN_ISV_URL_PATH = "/open-apis/auth/v3/app_access_token";
    String TENANT_ACCESS_TOKEN_INTERNAL_URL_PATH = "/open-apis/auth/v3/tenant_access_token/internal";
    String TENANT_ACCESS_TOKEN_ISV_URL_PATH = "/open-apis/auth/v3/tenant_access_token";
    String OAUTH_TOKEN_URL_PATH = "/oauth/v3/token";
    String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    String GRANT_TYPE_JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    String CLIENT_ASSERTION_TYPE_JWT_BEARER = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
    String HEADER_X_TARGET_SERVICE = "X-Target-Service";
    int ERR_CODE_CLIENT_ASSERTION_PROVIDER_NOT_CONFIGURED = 7100;
    int ERR_CODE_CLIENT_ASSERTION_TOKEN_EMPTY = 7101;
    int ERR_CODE_CLIENT_ASSERTION_RETRIEVE_FAILED = 7102;
    int ERR_CODE_CLIENT_ASSERTION_MODE_NOT_SUPPORTED = 7103;
    int ERR_CODE_APP_SECRET_AND_CLIENT_ASSERTION_EMPTY = 7104;
    String APPLY_APP_TICKET_PATH = "/open-apis/auth/v3/app_ticket/resend";
    String GET_AUTHEN_ACCESS_TOKEN = "/open-apis/authen/v1/access_token";
    String REFRESH_AUTHEN_ACCESS_TOKEN = "/open-apis/authen/v1/refresh_access_token";
    String GET_AUTHEN_USER_INFO = "/open-apis/authen/v1/user_info";

    String JS_SDK_TICKET_GET_URL_PATH = "/open-apis/jssdk/ticket/get";
}
