// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;

public class MatchInfo {
    @SerializedName("entity_id")
    private String entityId;
    @SerializedName("type")
    private Integer type;

    // builder 开始
    public MatchInfo() {
    }

    public MatchInfo(Builder builder) {
        this.entityId = builder.entityId;
        this.type = builder.type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class Builder {
        private String entityId;
        private Integer type;

        public Builder entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder type(com.larksuite.oapi.service.baike.v1.enums.TermTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        public MatchInfo build() {
            return new MatchInfo(this);
        }
    }
}