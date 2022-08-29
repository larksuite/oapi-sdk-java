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

package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;

public class ItemContent {

  /**
   * 内容的格式
   * <p> 示例值：html
   */
  @SerializedName("format")
  private String format;
  /**
   * 全文数据
   * <p> 示例值：这是一个很长的文本
   */
  @SerializedName("content_data")
  private String contentData;

  // builder 开始
  public ItemContent() {
  }

  public ItemContent(Builder builder) {
    /**
     * 内容的格式
     * <p> 示例值：html
     */
    this.format = builder.format;
    /**
     * 全文数据
     * <p> 示例值：这是一个很长的文本
     */
    this.contentData = builder.contentData;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getFormat() {
    return this.format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getContentData() {
    return this.contentData;
  }

  public void setContentData(String contentData) {
    this.contentData = contentData;
  }

  public static class Builder {

    /**
     * 内容的格式
     * <p> 示例值：html
     */
    private String format;
    /**
     * 全文数据
     * <p> 示例值：这是一个很长的文本
     */
    private String contentData;

    /**
     * 内容的格式
     * <p> 示例值：html
     *
     * @param format
     * @return
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * 内容的格式
     * <p> 示例值：html
     *
     * @param format {@link com.lark.oapi.service.search.v2.enums.ItemContentFormatEnum}
     * @return
     */
    public Builder format(com.lark.oapi.service.search.v2.enums.ItemContentFormatEnum format) {
      this.format = format.getValue();
      return this;
    }


    /**
     * 全文数据
     * <p> 示例值：这是一个很长的文本
     *
     * @param contentData
     * @return
     */
    public Builder contentData(String contentData) {
      this.contentData = contentData;
      return this;
    }


    public ItemContent build() {
      return new ItemContent(this);
    }
  }
}