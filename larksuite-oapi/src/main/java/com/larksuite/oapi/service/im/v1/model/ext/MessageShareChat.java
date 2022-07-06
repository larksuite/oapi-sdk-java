package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.utils.Jsons;

public class MessageShareChat {
    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        @SerializedName("chat_id")
        private String chatId;

        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }


        public String build() {
            return Jsons.LONG_TO_STR_GSON.toJson(this);
        }
    }
}
