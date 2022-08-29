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

package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class CreateUnitReqBody {

  /**
   * 单位自定义ID。不带默认自动生成。1-64字节范围大小，需为数字字母
   * <p> 示例值：BU121
   */
  @SerializedName("unit_id")
  private String unitId;
  /**
   * 单位的名字，长度范围为1-100个字
   * <p> 示例值：消费者事业部
   */
  @SerializedName("name")
  private String name;
  /**
   * 单位类型，长度范围为1-100个字，创建后不可修改
   * <p> 示例值：事业部
   */
  @SerializedName("unit_type")
  private String unitType;

  // builder 开始
  public CreateUnitReqBody() {
  }

  public CreateUnitReqBody(Builder builder) {
    /**
     * 单位自定义ID。不带默认自动生成。1-64字节范围大小，需为数字字母
     * <p> 示例值：BU121
     */
    this.unitId = builder.unitId;
    /**
     * 单位的名字，长度范围为1-100个字
     * <p> 示例值：消费者事业部
     */
    this.name = builder.name;
    /**
     * 单位类型，长度范围为1-100个字，创建后不可修改
     * <p> 示例值：事业部
     */
    this.unitType = builder.unitType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUnitId() {
    return this.unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnitType() {
    return this.unitType;
  }

  public void setUnitType(String unitType) {
    this.unitType = unitType;
  }

  public static class Builder {

    /**
     * 单位自定义ID。不带默认自动生成。1-64字节范围大小，需为数字字母
     * <p> 示例值：BU121
     */
    private String unitId;
    /**
     * 单位的名字，长度范围为1-100个字
     * <p> 示例值：消费者事业部
     */
    private String name;
    /**
     * 单位类型，长度范围为1-100个字，创建后不可修改
     * <p> 示例值：事业部
     */
    private String unitType;

    /**
     * 单位自定义ID。不带默认自动生成。1-64字节范围大小，需为数字字母
     * <p> 示例值：BU121
     *
     * @param unitId
     * @return
     */
    public Builder unitId(String unitId) {
      this.unitId = unitId;
      return this;
    }


    /**
     * 单位的名字，长度范围为1-100个字
     * <p> 示例值：消费者事业部
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 单位类型，长度范围为1-100个字，创建后不可修改
     * <p> 示例值：事业部
     *
     * @param unitType
     * @return
     */
    public Builder unitType(String unitType) {
      this.unitType = unitType;
      return this;
    }


    public CreateUnitReqBody build() {
      return new CreateUnitReqBody(this);
    }
  }
}