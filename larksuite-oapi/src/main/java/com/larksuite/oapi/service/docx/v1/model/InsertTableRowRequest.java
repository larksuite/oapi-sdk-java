// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class InsertTableRowRequest {
    @SerializedName("row_index")
    private Integer rowIndex;

    // builder 开始
    public InsertTableRowRequest() {
    }

    public InsertTableRowRequest(Builder builder) {
        this.rowIndex = builder.rowIndex;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public static class Builder {
        private Integer rowIndex;

        public Builder rowIndex(Integer rowIndex) {
            this.rowIndex = rowIndex;
            return this;
        }


        public InsertTableRowRequest build() {
            return new InsertTableRowRequest(this);
        }
    }
}
