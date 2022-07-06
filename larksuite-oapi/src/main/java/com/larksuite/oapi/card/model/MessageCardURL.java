package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardURL {
    @SerializedName("url")
    private String url;
    @SerializedName("android_url")
    private String androidUrl;
    @SerializedName("ios_url")
    private String iosUrl;
    @SerializedName("pc_url")
    private String pcUrl;

    public MessageCardURL(Builder builder) {
        this.url = builder.url;
        this.androidUrl = builder.androidUrl;
        this.iosUrl = builder.iosUrl;
        this.pcUrl = builder.pcUrl;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String url;
        private String androidUrl;
        private String iosUrl;
        private String pcUrl;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder androidUrl(String androidUrl) {
            this.androidUrl = androidUrl;
            return this;
        }

        public Builder iosUrl(String iosUrl) {
            this.iosUrl = iosUrl;
            return this;
        }

        public Builder pcUrl(String pcUrl) {
            this.pcUrl = pcUrl;
            return this;
        }

        public MessageCardURL build() {
            return new MessageCardURL(this);
        }
    }
}
