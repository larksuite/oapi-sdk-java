package com.lark.oapi.ws.model;

public class EndpointResp {
    private int code;
    private String msg;
    private Endpoint data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Endpoint getData() {
        return data;
    }

    public void setData(Endpoint data) {
        this.data = data;
    }
}
