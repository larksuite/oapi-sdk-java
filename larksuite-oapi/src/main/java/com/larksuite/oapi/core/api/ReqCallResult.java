package com.larksuite.oapi.core.api;

import com.larksuite.oapi.core.api.response.Response;

public class ReqCallResult<I, O> {
    private final ReqCaller<I, O> reqCaller;
    private final Response<O> response;
    private final Exception exception;


    public ReqCallResult(ReqCaller<I, O> reqCaller) {
        this.reqCaller = reqCaller;
        this.response = reqCaller.getResponse();
        this.exception = reqCaller.getException();
    }

    public ReqCaller<I, O> getReqCaller() {
        return reqCaller;
    }

    public Response<O> getResponse() {
        return response;
    }

    public Exception getException() {
        return exception;
    }
}
