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

package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class StyleRanges {
    /**
     * 单元格样式
     * <p> 示例值：
     */
    @SerializedName("style_ranges")
    private Style[] styleRanges;

    // builder 开始
    public StyleRanges() {
    }

    public StyleRanges(Builder builder) {
        /**
         * 单元格样式
         * <p> 示例值：
         */
        this.styleRanges = builder.styleRanges;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Style[] getStyleRanges() {
        return this.styleRanges;
    }

    public void setStyleRanges(Style[] styleRanges) {
        this.styleRanges = styleRanges;
    }

    public static class Builder {
        /**
         * 单元格样式
         * <p> 示例值：
         */
        private Style[] styleRanges;

        /**
         * 单元格样式
         * <p> 示例值：
         *
         * @param styleRanges
         * @return
         */
        public Builder styleRanges(Style[] styleRanges) {
            this.styleRanges = styleRanges;
            return this;
        }


        public StyleRanges build() {
            return new StyleRanges(this);
        }
    }
}
