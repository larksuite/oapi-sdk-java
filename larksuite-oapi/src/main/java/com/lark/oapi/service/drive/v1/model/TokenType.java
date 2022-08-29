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

package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class TokenType {

  /**
   * 文件的 token，获取方式见 [对接前说明](/ssl:ttdoc/ukTMukTMukTM/uczNzUjL3czM14yN3MTN)的第 4 项
   * <p> 示例值：isvcnBKgoMyY5OMbUG6FioTXuBe
   */
  @SerializedName("token")
  private String token;
  /**
   * 文档类型  "isv"
   * <p> 示例值：isv
   */
  @SerializedName("type")
  private String type;

  // builder 开始
  public TokenType() {
  }

  public TokenType(Builder builder) {
    /**
     * 文件的 token，获取方式见 [对接前说明](/ssl:ttdoc/ukTMukTMukTM/uczNzUjL3czM14yN3MTN)的第 4 项
     * <p> 示例值：isvcnBKgoMyY5OMbUG6FioTXuBe
     */
    this.token = builder.token;
    /**
     * 文档类型  "isv"
     * <p> 示例值：isv
     */
    this.type = builder.type;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public static class Builder {

    /**
     * 文件的 token，获取方式见 [对接前说明](/ssl:ttdoc/ukTMukTMukTM/uczNzUjL3czM14yN3MTN)的第 4 项
     * <p> 示例值：isvcnBKgoMyY5OMbUG6FioTXuBe
     */
    private String token;
    /**
     * 文档类型  "isv"
     * <p> 示例值：isv
     */
    private String type;

    /**
     * 文件的 token，获取方式见 [对接前说明](/ssl:ttdoc/ukTMukTMukTM/uczNzUjL3czM14yN3MTN)的第 4 项
     * <p> 示例值：isvcnBKgoMyY5OMbUG6FioTXuBe
     *
     * @param token
     * @return
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }


    /**
     * 文档类型  "isv"
     * <p> 示例值：isv
     *
     * @param type
     * @return
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }


    public TokenType build() {
      return new TokenType(this);
    }
  }
}