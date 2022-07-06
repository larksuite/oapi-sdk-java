// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class Navigate {
    @SerializedName("pc")
    private NavigateMeta pc;
    @SerializedName("mobile")
    private NavigateMeta mobile;

    // builder 开始
    public Navigate() {
    }

    public Navigate(Builder builder) {
        this.pc = builder.pc;
        this.mobile = builder.mobile;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NavigateMeta getPc() {
        return this.pc;
    }

    public void setPc(NavigateMeta pc) {
        this.pc = pc;
    }

    public NavigateMeta getMobile() {
        return this.mobile;
    }

    public void setMobile(NavigateMeta mobile) {
        this.mobile = mobile;
    }

    public static class Builder {
        private NavigateMeta pc;
        private NavigateMeta mobile;

        public Builder pc(NavigateMeta pc) {
            this.pc = pc;
            return this;
        }

        public Builder mobile(NavigateMeta mobile) {
            this.mobile = mobile;
            return this;
        }


        public Navigate build() {
            return new Navigate(this);
        }
    }
}
