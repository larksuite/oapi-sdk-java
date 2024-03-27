// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.service.document_ai.v1.model;

import com.google.gson.annotations.SerializedName;

public class DocChunkResult {
    /**
     * 段落索引
     * <p> 示例值：1
     */
    @SerializedName("id")
    private Integer id;
    /**
     * 该chunk属于哪一种文档元素
     * <p> 示例值：title
     */
    @SerializedName("type")
    private String type;
    /**
     * chunk的位置信息，pdf文档中会有bbox和page_no
     * <p> 示例值：
     */
    @SerializedName("positions")
    private DocChunkPosition positions;
    /**
     * 段落文本内容
     * <p> 示例值：设备采购合同...
     */
    @SerializedName("text")
    private String text;
    /**
     * 段落层级，类似飞书文档的Hn
     * <p> 示例值：1
     */
    @SerializedName("level")
    private Integer level;
    /**
     * 当前段落父节点索引
     * <p> 示例值：1
     */
    @SerializedName("parent")
    private Integer parent;
    /**
     * 当前段落所有子节点索引
     * <p> 示例值：
     */
    @SerializedName("children")
    private Integer[] children;
    /**
     * 段落的语义标签，（以论文为例，会有title, author, abstract, introduction, related works...）
     * <p> 示例值：author
     */
    @SerializedName("label")
    private String label;
    /**
     * 飞书文档的block_id字段
     * <p> 示例值：123
     */
    @SerializedName("block_id")
    private String blockId;
    /**
     * 如chunk=table，则此字段包含表格信息
     * <p> 示例值：
     */
    @SerializedName("table_detail")
    private DocChunkTableDetail tableDetail;

    // builder 开始
    public DocChunkResult() {
    }

    public DocChunkResult(Builder builder) {
        /**
         * 段落索引
         * <p> 示例值：1
         */
        this.id = builder.id;
        /**
         * 该chunk属于哪一种文档元素
         * <p> 示例值：title
         */
        this.type = builder.type;
        /**
         * chunk的位置信息，pdf文档中会有bbox和page_no
         * <p> 示例值：
         */
        this.positions = builder.positions;
        /**
         * 段落文本内容
         * <p> 示例值：设备采购合同...
         */
        this.text = builder.text;
        /**
         * 段落层级，类似飞书文档的Hn
         * <p> 示例值：1
         */
        this.level = builder.level;
        /**
         * 当前段落父节点索引
         * <p> 示例值：1
         */
        this.parent = builder.parent;
        /**
         * 当前段落所有子节点索引
         * <p> 示例值：
         */
        this.children = builder.children;
        /**
         * 段落的语义标签，（以论文为例，会有title, author, abstract, introduction, related works...）
         * <p> 示例值：author
         */
        this.label = builder.label;
        /**
         * 飞书文档的block_id字段
         * <p> 示例值：123
         */
        this.blockId = builder.blockId;
        /**
         * 如chunk=table，则此字段包含表格信息
         * <p> 示例值：
         */
        this.tableDetail = builder.tableDetail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DocChunkPosition getPositions() {
        return this.positions;
    }

    public void setPositions(DocChunkPosition positions) {
        this.positions = positions;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return this.parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer[] getChildren() {
        return this.children;
    }

    public void setChildren(Integer[] children) {
        this.children = children;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBlockId() {
        return this.blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public DocChunkTableDetail getTableDetail() {
        return this.tableDetail;
    }

    public void setTableDetail(DocChunkTableDetail tableDetail) {
        this.tableDetail = tableDetail;
    }

    public static class Builder {
        /**
         * 段落索引
         * <p> 示例值：1
         */
        private Integer id;
        /**
         * 该chunk属于哪一种文档元素
         * <p> 示例值：title
         */
        private String type;
        /**
         * chunk的位置信息，pdf文档中会有bbox和page_no
         * <p> 示例值：
         */
        private DocChunkPosition positions;
        /**
         * 段落文本内容
         * <p> 示例值：设备采购合同...
         */
        private String text;
        /**
         * 段落层级，类似飞书文档的Hn
         * <p> 示例值：1
         */
        private Integer level;
        /**
         * 当前段落父节点索引
         * <p> 示例值：1
         */
        private Integer parent;
        /**
         * 当前段落所有子节点索引
         * <p> 示例值：
         */
        private Integer[] children;
        /**
         * 段落的语义标签，（以论文为例，会有title, author, abstract, introduction, related works...）
         * <p> 示例值：author
         */
        private String label;
        /**
         * 飞书文档的block_id字段
         * <p> 示例值：123
         */
        private String blockId;
        /**
         * 如chunk=table，则此字段包含表格信息
         * <p> 示例值：
         */
        private DocChunkTableDetail tableDetail;

        /**
         * 段落索引
         * <p> 示例值：1
         *
         * @param id
         * @return
         */
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }


        /**
         * 该chunk属于哪一种文档元素
         * <p> 示例值：title
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 该chunk属于哪一种文档元素
         * <p> 示例值：title
         *
         * @param type {@link com.lark.oapi.service.document_ai.v1.enums.DocChunkResultDocChunkResultTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.document_ai.v1.enums.DocChunkResultDocChunkResultTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * chunk的位置信息，pdf文档中会有bbox和page_no
         * <p> 示例值：
         *
         * @param positions
         * @return
         */
        public Builder positions(DocChunkPosition positions) {
            this.positions = positions;
            return this;
        }


        /**
         * 段落文本内容
         * <p> 示例值：设备采购合同...
         *
         * @param text
         * @return
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }


        /**
         * 段落层级，类似飞书文档的Hn
         * <p> 示例值：1
         *
         * @param level
         * @return
         */
        public Builder level(Integer level) {
            this.level = level;
            return this;
        }


        /**
         * 当前段落父节点索引
         * <p> 示例值：1
         *
         * @param parent
         * @return
         */
        public Builder parent(Integer parent) {
            this.parent = parent;
            return this;
        }


        /**
         * 当前段落所有子节点索引
         * <p> 示例值：
         *
         * @param children
         * @return
         */
        public Builder children(Integer[] children) {
            this.children = children;
            return this;
        }


        /**
         * 段落的语义标签，（以论文为例，会有title, author, abstract, introduction, related works...）
         * <p> 示例值：author
         *
         * @param label
         * @return
         */
        public Builder label(String label) {
            this.label = label;
            return this;
        }


        /**
         * 飞书文档的block_id字段
         * <p> 示例值：123
         *
         * @param blockId
         * @return
         */
        public Builder blockId(String blockId) {
            this.blockId = blockId;
            return this;
        }


        /**
         * 如chunk=table，则此字段包含表格信息
         * <p> 示例值：
         *
         * @param tableDetail
         * @return
         */
        public Builder tableDetail(DocChunkTableDetail tableDetail) {
            this.tableDetail = tableDetail;
            return this;
        }


        public DocChunkResult build() {
            return new DocChunkResult(this);
        }
    }
}
