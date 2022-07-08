package com.larksuite.oapi.core;

import com.larksuite.oapi.core.exception.AccessTokenTypeInvalidException;
import com.larksuite.oapi.core.exception.ClientTimeoutException;
import com.larksuite.oapi.core.exception.NeedAccessTokenException;
import com.larksuite.oapi.core.httpclient.IHttpTransport;
import com.larksuite.oapi.core.httpclient.OkHttpTransport;
import com.larksuite.oapi.core.request.RawRequest;
import com.larksuite.oapi.core.request.ReqTranslator;
import com.larksuite.oapi.core.request.RequestOptions;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.OKHttps;
import com.larksuite.oapi.core.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class Transport {
    private static final Logger log = LoggerFactory.getLogger(Transport.class);
    private static final ReqTranslator REQ_TRANSLATOR = new ReqTranslator();

    private static AccessTokenType determineTokenType(Set<AccessTokenType> accessTokenTypeSet, RequestOptions requestOptions, boolean disableTokenCache) {
        if (accessTokenTypeSet.contains(AccessTokenType.None)) {
            return AccessTokenType.None;
        }

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

            throw new NeedAccessTokenException();
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

        throw new AccessTokenTypeInvalidException();
    }

    private static void validate(Config config, RequestOptions requestOptions, AccessTokenType accessTokenType) {
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

        if (accessTokenType == AccessTokenType.User
                && Strings.isEmpty(requestOptions.getUserAccessToken())) {
            throw new IllegalArgumentException("user access token is blank");
        }

        if (requestOptions.getHeaders() != null && requestOptions.getHeaders().size() > 0) {
            if (requestOptions.getHeaders().containsKey(Constants.HTTP_HEADER_KEY_REQUEST_ID)) {
                throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
                        , Constants.HTTP_HEADER_KEY_REQUEST_ID));
            }

            if (requestOptions.getHeaders().containsKey(Constants.HTTP_HEADER_KEY_LOG_ID)) {
                throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
                        , Constants.HTTP_HEADER_KEY_LOG_ID));
            }

            if (requestOptions.getHeaders().containsKey(Constants.HTTP_HEADER_REQUEST_ID)) {
                throw new IllegalArgumentException(String.format("pass %s as header key is not allowed"
                        , Constants.HTTP_HEADER_REQUEST_ID));
            }
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
                log.debug("req,path:{},header:{},body:{}", httpPath, req.getHeaders()
                        , req.getBody() == null ? "" : Jsons.LONG_TO_STR_GSON.toJson(req.getBody()));
            } else {
                log.debug("req,path:{},header:{}", httpPath, req.getHeaders());
            }
        } catch (Throwable e) {
            log.error("logReq error:{}", e);
        }
    }

    private static RawResponse doSend(Config config, String httpMethod, String httpPath, AccessTokenType accessTokenType, Object req, RequestOptions requestOptions) throws Exception {
        Exception error = null;
        for (int i = 0; i < 2; i++) {
            try {
                // 参数转换
                RawRequest request = REQ_TRANSLATOR.translate(req, accessTokenType, config, httpMethod, httpPath, requestOptions);

                // 打印日志
                if (config.isLogReqRespInfoAtDebugLevel()) {
                    logReq(request, httpMethod, requestOptions.isSupportUpload());
                }

                // 执行调用
                IHttpTransport httpTransport = config.getHttpTransport();
                if (httpTransport == null) {
                    httpTransport = new OkHttpTransport(OKHttps.defaultClient);
                }
                RawResponse rawResponse = httpTransport.execute(request);

                // 打印日志
                if (config.isLogReqRespInfoAtDebugLevel() || accessTokenType != AccessTokenType.None) {
                    if (requestOptions.isSupportDownLoad()) {
                        log.debug("resp,path:{},code:{},header:{}", httpPath, rawResponse.getStatusCode(), rawResponse.getHeaders());
                    } else {
                        log.debug("resp,path:{},code:{},header:{},body:{}", httpPath, rawResponse.getStatusCode(), rawResponse.getHeaders(), new String(rawResponse.getBody(), StandardCharsets.UTF_8));
                    }
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
