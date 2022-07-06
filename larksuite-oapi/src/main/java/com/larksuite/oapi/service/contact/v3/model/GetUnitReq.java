// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class GetUnitReq {
    @Path
    @SerializedName("unit_id")
    private String unitId;

    // builder 开始
    public GetUnitReq() {
    }

    public GetUnitReq(Builder builder) {
        this.unitId = builder.unitId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public static class Builder {

        private String unitId;

        public Builder unitId(String unitId) {
            this.unitId = unitId;
            return this;
        }

        public GetUnitReq build() {
            return new GetUnitReq(this);
        }
    }
}
