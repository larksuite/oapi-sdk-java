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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class ClientBadgeNum {

  /**
   * h5能力的badge数量
   * <p> 示例值：
   */
  @SerializedName("web_app")
  private Integer webApp;
  /**
   * 小程序能力的badge数量
   * <p> 示例值：
   */
  @SerializedName("gadget")
  private Integer gadget;

  // builder 开始
  public ClientBadgeNum() {
  }

  public ClientBadgeNum(Builder builder) {
    /**
     * h5能力的badge数量
     * <p> 示例值：
     */
    this.webApp = builder.webApp;
    /**
     * 小程序能力的badge数量
     * <p> 示例值：
     */
    this.gadget = builder.gadget;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getWebApp() {
    return this.webApp;
  }

  public void setWebApp(Integer webApp) {
    this.webApp = webApp;
  }

  public Integer getGadget() {
    return this.gadget;
  }

  public void setGadget(Integer gadget) {
    this.gadget = gadget;
  }

  public static class Builder {

    /**
     * h5能力的badge数量
     * <p> 示例值：
     */
    private Integer webApp;
    /**
     * 小程序能力的badge数量
     * <p> 示例值：
     */
    private Integer gadget;

    /**
     * h5能力的badge数量
     * <p> 示例值：
     *
     * @param webApp
     * @return
     */
    public Builder webApp(Integer webApp) {
      this.webApp = webApp;
      return this;
    }


    /**
     * 小程序能力的badge数量
     * <p> 示例值：
     *
     * @param gadget
     * @return
     */
    public Builder gadget(Integer gadget) {
      this.gadget = gadget;
      return this;
    }


    public ClientBadgeNum build() {
      return new ClientBadgeNum(this);
    }
  }
}