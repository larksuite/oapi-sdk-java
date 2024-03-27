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

package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class TextStyle {
    /**
     * 对齐方式
     * <p> 示例值：1
     */
    @SerializedName("align")
    private Integer align;
    /**
     * todo 的完成状态
     * <p> 示例值：true
     */
    @SerializedName("done")
    private Boolean done;
    /**
     * 文本的折叠状态
     * <p> 示例值：true
     */
    @SerializedName("folded")
    private Boolean folded;
    /**
     * 代码块语言
     * <p> 示例值：1
     */
    @SerializedName("language")
    private Integer language;
    /**
     * 代码块是否自动换行
     * <p> 示例值：true
     */
    @SerializedName("wrap")
    private Boolean wrap;
    /**
     * 块背景色
     * <p> 示例值：LightGrayBackground
     */
    @SerializedName("background_color")
    private String backgroundColor;
    /**
     * 首行缩进级别
     * <p> 示例值：NoIndent
     */
    @SerializedName("indentation_level")
    private String indentationLevel;

    // builder 开始
    public TextStyle() {
    }

    public TextStyle(Builder builder) {
        /**
         * 对齐方式
         * <p> 示例值：1
         */
        this.align = builder.align;
        /**
         * todo 的完成状态
         * <p> 示例值：true
         */
        this.done = builder.done;
        /**
         * 文本的折叠状态
         * <p> 示例值：true
         */
        this.folded = builder.folded;
        /**
         * 代码块语言
         * <p> 示例值：1
         */
        this.language = builder.language;
        /**
         * 代码块是否自动换行
         * <p> 示例值：true
         */
        this.wrap = builder.wrap;
        /**
         * 块背景色
         * <p> 示例值：LightGrayBackground
         */
        this.backgroundColor = builder.backgroundColor;
        /**
         * 首行缩进级别
         * <p> 示例值：NoIndent
         */
        this.indentationLevel = builder.indentationLevel;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getAlign() {
        return this.align;
    }

    public void setAlign(Integer align) {
        this.align = align;
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getFolded() {
        return this.folded;
    }

    public void setFolded(Boolean folded) {
        this.folded = folded;
    }

    public Integer getLanguage() {
        return this.language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Boolean getWrap() {
        return this.wrap;
    }

    public void setWrap(Boolean wrap) {
        this.wrap = wrap;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getIndentationLevel() {
        return this.indentationLevel;
    }

    public void setIndentationLevel(String indentationLevel) {
        this.indentationLevel = indentationLevel;
    }

    public static class Builder {
        /**
         * 对齐方式
         * <p> 示例值：1
         */
        private Integer align;
        /**
         * todo 的完成状态
         * <p> 示例值：true
         */
        private Boolean done;
        /**
         * 文本的折叠状态
         * <p> 示例值：true
         */
        private Boolean folded;
        /**
         * 代码块语言
         * <p> 示例值：1
         */
        private Integer language;
        /**
         * 代码块是否自动换行
         * <p> 示例值：true
         */
        private Boolean wrap;
        /**
         * 块背景色
         * <p> 示例值：LightGrayBackground
         */
        private String backgroundColor;
        /**
         * 首行缩进级别
         * <p> 示例值：NoIndent
         */
        private String indentationLevel;

        /**
         * 对齐方式
         * <p> 示例值：1
         *
         * @param align
         * @return
         */
        public Builder align(Integer align) {
            this.align = align;
            return this;
        }

        /**
         * 对齐方式
         * <p> 示例值：1
         *
         * @param align {@link com.lark.oapi.service.docx.v1.enums.TextStyleAlignEnum}
         * @return
         */
        public Builder align(com.lark.oapi.service.docx.v1.enums.TextStyleAlignEnum align) {
            this.align = align.getValue();
            return this;
        }


        /**
         * todo 的完成状态
         * <p> 示例值：true
         *
         * @param done
         * @return
         */
        public Builder done(Boolean done) {
            this.done = done;
            return this;
        }


        /**
         * 文本的折叠状态
         * <p> 示例值：true
         *
         * @param folded
         * @return
         */
        public Builder folded(Boolean folded) {
            this.folded = folded;
            return this;
        }


        /**
         * 代码块语言
         * <p> 示例值：1
         *
         * @param language
         * @return
         */
        public Builder language(Integer language) {
            this.language = language;
            return this;
        }

        /**
         * 代码块语言
         * <p> 示例值：1
         *
         * @param language {@link com.lark.oapi.service.docx.v1.enums.TextStyleCodeLanguageEnum}
         * @return
         */
        public Builder language(com.lark.oapi.service.docx.v1.enums.TextStyleCodeLanguageEnum language) {
            this.language = language.getValue();
            return this;
        }


        /**
         * 代码块是否自动换行
         * <p> 示例值：true
         *
         * @param wrap
         * @return
         */
        public Builder wrap(Boolean wrap) {
            this.wrap = wrap;
            return this;
        }


        /**
         * 块背景色
         * <p> 示例值：LightGrayBackground
         *
         * @param backgroundColor
         * @return
         */
        public Builder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        /**
         * 块背景色
         * <p> 示例值：LightGrayBackground
         *
         * @param backgroundColor {@link com.lark.oapi.service.docx.v1.enums.TextStyleTextBackgroundColorEnum}
         * @return
         */
        public Builder backgroundColor(com.lark.oapi.service.docx.v1.enums.TextStyleTextBackgroundColorEnum backgroundColor) {
            this.backgroundColor = backgroundColor.getValue();
            return this;
        }


        /**
         * 首行缩进级别
         * <p> 示例值：NoIndent
         *
         * @param indentationLevel
         * @return
         */
        public Builder indentationLevel(String indentationLevel) {
            this.indentationLevel = indentationLevel;
            return this;
        }

        /**
         * 首行缩进级别
         * <p> 示例值：NoIndent
         *
         * @param indentationLevel {@link com.lark.oapi.service.docx.v1.enums.TextStyleIndentationLevelEnum}
         * @return
         */
        public Builder indentationLevel(com.lark.oapi.service.docx.v1.enums.TextStyleIndentationLevelEnum indentationLevel) {
            this.indentationLevel = indentationLevel.getValue();
            return this;
        }


        public TextStyle build() {
            return new TextStyle(this);
        }
    }
}
