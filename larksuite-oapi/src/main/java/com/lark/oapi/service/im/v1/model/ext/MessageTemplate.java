package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.utils.Jsons;

public class MessageTemplate {

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        @SerializedName("type")
        private final String type = "template";

        @SerializedName("data")
        private MessageTemplateData data;

        public Builder data(MessageTemplateData data) {
            this.data = data;
            return this;
        }

        public String build() {
            return Jsons.DEFAULT.toJson(this);
        }
    }

}
