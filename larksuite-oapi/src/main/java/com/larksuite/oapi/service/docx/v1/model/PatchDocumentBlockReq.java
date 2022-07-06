// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class PatchDocumentBlockReq {
    @Query
    @SerializedName("document_revision_id")
    private Integer documentRevisionId;
    @Query
    @SerializedName("client_token")
    private String clientToken;
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("document_id")
    private String documentId;
    @Path
    @SerializedName("block_id")
    private String blockId;
    @Body
    private UpdateBlockRequest body;

    // builder 开始
    public PatchDocumentBlockReq() {
    }

    public PatchDocumentBlockReq(Builder builder) {
        this.documentRevisionId = builder.documentRevisionId;
        this.clientToken = builder.clientToken;
        this.userIdType = builder.userIdType;
        this.documentId = builder.documentId;
        this.blockId = builder.blockId;
        this.body = builder.body;
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

    public String getClientToken() {
        return this.clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
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

    public UpdateBlockRequest getUpdateBlockRequest() {
        return this.body;
    }

    public void setUpdateBlockRequest(UpdateBlockRequest body) {
        this.body = body;
    }

    public static class Builder {
        private Integer documentRevisionId;
        private String clientToken;
        private String userIdType;
        private String documentId;
        private String blockId;
        private UpdateBlockRequest body;

        public Builder documentRevisionId(Integer documentRevisionId) {
            this.documentRevisionId = documentRevisionId;
            return this;
        }

        public Builder clientToken(String clientToken) {
            this.clientToken = clientToken;
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

        public UpdateBlockRequest getUpdateBlockRequest() {
            return this.body;
        }

        public Builder updateBlockRequest(UpdateBlockRequest body) {
            this.body = body;
            return this;
        }

        public PatchDocumentBlockReq build() {
            return new PatchDocumentBlockReq(this);
        }
    }
}
