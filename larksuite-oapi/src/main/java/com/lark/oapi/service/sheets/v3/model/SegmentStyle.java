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

public class SegmentStyle {

  /**
   * 影响的文本
   * <p> 示例值：a
   */
  @SerializedName("affected_text")
  private String affectedText;
  /**
   * 样式
   * <p> 示例值：
   */
  @SerializedName("style")
  private SegmentStyleStyle style;

  // builder 开始
  public SegmentStyle() {
  }

  public SegmentStyle(Builder builder) {
    /**
     * 影响的文本
     * <p> 示例值：a
     */
    this.affectedText = builder.affectedText;
    /**
     * 样式
     * <p> 示例值：
     */
    this.style = builder.style;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAffectedText() {
    return this.affectedText;
  }

  public void setAffectedText(String affectedText) {
    this.affectedText = affectedText;
  }

  public SegmentStyleStyle getStyle() {
    return this.style;
  }

  public void setStyle(SegmentStyleStyle style) {
    this.style = style;
  }

  public static class Builder {

    /**
     * 影响的文本
     * <p> 示例值：a
     */
    private String affectedText;
    /**
     * 样式
     * <p> 示例值：
     */
    private SegmentStyleStyle style;

    /**
     * 影响的文本
     * <p> 示例值：a
     *
     * @param affectedText
     * @return
     */
    public Builder affectedText(String affectedText) {
      this.affectedText = affectedText;
      return this;
    }


    /**
     * 样式
     * <p> 示例值：
     *
     * @param style
     * @return
     */
    public Builder style(SegmentStyleStyle style) {
      this.style = style;
      return this;
    }


    public SegmentStyle build() {
      return new SegmentStyle(this);
    }
  }
}