package com.lark.oapi.ws.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Response {
    @SerializedName("code")
    private int statusCode;
    private Map<String, String> headers;
    private byte[] data;

    public Response() {}

    public Response(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
