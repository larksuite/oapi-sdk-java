// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class PatchUnitReq {
    @Path
    @SerializedName("unit_id")
    private String unitId;
    @Body
    private PatchUnitReqBody body;

    // builder 开始
    public PatchUnitReq() {
    }

    public PatchUnitReq(Builder builder) {
        this.unitId = builder.unitId;
        this.body = builder.body;
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

    public PatchUnitReqBody getPatchUnitReqBody() {
        return this.body;
    }

    public void setPatchUnitReqBody(PatchUnitReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String unitId;
        private PatchUnitReqBody body;

        public Builder unitId(String unitId) {
            this.unitId = unitId;
            return this;
        }

        public PatchUnitReqBody getPatchUnitReqBody() {
            return this.body;
        }

        public Builder patchUnitReqBody(PatchUnitReqBody body) {
            this.body = body;
            return this;
        }

        public PatchUnitReq build() {
            return new PatchUnitReq(this);
        }
    }
}
