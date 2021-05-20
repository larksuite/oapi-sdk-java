package com.larksuite.oapi.core.api.request;

import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.request.requestoptfn.*;
import com.larksuite.oapi.okhttp3_14.Response;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Request<I, O> extends BaseRequest<I, O> {

    private com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder;
    private Response httpResponse;

    private byte[] requestBody;
    private String requestBodyFilePath;
    private InputStream requestBodyStream;
    private String contentType;
    private com.larksuite.oapi.core.api.response.Response<O> response;

    private Request(String httpPath, String httpMethod, AccessTokenType accessTokenType,
                    I input, O output, RequestOptFn... requestOptFns) {
        super(httpPath, httpMethod, accessTokenType, input, output, requestOptFns);
    }

    private Request(String httpPath, String httpMethod, AccessTokenType[] accessTokenTypes,
                    I input, O output, RequestOptFn... requestOptFns) {
        super(httpPath, httpMethod, accessTokenTypes, input, output, requestOptFns);
    }

    public static <I, O> Request<I, O> newRequestByAuth(String httpPath, String httpMethod, I input, O output) {
        return new Request<I, O>(httpPath, httpMethod, AccessTokenType.None, input, output, Request.setNotDataField());
    }

    public static <I, O> Request<I, O> newRequest(String httpPath, String httpMethod, AccessTokenType[] accessTokenTypes,
                                                  I input, O output, RequestOptFn... requestOptFns) {
        return new <I, O>Request<I, O>(httpPath, httpMethod, accessTokenTypes, input, output, requestOptFns);
    }

    public static <I, O> Request<I, O> newRequest(String httpPath, String httpMethod, AccessTokenType accessTokenType,
                                                  I input, O output, RequestOptFn... requestOptFns) {
        return newRequest(httpPath, httpMethod, new AccessTokenType[]{accessTokenType}, input, output, requestOptFns);
    }

    public static RequestOptFn setNotDataField() {
        return new NotDataField();
    }

    public static RequestOptFn setResponseStream() {
        return new ResponseStream();
    }

    public static RequestOptFn setTimeout(int time, TimeUnit timeUnit) {
        return new Timeout(time, timeUnit);
    }

    public static RequestOptFn setPathParams(Map<String, Object> pathParams) {
        return new PathParams(pathParams);
    }

    public static RequestOptFn setQueryParams(Map<String, Object> queryParams) {
        return new QueryParams(queryParams);
    }

    public static RequestOptFn setTenantKey(String tenantKey) {
        return new TenantKey(tenantKey);
    }

    public static RequestOptFn setUserAccessToken(String userAccessToken) {
        return new UserAccessToken(userAccessToken);
    }

    public static RequestOptFn setSupportLongDataType() {
        return new SupportLongDatatype();
    }

    @Override
    public String toString() {
        return getHttpMethod() + " " + url() + " " + getAccessTokenType();
    }

    public com.larksuite.oapi.okhttp3_14.Request.Builder getHttpRequestBuilder() {
        return httpRequestBuilder;
    }

    public void setHttpRequestBuilder(com.larksuite.oapi.okhttp3_14.Request.Builder httpRequestBuilder) {
        this.httpRequestBuilder = httpRequestBuilder;
    }

    public Response getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(Response httpResponse) {
        this.httpResponse = httpResponse;
    }

    public String getRequestBodyFilePath() {
        return requestBodyFilePath;
    }

    public void setRequestBodyFilePath(String requestBodyFilePath) {
        this.requestBodyFilePath = requestBodyFilePath;
    }

    public byte[] getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(byte[] requestBody) {
        this.requestBody = requestBody;
    }

    public InputStream getRequestBodyStream() {
        return requestBodyStream;
    }

    public void setRequestBodyStream(InputStream requestBodyStream) {
        this.requestBodyStream = requestBodyStream;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public com.larksuite.oapi.core.api.response.Response<O> getResponse() {
        return response;
    }

    public void setResponse(com.larksuite.oapi.core.api.response.Response<O> response) {
        this.response = response;
    }
}
