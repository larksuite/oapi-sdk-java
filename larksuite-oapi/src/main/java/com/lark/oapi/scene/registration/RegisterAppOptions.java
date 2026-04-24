package com.lark.oapi.scene.registration;

import java.util.function.Consumer;

public class RegisterAppOptions {
    private String source;
    private String domain;
    private String larkDomain;
    private Consumer<QRCodeInfo> onQRCode;
    private Consumer<StatusChangeInfo> onStatusChange;

    private RegisterAppOptions() {
    }

    public String getSource() {
        return source;
    }

    public String getDomain() {
        return domain;
    }

    public String getLarkDomain() {
        return larkDomain;
    }

    public Consumer<QRCodeInfo> getOnQRCode() {
        return onQRCode;
    }

    public Consumer<StatusChangeInfo> getOnStatusChange() {
        return onStatusChange;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final RegisterAppOptions options = new RegisterAppOptions();

        public Builder source(String source) {
            options.source = source;
            return this;
        }

        public Builder domain(String domain) {
            options.domain = domain;
            return this;
        }

        public Builder larkDomain(String larkDomain) {
            options.larkDomain = larkDomain;
            return this;
        }

        public Builder onQRCode(Consumer<QRCodeInfo> callback) {
            options.onQRCode = callback;
            return this;
        }

        public Builder onStatusChange(Consumer<StatusChangeInfo> callback) {
            options.onStatusChange = callback;
            return this;
        }

        public RegisterAppOptions build() {
            return options;
        }
    }
}
