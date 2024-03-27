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

package com.lark.oapi.service.task.v2.model;

import com.google.gson.annotations.SerializedName;

public class TaskInTasklistInfo {
    /**
     * 任务所在清单的guid
     * <p> 示例值：cc371766-6584-cf50-a222-c22cd9055004
     */
    @SerializedName("tasklist_guid")
    private String tasklistGuid;
    /**
     * 任务所在清单的自定义分组guid
     * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
     */
    @SerializedName("section_guid")
    private String sectionGuid;

    // builder 开始
    public TaskInTasklistInfo() {
    }

    public TaskInTasklistInfo(Builder builder) {
        /**
         * 任务所在清单的guid
         * <p> 示例值：cc371766-6584-cf50-a222-c22cd9055004
         */
        this.tasklistGuid = builder.tasklistGuid;
        /**
         * 任务所在清单的自定义分组guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         */
        this.sectionGuid = builder.sectionGuid;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTasklistGuid() {
        return this.tasklistGuid;
    }

    public void setTasklistGuid(String tasklistGuid) {
        this.tasklistGuid = tasklistGuid;
    }

    public String getSectionGuid() {
        return this.sectionGuid;
    }

    public void setSectionGuid(String sectionGuid) {
        this.sectionGuid = sectionGuid;
    }

    public static class Builder {
        /**
         * 任务所在清单的guid
         * <p> 示例值：cc371766-6584-cf50-a222-c22cd9055004
         */
        private String tasklistGuid;
        /**
         * 任务所在清单的自定义分组guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         */
        private String sectionGuid;

        /**
         * 任务所在清单的guid
         * <p> 示例值：cc371766-6584-cf50-a222-c22cd9055004
         *
         * @param tasklistGuid
         * @return
         */
        public Builder tasklistGuid(String tasklistGuid) {
            this.tasklistGuid = tasklistGuid;
            return this;
        }


        /**
         * 任务所在清单的自定义分组guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         *
         * @param sectionGuid
         * @return
         */
        public Builder sectionGuid(String sectionGuid) {
            this.sectionGuid = sectionGuid;
            return this;
        }


        public TaskInTasklistInfo build() {
            return new TaskInTasklistInfo(this);
        }
    }
}
