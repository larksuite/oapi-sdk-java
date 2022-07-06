// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DownloadFileReq {
    @Path
    @SerializedName("file_id")
    private String fileId;

    // builder 开始
    public DownloadFileReq() {
    }

    public DownloadFileReq(Builder builder) {
        this.fileId = builder.fileId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public static class Builder {

        private String fileId;

        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }

        public DownloadFileReq build() {
            return new DownloadFileReq(this);
        }
    }
}