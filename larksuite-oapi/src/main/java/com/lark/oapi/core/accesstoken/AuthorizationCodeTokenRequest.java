package com.lark.oapi.core.accesstoken;

public class AuthorizationCodeTokenRequest {
    private final String code;
    private final String redirectUri;
    private final String codeVerifier;
    private final String scope;

    private AuthorizationCodeTokenRequest(Builder builder) {
        this.code = builder.code;
        this.redirectUri = builder.redirectUri;
        this.codeVerifier = builder.codeVerifier;
        this.scope = builder.scope;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCode() {
        return code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    public String getScope() {
        return scope;
    }

    public static final class Builder {
        private String code;
        private String redirectUri;
        private String codeVerifier;
        private String scope;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        public Builder codeVerifier(String codeVerifier) {
            this.codeVerifier = codeVerifier;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public AuthorizationCodeTokenRequest build() {
            return new AuthorizationCodeTokenRequest(this);
        }
    }
}
