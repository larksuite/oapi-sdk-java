// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DeleteDataSourceItemReq {
    @Path
    @SerializedName("data_source_id")
    private String dataSourceId;
    @Path
    @SerializedName("item_id")
    private String itemId;

    // builder 开始
    public DeleteDataSourceItemReq() {
    }

    public DeleteDataSourceItemReq(Builder builder) {
        this.dataSourceId = builder.dataSourceId;
        this.itemId = builder.itemId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDataSourceId() {
        return this.dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public static class Builder {

        private String dataSourceId;
        private String itemId;

        public Builder dataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public DeleteDataSourceItemReq build() {
            return new DeleteDataSourceItemReq(this);
        }
    }
}
