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

package com.lark.oapi.service.okr.v1.model;

import com.google.gson.annotations.SerializedName;

public class ImageInfo {

  /**
   * 图片token
   * <p> 示例值：boxbcLxEnhUE3REJSAwAbVFZwPf
   */
  @SerializedName("file_token")
  private String fileToken;
  /**
   * 图片下载链接
   * <p> 示例值：https://internal-api-okr.feishu-boe.cn/stream/api/downloadFile/?file_token=boxbcLxEnhUE3REJSAwAbVFZwPf&ticket=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfaWQiOiI3MDQxNDMwMzc3NjQyMDgyMzIzIiwidGFyZ2V0X3R5cGUiOjMsImFjdGlvbiI6MiwiZmlsZV90b2tlbiI6ImJveGJjTHhFbmhVRTNSRUpTQXdBYlZGWndQZiIsInVzZXJfaWQiOiI2OTY5ODU1NTAxNzQ0ODM0MDkyIiwidGVuYW50X2lkIjoiNjg3NzUwMjY4NzYwOTQwNjk5MCIsImV4cCI6MTYzOTcyNTUwM30.G2RD3LJBycZuF0Myi2WD4IdJ1N5jB24KGjLrm9e4peNlF8uy2XflINVcTpvN6drshITErHu0ehibJI5Fci-Pkw
   */
  @SerializedName("url")
  private String url;

  // builder 开始
  public ImageInfo() {
  }

  public ImageInfo(Builder builder) {
    /**
     * 图片token
     * <p> 示例值：boxbcLxEnhUE3REJSAwAbVFZwPf
     */
    this.fileToken = builder.fileToken;
    /**
     * 图片下载链接
     * <p> 示例值：https://internal-api-okr.feishu-boe.cn/stream/api/downloadFile/?file_token=boxbcLxEnhUE3REJSAwAbVFZwPf&ticket=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfaWQiOiI3MDQxNDMwMzc3NjQyMDgyMzIzIiwidGFyZ2V0X3R5cGUiOjMsImFjdGlvbiI6MiwiZmlsZV90b2tlbiI6ImJveGJjTHhFbmhVRTNSRUpTQXdBYlZGWndQZiIsInVzZXJfaWQiOiI2OTY5ODU1NTAxNzQ0ODM0MDkyIiwidGVuYW50X2lkIjoiNjg3NzUwMjY4NzYwOTQwNjk5MCIsImV4cCI6MTYzOTcyNTUwM30.G2RD3LJBycZuF0Myi2WD4IdJ1N5jB24KGjLrm9e4peNlF8uy2XflINVcTpvN6drshITErHu0ehibJI5Fci-Pkw
     */
    this.url = builder.url;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getFileToken() {
    return this.fileToken;
  }

  public void setFileToken(String fileToken) {
    this.fileToken = fileToken;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public static class Builder {

    /**
     * 图片token
     * <p> 示例值：boxbcLxEnhUE3REJSAwAbVFZwPf
     */
    private String fileToken;
    /**
     * 图片下载链接
     * <p> 示例值：https://internal-api-okr.feishu-boe.cn/stream/api/downloadFile/?file_token=boxbcLxEnhUE3REJSAwAbVFZwPf&ticket=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfaWQiOiI3MDQxNDMwMzc3NjQyMDgyMzIzIiwidGFyZ2V0X3R5cGUiOjMsImFjdGlvbiI6MiwiZmlsZV90b2tlbiI6ImJveGJjTHhFbmhVRTNSRUpTQXdBYlZGWndQZiIsInVzZXJfaWQiOiI2OTY5ODU1NTAxNzQ0ODM0MDkyIiwidGVuYW50X2lkIjoiNjg3NzUwMjY4NzYwOTQwNjk5MCIsImV4cCI6MTYzOTcyNTUwM30.G2RD3LJBycZuF0Myi2WD4IdJ1N5jB24KGjLrm9e4peNlF8uy2XflINVcTpvN6drshITErHu0ehibJI5Fci-Pkw
     */
    private String url;

    /**
     * 图片token
     * <p> 示例值：boxbcLxEnhUE3REJSAwAbVFZwPf
     *
     * @param fileToken
     * @return
     */
    public Builder fileToken(String fileToken) {
      this.fileToken = fileToken;
      return this;
    }


    /**
     * 图片下载链接
     * <p> 示例值：https://internal-api-okr.feishu-boe.cn/stream/api/downloadFile/?file_token=boxbcLxEnhUE3REJSAwAbVFZwPf&ticket=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfaWQiOiI3MDQxNDMwMzc3NjQyMDgyMzIzIiwidGFyZ2V0X3R5cGUiOjMsImFjdGlvbiI6MiwiZmlsZV90b2tlbiI6ImJveGJjTHhFbmhVRTNSRUpTQXdBYlZGWndQZiIsInVzZXJfaWQiOiI2OTY5ODU1NTAxNzQ0ODM0MDkyIiwidGVuYW50X2lkIjoiNjg3NzUwMjY4NzYwOTQwNjk5MCIsImV4cCI6MTYzOTcyNTUwM30.G2RD3LJBycZuF0Myi2WD4IdJ1N5jB24KGjLrm9e4peNlF8uy2XflINVcTpvN6drshITErHu0ehibJI5Fci-Pkw
     *
     * @param url
     * @return
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }


    public ImageInfo build() {
      return new ImageInfo(this);
    }
  }
}