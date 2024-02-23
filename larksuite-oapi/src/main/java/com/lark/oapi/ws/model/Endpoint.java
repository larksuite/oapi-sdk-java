package com.lark.oapi.ws.model;

import com.google.gson.annotations.SerializedName;

public class Endpoint {
    @SerializedName("URL")
    private String url;
    @SerializedName("ClientConfig")
    private ClientConfig clientConfig;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClientConfig getClientConfig() {
        return clientConfig;
    }

    public void setClientConfig(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }
}
