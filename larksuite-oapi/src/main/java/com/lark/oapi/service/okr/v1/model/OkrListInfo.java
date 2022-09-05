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

public class OkrListInfo {

  /**
   * 中文内容
   * <p> 示例值：
   */
  @SerializedName("current_okr")
  private Okr currentOkr;
  /**
   * 英文内容
   * <p> 示例值：
   */
  @SerializedName("okr_list")
  private Okr[] okrList;

  // builder 开始
  public OkrListInfo() {
  }

  public OkrListInfo(Builder builder) {
    /**
     * 中文内容
     * <p> 示例值：
     */
    this.currentOkr = builder.currentOkr;
    /**
     * 英文内容
     * <p> 示例值：
     */
    this.okrList = builder.okrList;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Okr getCurrentOkr() {
    return this.currentOkr;
  }

  public void setCurrentOkr(Okr currentOkr) {
    this.currentOkr = currentOkr;
  }

  public Okr[] getOkrList() {
    return this.okrList;
  }

  public void setOkrList(Okr[] okrList) {
    this.okrList = okrList;
  }

  public static class Builder {

    /**
     * 中文内容
     * <p> 示例值：
     */
    private Okr currentOkr;
    /**
     * 英文内容
     * <p> 示例值：
     */
    private Okr[] okrList;

    /**
     * 中文内容
     * <p> 示例值：
     *
     * @param currentOkr
     * @return
     */
    public Builder currentOkr(Okr currentOkr) {
      this.currentOkr = currentOkr;
      return this;
    }


    /**
     * 英文内容
     * <p> 示例值：
     *
     * @param okrList
     * @return
     */
    public Builder okrList(Okr[] okrList) {
      this.okrList = okrList;
      return this;
    }


    public OkrListInfo build() {
      return new OkrListInfo(this);
    }
  }
}