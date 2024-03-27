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

package com.lark.oapi.service.corehr.v2.model;

import com.google.gson.annotations.SerializedName;

public class SearchBasicInfoBankReqBody {
    /**
     * 银行 ID 列表，与「银行名称列表」查询条件至少填写一项
     * <p> 示例值：
     */
    @SerializedName("bank_id_list")
    private String[] bankIdList;
    /**
     * 银行名称列表，支持对银行名称精确搜索
     * <p> 示例值：
     */
    @SerializedName("bank_name_list")
    private String[] bankNameList;
    /**
     * 状态列表
     * <p> 示例值：
     */
    @SerializedName("status_list")
    private Integer[] statusList;

    // builder 开始
    public SearchBasicInfoBankReqBody() {
    }

    public SearchBasicInfoBankReqBody(Builder builder) {
        /**
         * 银行 ID 列表，与「银行名称列表」查询条件至少填写一项
         * <p> 示例值：
         */
        this.bankIdList = builder.bankIdList;
        /**
         * 银行名称列表，支持对银行名称精确搜索
         * <p> 示例值：
         */
        this.bankNameList = builder.bankNameList;
        /**
         * 状态列表
         * <p> 示例值：
         */
        this.statusList = builder.statusList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getBankIdList() {
        return this.bankIdList;
    }

    public void setBankIdList(String[] bankIdList) {
        this.bankIdList = bankIdList;
    }

    public String[] getBankNameList() {
        return this.bankNameList;
    }

    public void setBankNameList(String[] bankNameList) {
        this.bankNameList = bankNameList;
    }

    public Integer[] getStatusList() {
        return this.statusList;
    }

    public void setStatusList(Integer[] statusList) {
        this.statusList = statusList;
    }

    public static class Builder {
        /**
         * 银行 ID 列表，与「银行名称列表」查询条件至少填写一项
         * <p> 示例值：
         */
        private String[] bankIdList;
        /**
         * 银行名称列表，支持对银行名称精确搜索
         * <p> 示例值：
         */
        private String[] bankNameList;
        /**
         * 状态列表
         * <p> 示例值：
         */
        private Integer[] statusList;

        /**
         * 银行 ID 列表，与「银行名称列表」查询条件至少填写一项
         * <p> 示例值：
         *
         * @param bankIdList
         * @return
         */
        public Builder bankIdList(String[] bankIdList) {
            this.bankIdList = bankIdList;
            return this;
        }


        /**
         * 银行名称列表，支持对银行名称精确搜索
         * <p> 示例值：
         *
         * @param bankNameList
         * @return
         */
        public Builder bankNameList(String[] bankNameList) {
            this.bankNameList = bankNameList;
            return this;
        }


        /**
         * 状态列表
         * <p> 示例值：
         *
         * @param statusList
         * @return
         */
        public Builder statusList(Integer[] statusList) {
            this.statusList = statusList;
            return this;
        }


        public SearchBasicInfoBankReqBody build() {
            return new SearchBasicInfoBankReqBody(this);
        }
    }
}
