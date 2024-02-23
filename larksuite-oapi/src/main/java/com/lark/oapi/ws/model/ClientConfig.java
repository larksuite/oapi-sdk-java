package com.lark.oapi.ws.model;

import com.google.gson.annotations.SerializedName;

public class ClientConfig {
    @SerializedName("ReconnectCount")
    private Integer reconnectCount;
    @SerializedName("ReconnectInterval")
    private Integer reconnectInterval;
    @SerializedName("ReconnectNonce")
    private Integer reconnectNonce;
    @SerializedName("PingInterval")
    private Integer pingInterval;

    public Integer getReconnectCount() {
        return reconnectCount;
    }

    public void setReconnectCount(Integer reconnectCount) {
        this.reconnectCount = reconnectCount;
    }

    public Integer getReconnectInterval() {
        return reconnectInterval;
    }

    public void setReconnectInterval(Integer reconnectInterval) {
        this.reconnectInterval = reconnectInterval;
    }

    public Integer getReconnectNonce() {
        return reconnectNonce;
    }

    public void setReconnectNonce(Integer reconnectNonce) {
        this.reconnectNonce = reconnectNonce;
    }

    public Integer getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(Integer pingInterval) {
        this.pingInterval = pingInterval;
    }
}
