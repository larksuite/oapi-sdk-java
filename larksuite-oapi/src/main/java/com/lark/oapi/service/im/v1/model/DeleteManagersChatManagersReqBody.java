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

package com.lark.oapi.service.im.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.im.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class DeleteManagersChatManagersReqBody {
    /**
     * 要删除的 manager_id;;**注意**：每次请求最多指定 50 个用户或者 5 个机器人
     * <p> 示例值：["ou_9204a37300b3700d61effaa439f34295"]
     */
    @SerializedName("manager_ids")
    private String[] managerIds;

    // builder 开始
    public DeleteManagersChatManagersReqBody() {
    }

    public DeleteManagersChatManagersReqBody(Builder builder) {
        /**
         * 要删除的 manager_id;;**注意**：每次请求最多指定 50 个用户或者 5 个机器人
         * <p> 示例值：["ou_9204a37300b3700d61effaa439f34295"]
         */
        this.managerIds = builder.managerIds;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getManagerIds() {
        return this.managerIds;
    }

    public void setManagerIds(String[] managerIds) {
        this.managerIds = managerIds;
    }

    public static class Builder {
        /**
         * 要删除的 manager_id;;**注意**：每次请求最多指定 50 个用户或者 5 个机器人
         * <p> 示例值：["ou_9204a37300b3700d61effaa439f34295"]
         */
        private String[] managerIds;

        /**
         * 要删除的 manager_id;;**注意**：每次请求最多指定 50 个用户或者 5 个机器人
         * <p> 示例值：["ou_9204a37300b3700d61effaa439f34295"]
         *
         * @param managerIds
         * @return
         */
        public Builder managerIds(String[] managerIds) {
            this.managerIds = managerIds;
            return this;
        }


        public DeleteManagersChatManagersReqBody build() {
            return new DeleteManagersChatManagersReqBody(this);
        }
    }
}
