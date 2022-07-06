// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.admin.v1.model;

import com.google.gson.annotations.SerializedName;

public class AuditContext {
    @SerializedName("terminal_type")
    private Integer terminalType;
    @SerializedName("ios_context")
    private AuditIosContext iosContext;
    @SerializedName("pc_context")
    private AuditPcContext pcContext;
    @SerializedName("web_context")
    private AuditWebContext webContext;
    @SerializedName("android_context")
    private AuditAndroidContext androidContext;

    // builder 开始
    public AuditContext() {
    }

    public AuditContext(Builder builder) {
        this.terminalType = builder.terminalType;
        this.iosContext = builder.iosContext;
        this.pcContext = builder.pcContext;
        this.webContext = builder.webContext;
        this.androidContext = builder.androidContext;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public AuditIosContext getIosContext() {
        return this.iosContext;
    }

    public void setIosContext(AuditIosContext iosContext) {
        this.iosContext = iosContext;
    }

    public AuditPcContext getPcContext() {
        return this.pcContext;
    }

    public void setPcContext(AuditPcContext pcContext) {
        this.pcContext = pcContext;
    }

    public AuditWebContext getWebContext() {
        return this.webContext;
    }

    public void setWebContext(AuditWebContext webContext) {
        this.webContext = webContext;
    }

    public AuditAndroidContext getAndroidContext() {
        return this.androidContext;
    }

    public void setAndroidContext(AuditAndroidContext androidContext) {
        this.androidContext = androidContext;
    }

    public static class Builder {
        private Integer terminalType;
        private AuditIosContext iosContext;
        private AuditPcContext pcContext;
        private AuditWebContext webContext;
        private AuditAndroidContext androidContext;

        public Builder terminalType(Integer terminalType) {
            this.terminalType = terminalType;
            return this;
        }

        public Builder terminalType(com.larksuite.oapi.service.admin.v1.enums.TerminalTypeEnum terminalType) {
            this.terminalType = terminalType.getValue();
            return this;
        }

        public Builder iosContext(AuditIosContext iosContext) {
            this.iosContext = iosContext;
            return this;
        }

        public Builder pcContext(AuditPcContext pcContext) {
            this.pcContext = pcContext;
            return this;
        }

        public Builder webContext(AuditWebContext webContext) {
            this.webContext = webContext;
            return this;
        }

        public Builder androidContext(AuditAndroidContext androidContext) {
            this.androidContext = androidContext;
            return this;
        }


        public AuditContext build() {
            return new AuditContext(this);
        }
    }
}
