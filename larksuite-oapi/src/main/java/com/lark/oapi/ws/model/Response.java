package com.lark.oapi.ws.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.JsonAdapter;
import com.lark.oapi.core.utils.Base64TypeAdapterFactory;

import java.util.Map;

public class Response {
    @SerializedName("code")
    private int statusCode;
    @SerializedName("headers")
    private Map<String, String> headers;
    @SerializedName("data")
    @JsonAdapter(Base64TypeAdapterFactory.class)
    private byte[] data;

    public Response() {
    }

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
