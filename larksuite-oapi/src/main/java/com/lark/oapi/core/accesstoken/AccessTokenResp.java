package com.lark.oapi.core.accesstoken;

import com.lark.oapi.core.response.RawResponse;

public class AccessTokenResp {
    private final int statusCode;
    private final RawResponse rawResponse;
    private final AccessTokenRespData data;

    public AccessTokenResp(int statusCode, RawResponse rawResponse, AccessTokenRespData data) {
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public RawResponse getRawResponse() {
        return rawResponse;
    }

    public AccessTokenRespData getData() {
        return data;
    }
}
