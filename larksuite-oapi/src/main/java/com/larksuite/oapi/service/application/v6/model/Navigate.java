// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;
import com.google.gson.annotations.SerializedName;

public class Navigate {
    @SerializedName("pc")
    private NavigateMeta pc;
    @SerializedName("mobile")
    private NavigateMeta mobile;

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

}