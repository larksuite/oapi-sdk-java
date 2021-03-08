package com.larksuite.oapi.core.api.response;

import com.larksuite.oapi.core.Context;

public class Response<Data> {
    private transient final Context context;

    private int code;
    private String msg;
    private Error error;
    private Data data;

    public Response(Context context) {
        this.context = context;
        this.code = 0;
        this.msg = "";
    }

    public void setBody(Body body) {
        this.code = body.getCode();
        this.msg = body.getMsg();
        this.error = body.getError();
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getRequestID() {
        return this.context.getRequestID();
    }

    public int getHTTPStatusCode() {
        return this.context.getHTTPStatusCode();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Error getError() {
        return error;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "http status code:" + getHTTPStatusCode() + ", request id:" + getRequestID() + ", response:{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                ", data=omit..." +
                '}';
    }
}
