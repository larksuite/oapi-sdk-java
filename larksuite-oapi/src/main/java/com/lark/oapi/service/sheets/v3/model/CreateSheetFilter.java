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

public class CreateSheetFilter {

  /**
   * 筛选应用范围
   * <p> 示例值：xxxxxx!C1:H14
   */
  @SerializedName("range")
  private String range;
  /**
   * 设置筛选条件的列
   * <p> 示例值：E
   */
  @SerializedName("col")
  private String col;
  /**
   * 筛选的条件
   * <p> 示例值：
   */
  @SerializedName("condition")
  private Condition condition;

  // builder 开始
  public CreateSheetFilter() {
  }

  public CreateSheetFilter(Builder builder) {
    /**
     * 筛选应用范围
     * <p> 示例值：xxxxxx!C1:H14
     */
    this.range = builder.range;
    /**
     * 设置筛选条件的列
     * <p> 示例值：E
     */
    this.col = builder.col;
    /**
     * 筛选的条件
     * <p> 示例值：
     */
    this.condition = builder.condition;
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

  public String getCol() {
    return this.col;
  }

  public void setCol(String col) {
    this.col = col;
  }

  public Condition getCondition() {
    return this.condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public static class Builder {

    /**
     * 筛选应用范围
     * <p> 示例值：xxxxxx!C1:H14
     */
    private String range;
    /**
     * 设置筛选条件的列
     * <p> 示例值：E
     */
    private String col;
    /**
     * 筛选的条件
     * <p> 示例值：
     */
    private Condition condition;

    /**
     * 筛选应用范围
     * <p> 示例值：xxxxxx!C1:H14
     *
     * @param range
     * @return
     */
    public Builder range(String range) {
      this.range = range;
      return this;
    }


    /**
     * 设置筛选条件的列
     * <p> 示例值：E
     *
     * @param col
     * @return
     */
    public Builder col(String col) {
      this.col = col;
      return this;
    }


    /**
     * 筛选的条件
     * <p> 示例值：
     *
     * @param condition
     * @return
     */
    public Builder condition(Condition condition) {
      this.condition = condition;
      return this;
    }


    public CreateSheetFilter build() {
      return new CreateSheetFilter(this);
    }
  }
}