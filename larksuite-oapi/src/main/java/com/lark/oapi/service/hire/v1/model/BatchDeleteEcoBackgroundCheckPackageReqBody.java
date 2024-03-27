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

package com.lark.oapi.service.hire.v1.model;

import com.google.gson.annotations.SerializedName;

public class BatchDeleteEcoBackgroundCheckPackageReqBody {
    /**
     * 背调账号 ID，可在「账号绑定」事件中获取
     * <p> 示例值：xd_bc_001
     */
    @SerializedName("account_id")
    private String accountId;
    /**
     * 要删除的套餐 ID 列表，删除套餐不影响已安排的背调
     * <p> 示例值：6996920667635566881
     */
    @SerializedName("package_id_list")
    private String[] packageIdList;
    /**
     * 要删除的附加调查项 ID 列表，删除附加调查项不影响已安排的背调
     * <p> 示例值：6996920667635566881
     */
    @SerializedName("additional_item_id_list")
    private String[] additionalItemIdList;

    // builder 开始
    public BatchDeleteEcoBackgroundCheckPackageReqBody() {
    }

    public BatchDeleteEcoBackgroundCheckPackageReqBody(Builder builder) {
        /**
         * 背调账号 ID，可在「账号绑定」事件中获取
         * <p> 示例值：xd_bc_001
         */
        this.accountId = builder.accountId;
        /**
         * 要删除的套餐 ID 列表，删除套餐不影响已安排的背调
         * <p> 示例值：6996920667635566881
         */
        this.packageIdList = builder.packageIdList;
        /**
         * 要删除的附加调查项 ID 列表，删除附加调查项不影响已安排的背调
         * <p> 示例值：6996920667635566881
         */
        this.additionalItemIdList = builder.additionalItemIdList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String[] getPackageIdList() {
        return this.packageIdList;
    }

    public void setPackageIdList(String[] packageIdList) {
        this.packageIdList = packageIdList;
    }

    public String[] getAdditionalItemIdList() {
        return this.additionalItemIdList;
    }

    public void setAdditionalItemIdList(String[] additionalItemIdList) {
        this.additionalItemIdList = additionalItemIdList;
    }

    public static class Builder {
        /**
         * 背调账号 ID，可在「账号绑定」事件中获取
         * <p> 示例值：xd_bc_001
         */
        private String accountId;
        /**
         * 要删除的套餐 ID 列表，删除套餐不影响已安排的背调
         * <p> 示例值：6996920667635566881
         */
        private String[] packageIdList;
        /**
         * 要删除的附加调查项 ID 列表，删除附加调查项不影响已安排的背调
         * <p> 示例值：6996920667635566881
         */
        private String[] additionalItemIdList;

        /**
         * 背调账号 ID，可在「账号绑定」事件中获取
         * <p> 示例值：xd_bc_001
         *
         * @param accountId
         * @return
         */
        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }


        /**
         * 要删除的套餐 ID 列表，删除套餐不影响已安排的背调
         * <p> 示例值：6996920667635566881
         *
         * @param packageIdList
         * @return
         */
        public Builder packageIdList(String[] packageIdList) {
            this.packageIdList = packageIdList;
            return this;
        }


        /**
         * 要删除的附加调查项 ID 列表，删除附加调查项不影响已安排的背调
         * <p> 示例值：6996920667635566881
         *
         * @param additionalItemIdList
         * @return
         */
        public Builder additionalItemIdList(String[] additionalItemIdList) {
            this.additionalItemIdList = additionalItemIdList;
            return this;
        }


        public BatchDeleteEcoBackgroundCheckPackageReqBody build() {
            return new BatchDeleteEcoBackgroundCheckPackageReqBody(this);
        }
    }
}
