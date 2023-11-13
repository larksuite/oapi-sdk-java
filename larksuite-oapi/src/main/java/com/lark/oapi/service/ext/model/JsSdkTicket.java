package com.lark.oapi.service.ext.model;

import com.google.gson.annotations.SerializedName;

public class JsSdkTicket {

    @SerializedName("expires_in")
    private Integer expiresIn;

    @SerializedName("ticket")
    private String ticket;

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "JsSdkTicket{" +
            "expiresIn=" + expiresIn +
            ", ticket='" + ticket + '\'' +
            '}';
    }
}
