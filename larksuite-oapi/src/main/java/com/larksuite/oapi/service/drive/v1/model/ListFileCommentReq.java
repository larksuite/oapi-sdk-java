// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class ListFileCommentReq {
    @Query
    @SerializedName("file_type")
    private String fileType;
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Query
    @SerializedName("is_solved")
    private Boolean isSolved;
    @Query
    @SerializedName("page_token")
    private String pageToken;
    @Query
    @SerializedName("page_size")
    private Integer pageSize;
    @Path
    @SerializedName("file_token")
    private String fileToken;

    // builder 开始
    public ListFileCommentReq() {
    }

    public ListFileCommentReq(Builder builder) {
        this.fileType = builder.fileType;
        this.userIdType = builder.userIdType;
        this.isSolved = builder.isSolved;
        this.pageToken = builder.pageToken;
        this.pageSize = builder.pageSize;
        this.fileToken = builder.fileToken;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public Boolean getIsSolved() {
        return this.isSolved;
    }

    public void setIsSolved(Boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    public static class Builder {
        private String fileType;
        private String userIdType;
        private Boolean isSolved;
        private String pageToken;
        private Integer pageSize;
        private String fileToken;

        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder fileType(com.larksuite.oapi.service.drive.v1.enums.FileTypeEnum fileType) {
            this.fileType = fileType.getValue();
            return this;
        }

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.drive.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder isSolved(Boolean isSolved) {
            this.isSolved = isSolved;
            return this;
        }

        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder fileToken(String fileToken) {
            this.fileToken = fileToken;
            return this;
        }

        public ListFileCommentReq build() {
            return new ListFileCommentReq(this);
        }
    }
}