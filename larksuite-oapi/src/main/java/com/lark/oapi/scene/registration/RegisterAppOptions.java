package com.lark.oapi.scene.registration;

import java.util.function.Consumer;

public class RegisterAppOptions {
    private String source;
    private String domain;
    private String larkDomain;
    private AppPreset appPreset;
    private AppAddons addons;
    private String appId;
    private boolean createOnly;
    private Consumer<QRCodeInfo> onQRCode;
    private Consumer<StatusChangeInfo> onStatusChange;

    private RegisterAppOptions() {
    }

    public static Builder newBuilder() {
        return new Builder();
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

    public AppPreset getAppPreset() {
        return appPreset;
    }

    public AppAddons getAddons() {
        return addons;
    }

    public String getAppId() {
        return appId;
    }

    public boolean isCreateOnly() {
        return createOnly;
    }

    public Consumer<QRCodeInfo> getOnQRCode() {
        return onQRCode;
    }

    public Consumer<StatusChangeInfo> getOnStatusChange() {
        return onStatusChange;
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

        public Builder appPreset(AppPreset appPreset) {
            options.appPreset = appPreset;
            return this;
        }

        public Builder addons(AppAddons addons) {
            options.addons = addons;
            return this;
        }

        public Builder appId(String appId) {
            options.appId = appId;
            return this;
        }

        public Builder createOnly(boolean createOnly) {
            options.createOnly = createOnly;
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
