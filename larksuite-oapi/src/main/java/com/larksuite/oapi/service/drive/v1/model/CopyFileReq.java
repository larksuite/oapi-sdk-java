// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class CopyFileReq {
    @Path
    @SerializedName("file_token")
    private String fileToken;
    @Body
    private CopyFileReqBody body;

    // builder 开始
    public CopyFileReq() {
    }

    public CopyFileReq(Builder builder) {
        this.fileToken = builder.fileToken;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    public CopyFileReqBody getCopyFileReqBody() {
        return this.body;
    }

    public void setCopyFileReqBody(CopyFileReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String fileToken;
        private CopyFileReqBody body;

        public Builder fileToken(String fileToken) {
            this.fileToken = fileToken;
            return this;
        }

        public CopyFileReqBody getCopyFileReqBody() {
            return this.body;
        }

        public Builder copyFileReqBody(CopyFileReqBody body) {
            this.body = body;
            return this;
        }

        public CopyFileReq build() {
            return new CopyFileReq(this);
        }
    }
}
