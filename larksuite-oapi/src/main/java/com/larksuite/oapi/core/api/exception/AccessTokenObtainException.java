package com.larksuite.oapi.core.api.exception;

import com.larksuite.oapi.core.api.response.Response;

public class AccessTokenObtainException extends RuntimeException {
    private Response response;

    public AccessTokenObtainException(String messagePrefix, Response response) {
        super(messagePrefix + response.toString());
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
