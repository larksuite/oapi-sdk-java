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

public class BackgroundCheckFeedbackInfo {

  /**
   * 背调信息附件下载链接
   * <p> 示例值：https://feishucdn.com/staource/v1/2de04c10-5cda-4c50~?image_size=np&cutpe=&quity=&mat=g&stmat=.wp
   */
  @SerializedName("attachment_url")
  private String attachmentUrl;
  /**
   * 背调结果：红灯、黄灯、绿灯
   * <p> 示例值：红灯
   */
  @SerializedName("result")
  private String result;

  // builder 开始
  public BackgroundCheckFeedbackInfo() {
  }

  public BackgroundCheckFeedbackInfo(Builder builder) {
    /**
     * 背调信息附件下载链接
     * <p> 示例值：https://feishucdn.com/staource/v1/2de04c10-5cda-4c50~?image_size=np&cutpe=&quity=&mat=g&stmat=.wp
     */
    this.attachmentUrl = builder.attachmentUrl;
    /**
     * 背调结果：红灯、黄灯、绿灯
     * <p> 示例值：红灯
     */
    this.result = builder.result;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAttachmentUrl() {
    return this.attachmentUrl;
  }

  public void setAttachmentUrl(String attachmentUrl) {
    this.attachmentUrl = attachmentUrl;
  }

  public String getResult() {
    return this.result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public static class Builder {

    /**
     * 背调信息附件下载链接
     * <p> 示例值：https://feishucdn.com/staource/v1/2de04c10-5cda-4c50~?image_size=np&cutpe=&quity=&mat=g&stmat=.wp
     */
    private String attachmentUrl;
    /**
     * 背调结果：红灯、黄灯、绿灯
     * <p> 示例值：红灯
     */
    private String result;

    /**
     * 背调信息附件下载链接
     * <p> 示例值：https://feishucdn.com/staource/v1/2de04c10-5cda-4c50~?image_size=np&cutpe=&quity=&mat=g&stmat=.wp
     *
     * @param attachmentUrl
     * @return
     */
    public Builder attachmentUrl(String attachmentUrl) {
      this.attachmentUrl = attachmentUrl;
      return this;
    }


    /**
     * 背调结果：红灯、黄灯、绿灯
     * <p> 示例值：红灯
     *
     * @param result
     * @return
     */
    public Builder result(String result) {
      this.result = result;
      return this;
    }


    public BackgroundCheckFeedbackInfo build() {
      return new BackgroundCheckFeedbackInfo(this);
    }
  }
}