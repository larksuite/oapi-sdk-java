// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class ReserveCallSetting {
    @SerializedName("callee")
    private ReserveCallee callee;

    // builder 开始
    public ReserveCallSetting() {
    }

    public ReserveCallSetting(Builder builder) {
        this.callee = builder.callee;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ReserveCallee getCallee() {
        return this.callee;
    }

    public void setCallee(ReserveCallee callee) {
        this.callee = callee;
    }

    public static class Builder {
        private ReserveCallee callee;

        public Builder callee(ReserveCallee callee) {
            this.callee = callee;
            return this;
        }


        public ReserveCallSetting build() {
            return new ReserveCallSetting(this);
        }
    }
}
