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
  String VERSION = "v2.0.0";


  String APP_ACCESS_TOKEN_INTERNAL_URL_PATH = "/open-apis/auth/v3/app_access_token/internal";
  String APP_ACCESS_TOKEN_ISV_URL_PATH = "/open-apis/auth/v3/app_access_token";
  String TENANT_ACCESS_TOKEN_INTERNAL_URL_PATH = "/open-apis/auth/v3/tenant_access_token/internal";
  String TENANT_ACCESS_TOKEN_ISV_URL_PATH = "/open-apis/auth/v3/tenant_access_token";
  String APPLY_APP_TICKET_PATH = "/open-apis/auth/v3/app_ticket/resend";
}
