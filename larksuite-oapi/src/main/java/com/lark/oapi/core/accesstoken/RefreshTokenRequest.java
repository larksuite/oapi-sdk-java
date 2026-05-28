package com.lark.oapi.core.accesstoken;

public class RefreshTokenRequest {
    private final String refreshToken;
    private final String scope;

    private RefreshTokenRequest(Builder builder) {
        this.refreshToken = builder.refreshToken;
        this.scope = builder.scope;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public static final class Builder {
        private String refreshToken;
        private String scope;

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public RefreshTokenRequest build() {
            return new RefreshTokenRequest(this);
        }
    }
}
