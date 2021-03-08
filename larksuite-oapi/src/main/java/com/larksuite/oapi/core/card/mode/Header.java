package com.larksuite.oapi.core.card.mode;

public class Header {
    public static final String X_LARK_REQUEST_TIMESTAMP = "X-Lark-Request-Timestamp";
    public static final String X_LARK_REQUEST_NONCE = "X-Lark-Request-Nonce";
    public static final String X_LARK_SIGNATURE = "X-Lark-Signature";
    public static final String X_REFRESH_TOKEN = "X-Refresh-Token";
    private final String timestamp;
    private final String nonce;
    private final String signature;
    private final String refreshToken;

    public Header(String timestamp, String nonce, String signature, String refreshToken) {
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.signature = signature;
        this.refreshToken = refreshToken;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public String getSignature() {
        return signature;
    }

    public String getRefreshToken() {
        return refreshToken;
    }


    @Override
    public String toString() {
        return "{" +
                "timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", signature='" + signature + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
