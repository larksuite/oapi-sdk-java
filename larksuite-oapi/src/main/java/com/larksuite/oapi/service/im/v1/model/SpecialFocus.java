// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class SpecialFocus {
    @SerializedName("id")
    private String id;
    @SerializedName("id_type")
    private String idType;

    // builder 开始
    public SpecialFocus() {
    }

    public SpecialFocus(Builder builder) {
        this.id = builder.id;
        this.idType = builder.idType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return this.idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public static class Builder {
        private String id;
        private String idType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder idType(String idType) {
            this.idType = idType;
            return this;
        }

        public Builder idType(com.larksuite.oapi.service.im.v1.enums.IdTypeEnum idType) {
            this.idType = idType.getValue();
            return this;
        }


        public SpecialFocus build() {
            return new SpecialFocus(this);
        }
    }
}
