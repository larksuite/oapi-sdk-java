package com.larksuite.oapi.core.response;


import com.larksuite.oapi.core.response.error.Error;

public class BaseResponse {

    private RawResponse rawResponse;
    private int code;
    private String msg;
    private Error error;

    public BaseResponse() {
    }

    public RawResponse getRawResponse() {
        return rawResponse;
    }

    public void setRawResponse(RawResponse rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRequestId() {
        if (rawResponse != null) {
            return rawResponse.getRequestID();
        }
        return "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean success() {
        return code == 0;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }


}
