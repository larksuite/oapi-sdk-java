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

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class TicketEventUpdateInfo {

  /**
   * ticket stage
   * <p> 示例值：1
   */
  @SerializedName("stage")
  private Integer stage;
  /**
   * ticket status
   * <p> 示例值：50
   */
  @SerializedName("status")
  private Integer status;
  /**
   * ticket update time
   * <p> 示例值：1616920429000
   */
  @SerializedName("updated_at")
  private Integer updatedAt;

  // builder 开始
  public TicketEventUpdateInfo() {
  }

  public TicketEventUpdateInfo(Builder builder) {
    /**
     * ticket stage
     * <p> 示例值：1
     */
    this.stage = builder.stage;
    /**
     * ticket status
     * <p> 示例值：50
     */
    this.status = builder.status;
    /**
     * ticket update time
     * <p> 示例值：1616920429000
     */
    this.updatedAt = builder.updatedAt;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getStage() {
    return this.stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Integer updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static class Builder {

    /**
     * ticket stage
     * <p> 示例值：1
     */
    private Integer stage;
    /**
     * ticket status
     * <p> 示例值：50
     */
    private Integer status;
    /**
     * ticket update time
     * <p> 示例值：1616920429000
     */
    private Integer updatedAt;

    /**
     * ticket stage
     * <p> 示例值：1
     *
     * @param stage
     * @return
     */
    public Builder stage(Integer stage) {
      this.stage = stage;
      return this;
    }


    /**
     * ticket status
     * <p> 示例值：50
     *
     * @param status
     * @return
     */
    public Builder status(Integer status) {
      this.status = status;
      return this;
    }


    /**
     * ticket update time
     * <p> 示例值：1616920429000
     *
     * @param updatedAt
     * @return
     */
    public Builder updatedAt(Integer updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }


    public TicketEventUpdateInfo build() {
      return new TicketEventUpdateInfo(this);
    }
  }
}