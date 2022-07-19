package com.lark.oapi.core;

import com.lark.oapi.core.exception.AccessTokenNotGivenException;
import com.lark.oapi.core.exception.ClientTimeoutException;
import com.lark.oapi.core.exception.IllegalAccessTokenTypeException;
import com.lark.oapi.core.exception.ServerTimeoutException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.httpclient.OkHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.request.ReqTranslator;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.OKHttps;
import com.lark.oapi.core.utils.Strings;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transport {

  private static final Logger log = LoggerFactory.getLogger(Transport.class);
  private static final ReqTranslator REQ_TRANSLATOR = new ReqTranslator();

  private static AccessTokenType determineTokenType(Set<AccessTokenType> accessTokenTypeSet,
      RequestOptions requestOptions, boolean disableTokenCache) {
    if (accessTokenTypeSet.contains(AccessTokenType.None)) {
      return AccessTokenType.None;
    }

    validateTokenType(accessTokenTypeSet, requestOptions);

    if (disableTokenCache) {
      if (Strings.isNotEmpty(requestOptions.getUserAccessToken())) {
        return AccessTokenType.User;
      }

      if (Strings.isNotEmpty(requestOptions.getTenantAccessToken())) {
        return AccessTokenType.Tenant;
      }

      if (Strings.isNotEmpty(requestOptions.getAppAccessToken())) {
        return AccessTokenType.App;
      }

      throw new AccessTokenNotGivenException();
    }

    if (Strings.isNotEmpty(requestOptions.getTenantKey())) {
      if (accessTokenTypeSet.contains(AccessTokenType.Tenant)) {
        return AccessTokenType.Tenant;
      }
    }

    if (Strings.isNotEmpty(requestOptions.getUserAccessToken())) {
      if (accessTokenTypeSet.contains(AccessTokenType.User)) {
        return AccessTokenType.User;
      }
    }

    if (accessTokenTypeSet.contains(AccessTokenType.Tenant)) {
      return AccessTokenType.Tenant;
    }

    throw new IllegalAccessTokenTypeException();
  }

  public static void validateTokenType(Set<AccessTokenType> accessTokenTypeSet,
      RequestOptions requestOptions) {
    if (requestOptions == null || accessTokenTypeSet == null
        || accessTokenTypeSet.size() == 0 || accessTokenTypeSet.size() > 1) {
      return;
    }

    AccessTokenType accessTokenType = accessTokenTypeSet.iterator().next();
    if (accessTokenType == AccessTokenType.Tenant
        && Strings.isNotEmpty(requestOptions.getUserAccessToken())) {
      throw new IllegalArgumentException("tenant token type not match user access token");
    }

    if (accessTokenType == AccessTokenType.User
        && Strings.isNotEmpty(requestOptions.getTenantAccessToken())) {
      throw new IllegalArgumentException("user token type not match tenant access token");
    }
  }

  private static void validate(Config config, RequestOptions requestOptions,
      AccessTokenType accessTokenType) {
    if (Strings.isEmpty(config.getAppId())) {
      throw new IllegalArgumentException("appId is blank");
    }

    if (Strings.isEmpty(config.getAppSecret())) {
      throw new IllegalArgumentException("appSecret is blank");
    }

    if (config.isDisableTokenCache()
        && Strings.isEmpty(requestOptions.getUserAccessToken())
        && Strings.isEmpty(requestOptions.getTenantAccessToken())
        && Strings.isEmpty(requestOptions.getAppAccessToken())) {
      throw new IllegalArgumentException("access token is blank");
    }

    if (accessTokenType == AccessTokenType.Tenant
        && Strings.isNotEmpty(requestOptions.getUserAccessToken())) {
      throw new IllegalArgumentException("tenant token type not match user access token");
    }

    if (accessTokenType == AccessTokenType.User
        && Strings.isNotEmpty(requestOptions.getTenantAccessToken())) {
      throw new IllegalArgumentException("user token type not match tenant access token");
    }

    if (accessTokenType == AccessTokenType.User
        && Strings.isEmpty(requestOptions.getUserAccessToken())) {
      throw new IllegalArgumentException("user access token is blank");
    }

    if (requestOptions.getHeaders() != null && requestOptions.getHeaders().size() > 0) {
      requestOptions.getHeaders().entrySet().stream().forEach(entry -> {
        if (entry.getKey().equalsIgnoreCase(Constants.HTTP_HEADER_KEY_REQUEST_ID)) {
          throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
              , entry.getKey()));
        }

        if (entry.getKey().equalsIgnoreCase(Constants.HTTP_HEADER_KEY_LOG_ID)) {
          throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
              , entry.getKey()));
        }

        if (entry.getKey().equalsIgnoreCase(Constants.HTTP_HEADER_REQUEST_ID)) {
          throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
              , entry.getKey()));
        }
      });
    }
  }

  public static RawResponse send(Config config
      , RequestOptions requestOptions
      , String methodType
      , String path
      , Set<AccessTokenType> accessTokenTypeSet
      , Object req) throws Exception {
    try {
      // 避免NPE
      if (requestOptions == null) {
        requestOptions = new RequestOptions();
      }

      // 确定token类型
      AccessTokenType accessTokenType = determineTokenType(accessTokenTypeSet
          , requestOptions
          , config.isDisableTokenCache());

      // 参数校验
      validate(config, requestOptions, accessTokenType);

      // 具体处理
      return doSend(config, methodType, path, accessTokenType, req, requestOptions);
    } catch (InterruptedIOException e) {
      log.error("send error:{},{}", methodType, path, e);
      if ("timeout".equals(e.getMessage())) {
        throw new ClientTimeoutException();
      }
      throw e;

    } catch (Throwable e) {
      throw e;
    }
  }

  private static void logReq(RawRequest req, String httpPath, boolean isUpload) {
    try {
      if (null == req) {
        return;
      }

      if (!isUpload) {
        log.debug("req,path:{},header:{},body:{}", httpPath
            , Jsons.LONG_TO_STR.toJson(req.getHeaders())
            , req.getBody() == null ? "" : Jsons.LONG_TO_STR.toJson(req.getBody()));
      } else {
        log.debug("req,path:{},header:{}", httpPath, req.getHeaders());
      }
    } catch (Throwable e) {
      log.error("logReq error:{}", e);
    }
  }

  private static RawResponse doSend(Config config, String httpMethod, String httpPath,
      AccessTokenType accessTokenType, Object req, RequestOptions requestOptions) throws Exception {
    Exception error = null;
    for (int i = 0; i < 2; i++) {
      try {
        // 参数转换
        RawRequest request = REQ_TRANSLATOR.translate(req, accessTokenType, config, httpMethod,
            httpPath, requestOptions);

        // 打印日志
        if (config.isLogReqAtDebug()) {
          logReq(request, httpMethod, requestOptions.isSupportUpload());
        }

        // 执行调用
        IHttpTransport httpTransport = config.getHttpTransport();
        if (httpTransport == null) {
          httpTransport = new OkHttpTransport(OKHttps.defaultClient);
        }
        RawResponse rawResponse = httpTransport.execute(request);

        // 打印日志
        if (config.isLogReqAtDebug() || accessTokenType != AccessTokenType.None) {
          if (requestOptions.isSupportDownLoad()) {
            log.debug("resp,path:{},code:{},header:{}", httpPath, rawResponse.getStatusCode(),
                rawResponse.getHeaders());
          } else {
            log.debug("resp,path:{},code:{},header:{},body:{}", httpPath,
                rawResponse.getStatusCode(), rawResponse.getHeaders(),
                new String(rawResponse.getBody(), StandardCharsets.UTF_8));
          }
        }

        // 服务端超时
        if (rawResponse.getStatusCode() == 504) {
          log.error(String.format("httpMethod:%s,httpPath:%s, server time out,reqId:%s", httpMethod,
              httpPath, rawResponse.getRequestID()));
          throw new ServerTimeoutException();
        }

        return rawResponse;
      } catch (Exception e) {
        error = e;
        // 获取token失败，重试一次，其他请求不重试
        if (accessTokenType != AccessTokenType.None) {
          throw e;
        }
      }
    }
    throw error;
  }
}
