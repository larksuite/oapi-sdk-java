// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class GetImageReq {
    @Path
    @SerializedName("image_key")
    private String imageKey;

    // builder 开始
    public GetImageReq() {
    }

    public GetImageReq(Builder builder) {
        this.imageKey = builder.imageKey;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public static class Builder {

        private String imageKey;

        public Builder imageKey(String imageKey) {
            this.imageKey = imageKey;
            return this;
        }

        public GetImageReq build() {
            return new GetImageReq(this);
        }
    }
}
