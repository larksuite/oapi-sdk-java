package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.utils.Jsons;

public class MessageMedia {
    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        @SerializedName("file_key")
        private String fileKey;
        @SerializedName("image_key")
        private String imageKey;

        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        public Builder imageKey(String imageKey) {
            this.imageKey = imageKey;
            return this;
        }


        public String build() {
            return Jsons.LONG_TO_STR_GSON.toJson(this);
        }
    }
}
