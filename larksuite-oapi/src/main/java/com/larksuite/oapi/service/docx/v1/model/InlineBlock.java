// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class InlineBlock {
    @SerializedName("block_id")
    private String blockId;

    // builder 开始
    public InlineBlock() {
    }

    public InlineBlock(Builder builder) {
        this.blockId = builder.blockId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getBlockId() {
        return this.blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public static class Builder {
        private String blockId;

        public Builder blockId(String blockId) {
            this.blockId = blockId;
            return this;
        }


        public InlineBlock build() {
            return new InlineBlock(this);
        }
    }
}
