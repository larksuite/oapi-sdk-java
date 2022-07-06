// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class View {
    @SerializedName("view_type")
    private Integer viewType;

    // builder 开始
    public View() {
    }

    public View(Builder builder) {
        this.viewType = builder.viewType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getViewType() {
        return this.viewType;
    }

    public void setViewType(Integer viewType) {
        this.viewType = viewType;
    }

    public static class Builder {
        private Integer viewType;

        public Builder viewType(Integer viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder viewType(com.larksuite.oapi.service.docx.v1.enums.ViewTypeEnum viewType) {
            this.viewType = viewType.getValue();
            return this;
        }


        public View build() {
            return new View(this);
        }
    }
}