// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class MoveDocsToWikiSpaceNodeReq {
    @Path
    @SerializedName("space_id")
    private Long spaceId;
    @Body
    private MoveDocsToWikiSpaceNodeReqBody body;

    // builder 开始
    public MoveDocsToWikiSpaceNodeReq() {
    }

    public MoveDocsToWikiSpaceNodeReq(Builder builder) {
        this.spaceId = builder.spaceId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getSpaceId() {
        return this.spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public MoveDocsToWikiSpaceNodeReqBody getMoveDocsToWikiSpaceNodeReqBody() {
        return this.body;
    }

    public void setMoveDocsToWikiSpaceNodeReqBody(MoveDocsToWikiSpaceNodeReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private Long spaceId;
        private MoveDocsToWikiSpaceNodeReqBody body;

        public Builder spaceId(Long spaceId) {
            this.spaceId = spaceId;
            return this;
        }

        public MoveDocsToWikiSpaceNodeReqBody getMoveDocsToWikiSpaceNodeReqBody() {
            return this.body;
        }

        public Builder moveDocsToWikiSpaceNodeReqBody(MoveDocsToWikiSpaceNodeReqBody body) {
            this.body = body;
            return this;
        }

        public MoveDocsToWikiSpaceNodeReq build() {
            return new MoveDocsToWikiSpaceNodeReq(this);
        }
    }
}
