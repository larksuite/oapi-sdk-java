package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardConfig {
    @SerializedName("enable_forward")
    private Boolean enableForward;
    @SerializedName("update_multi")
    private Boolean updateMulti;
    @SerializedName("wide_screen_mode")
    private Boolean wideScreenMode;

    public MessageCardConfig(Builder builder) {
        this.enableForward = builder.enableForward;
        this.updateMulti = builder.updateMulti;
        this.wideScreenMode = builder.wideScreenMode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getEnableForward() {
        return enableForward;
    }

    public void setEnableForward(Boolean enableForward) {
        this.enableForward = enableForward;
    }

    public Boolean getUpdateMulti() {
        return updateMulti;
    }

    public void setUpdateMulti(Boolean updateMulti) {
        this.updateMulti = updateMulti;
    }

    public Boolean getWideScreenMode() {
        return wideScreenMode;
    }

    public void setWideScreenMode(Boolean wideScreenMode) {
        this.wideScreenMode = wideScreenMode;
    }

    public static class Builder {
        private Boolean enableForward;
        private Boolean updateMulti;
        private Boolean wideScreenMode;

        public Builder enableForward(Boolean enableForward) {
            this.enableForward = enableForward;
            return this;
        }

        public Builder updateMulti(Boolean updateMulti) {
            this.updateMulti = updateMulti;
            return this;
        }

        public Builder wideScreenMode(Boolean wideScreenMode) {
            this.wideScreenMode = wideScreenMode;
            return this;
        }

        public MessageCardConfig build() {
            return new MessageCardConfig(this);
        }

    }
}
