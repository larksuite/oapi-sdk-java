package com.lark.oapi.service.ext.model;

public class JsSdkSignature {

    private String appid;

    private String ticket;

    private String signature;

    private String noncestr;

    private String timestamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "JsSdkSignature{" +
            "appid='" + appid + '\'' +
            ", ticket='" + ticket + '\'' +
            ", signature='" + signature + '\'' +
            ", noncestr='" + noncestr + '\'' +
            ", timestamp='" + timestamp + '\'' +
            '}';
    }
}
