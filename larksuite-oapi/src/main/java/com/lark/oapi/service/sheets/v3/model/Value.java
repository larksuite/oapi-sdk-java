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

public class Value {
    /**
     * 范围
     * <p> 示例值：Sheet1!A1:A2
     */
    @SerializedName("range")
    private String range;
    /**
     * 数据，数据结构参见[单元格数据结构](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet-sheet-value/cell-data-structure)
     * <p> 示例值：[]
     */
    @SerializedName("values")
    private CellValue[][][] values;

    // builder 开始
    public Value() {
    }

    public Value(Builder builder) {
        /**
         * 范围
         * <p> 示例值：Sheet1!A1:A2
         */
        this.range = builder.range;
        /**
         * 数据，数据结构参见[单元格数据结构](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet-sheet-value/cell-data-structure)
         * <p> 示例值：[]
         */
        this.values = builder.values;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public CellValue[][][] getValues() {
        return this.values;
    }

    public void setValues(CellValue[][][] values) {
        this.values = values;
    }

    public static class Builder {
        /**
         * 范围
         * <p> 示例值：Sheet1!A1:A2
         */
        private String range;
        /**
         * 数据，数据结构参见[单元格数据结构](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet-sheet-value/cell-data-structure)
         * <p> 示例值：[]
         */
        private CellValue[][][] values;

        /**
         * 范围
         * <p> 示例值：Sheet1!A1:A2
         *
         * @param range
         * @return
         */
        public Builder range(String range) {
            this.range = range;
            return this;
        }


        /**
         * 数据，数据结构参见[单元格数据结构](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet-sheet-value/cell-data-structure)
         * <p> 示例值：[]
         *
         * @param values
         * @return
         */
        public Builder values(CellValue[][][] values) {
            this.values = values;
            return this;
        }


        public Value build() {
            return new Value(this);
        }
    }
}
