// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class GetDocumentBlockChildrenReq {
    @Query
    @SerializedName("document_revision_id")
    private Integer documentRevisionId;
    @Query
    @SerializedName("page_token")
    private String pageToken;
    @Query
    @SerializedName("page_size")
    private Integer pageSize;
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("document_id")
    private String documentId;
    @Path
    @SerializedName("block_id")
    private String blockId;

    // builder 开始
    public GetDocumentBlockChildrenReq() {
    }

    public GetDocumentBlockChildrenReq(Builder builder) {
        this.documentRevisionId = builder.documentRevisionId;
        this.pageToken = builder.pageToken;
        this.pageSize = builder.pageSize;
        this.userIdType = builder.userIdType;
        this.documentId = builder.documentId;
        this.blockId = builder.blockId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getDocumentRevisionId() {
        return this.documentRevisionId;
    }

    public void setDocumentRevisionId(Integer documentRevisionId) {
        this.documentRevisionId = documentRevisionId;
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

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getDocumentId() {
        return this.documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getBlockId() {
        return this.blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public static class Builder {
        private Integer documentRevisionId;
        private String pageToken;
        private Integer pageSize;
        private String userIdType;
        private String documentId;
        private String blockId;

        public Builder documentRevisionId(Integer documentRevisionId) {
            this.documentRevisionId = documentRevisionId;
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

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.docx.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder documentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public Builder blockId(String blockId) {
            this.blockId = blockId;
            return this;
        }

        public GetDocumentBlockChildrenReq build() {
            return new GetDocumentBlockChildrenReq(this);
        }
    }
}