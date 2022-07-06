package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.utils.Jsons;

public class MessageSticker {
    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        @SerializedName("file_key")
        private String fileKey;

        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }


        public String build() {
            return Jsons.LONG_TO_STR_GSON.toJson(this);
        }
    }
}
