package com.lark.oapi.core.accesstoken;

import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Strings;

public class AccessTokenError extends Exception {
    private final int statusCode;
    private final int code;
    private final String errorType;
    private final String errorDescription;
    private final RawResponse rawResponse;

    public AccessTokenError(int statusCode, int code, String errorType, String errorDescription,
                            RawResponse rawResponse) {
        super(bestMessage(errorDescription, errorType));
        this.statusCode = statusCode;
        this.code = code;
        this.errorType = errorType;
        this.errorDescription = errorDescription;
        this.rawResponse = rawResponse;
    }

    private static String bestMessage(String errorDescription, String errorType) {
        if (Strings.isNotEmpty(errorDescription)) {
            return errorDescription;
        }
        if (Strings.isNotEmpty(errorType)) {
            return errorType;
        }
        return "access token request failed";
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getCode() {
        return code;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public RawResponse getRawResponse() {
        return rawResponse;
    }
}
