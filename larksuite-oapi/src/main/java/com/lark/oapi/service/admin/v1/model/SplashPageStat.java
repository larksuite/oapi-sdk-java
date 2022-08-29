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

package com.lark.oapi.service.admin.v1.model;

import com.google.gson.annotations.SerializedName;

public class SplashPageStat {

  /**
   * 日期
   * <p> 示例值：
   */
  @SerializedName("date")
  private String date;
  /**
   * 开屏素材id
   * <p> 示例值：
   */
  @SerializedName("splash_id")
  private String splashId;
  /**
   * 曝光数
   * <p> 示例值：
   */
  @SerializedName("impression_count")
  private Integer impressionCount;
  /**
   * 点击数
   * <p> 示例值：
   */
  @SerializedName("click_count")
  private Integer clickCount;
  /**
   * 点击跳过数
   * <p> 示例值：
   */
  @SerializedName("skip_count")
  private Integer skipCount;
  /**
   * 累计曝光
   * <p> 示例值：
   */
  @SerializedName("impression_count_accumulate")
  private Integer impressionCountAccumulate;
  /**
   * 累计点击
   * <p> 示例值：
   */
  @SerializedName("click_count_accumulate")
  private Integer clickCountAccumulate;
  /**
   * 累积点击跳过数
   * <p> 示例值：
   */
  @SerializedName("skip_count_accumulate")
  private Integer skipCountAccumulate;

  // builder 开始
  public SplashPageStat() {
  }

  public SplashPageStat(Builder builder) {
    /**
     * 日期
     * <p> 示例值：
     */
    this.date = builder.date;
    /**
     * 开屏素材id
     * <p> 示例值：
     */
    this.splashId = builder.splashId;
    /**
     * 曝光数
     * <p> 示例值：
     */
    this.impressionCount = builder.impressionCount;
    /**
     * 点击数
     * <p> 示例值：
     */
    this.clickCount = builder.clickCount;
    /**
     * 点击跳过数
     * <p> 示例值：
     */
    this.skipCount = builder.skipCount;
    /**
     * 累计曝光
     * <p> 示例值：
     */
    this.impressionCountAccumulate = builder.impressionCountAccumulate;
    /**
     * 累计点击
     * <p> 示例值：
     */
    this.clickCountAccumulate = builder.clickCountAccumulate;
    /**
     * 累积点击跳过数
     * <p> 示例值：
     */
    this.skipCountAccumulate = builder.skipCountAccumulate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getSplashId() {
    return this.splashId;
  }

  public void setSplashId(String splashId) {
    this.splashId = splashId;
  }

  public Integer getImpressionCount() {
    return this.impressionCount;
  }

  public void setImpressionCount(Integer impressionCount) {
    this.impressionCount = impressionCount;
  }

  public Integer getClickCount() {
    return this.clickCount;
  }

  public void setClickCount(Integer clickCount) {
    this.clickCount = clickCount;
  }

  public Integer getSkipCount() {
    return this.skipCount;
  }

  public void setSkipCount(Integer skipCount) {
    this.skipCount = skipCount;
  }

  public Integer getImpressionCountAccumulate() {
    return this.impressionCountAccumulate;
  }

  public void setImpressionCountAccumulate(Integer impressionCountAccumulate) {
    this.impressionCountAccumulate = impressionCountAccumulate;
  }

  public Integer getClickCountAccumulate() {
    return this.clickCountAccumulate;
  }

  public void setClickCountAccumulate(Integer clickCountAccumulate) {
    this.clickCountAccumulate = clickCountAccumulate;
  }

  public Integer getSkipCountAccumulate() {
    return this.skipCountAccumulate;
  }

  public void setSkipCountAccumulate(Integer skipCountAccumulate) {
    this.skipCountAccumulate = skipCountAccumulate;
  }

  public static class Builder {

    /**
     * 日期
     * <p> 示例值：
     */
    private String date;
    /**
     * 开屏素材id
     * <p> 示例值：
     */
    private String splashId;
    /**
     * 曝光数
     * <p> 示例值：
     */
    private Integer impressionCount;
    /**
     * 点击数
     * <p> 示例值：
     */
    private Integer clickCount;
    /**
     * 点击跳过数
     * <p> 示例值：
     */
    private Integer skipCount;
    /**
     * 累计曝光
     * <p> 示例值：
     */
    private Integer impressionCountAccumulate;
    /**
     * 累计点击
     * <p> 示例值：
     */
    private Integer clickCountAccumulate;
    /**
     * 累积点击跳过数
     * <p> 示例值：
     */
    private Integer skipCountAccumulate;

    /**
     * 日期
     * <p> 示例值：
     *
     * @param date
     * @return
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }


    /**
     * 开屏素材id
     * <p> 示例值：
     *
     * @param splashId
     * @return
     */
    public Builder splashId(String splashId) {
      this.splashId = splashId;
      return this;
    }


    /**
     * 曝光数
     * <p> 示例值：
     *
     * @param impressionCount
     * @return
     */
    public Builder impressionCount(Integer impressionCount) {
      this.impressionCount = impressionCount;
      return this;
    }


    /**
     * 点击数
     * <p> 示例值：
     *
     * @param clickCount
     * @return
     */
    public Builder clickCount(Integer clickCount) {
      this.clickCount = clickCount;
      return this;
    }


    /**
     * 点击跳过数
     * <p> 示例值：
     *
     * @param skipCount
     * @return
     */
    public Builder skipCount(Integer skipCount) {
      this.skipCount = skipCount;
      return this;
    }


    /**
     * 累计曝光
     * <p> 示例值：
     *
     * @param impressionCountAccumulate
     * @return
     */
    public Builder impressionCountAccumulate(Integer impressionCountAccumulate) {
      this.impressionCountAccumulate = impressionCountAccumulate;
      return this;
    }


    /**
     * 累计点击
     * <p> 示例值：
     *
     * @param clickCountAccumulate
     * @return
     */
    public Builder clickCountAccumulate(Integer clickCountAccumulate) {
      this.clickCountAccumulate = clickCountAccumulate;
      return this;
    }


    /**
     * 累积点击跳过数
     * <p> 示例值：
     *
     * @param skipCountAccumulate
     * @return
     */
    public Builder skipCountAccumulate(Integer skipCountAccumulate) {
      this.skipCountAccumulate = skipCountAccumulate;
      return this;
    }


    public SplashPageStat build() {
      return new SplashPageStat(this);
    }
  }
}