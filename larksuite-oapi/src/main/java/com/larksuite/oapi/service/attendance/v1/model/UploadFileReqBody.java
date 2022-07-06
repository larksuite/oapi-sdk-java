// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

import java.io.File;

public class UploadFileReqBody {
    @SerializedName("file")
    private File file;

    // builder 开始
    public UploadFileReqBody() {
    }

    public UploadFileReqBody(Builder builder) {
        this.file = builder.file;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public static class Builder {
        private File file;

        public Builder file(File file) {
            this.file = file;
            return this;
        }


        public UploadFileReqBody build() {
            return new UploadFileReqBody(this);
        }
    }
}