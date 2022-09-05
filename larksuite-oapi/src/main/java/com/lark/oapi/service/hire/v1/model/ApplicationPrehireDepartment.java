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

package com.lark.oapi.service.hire.v1.model;

import com.google.gson.annotations.SerializedName;

public class ApplicationPrehireDepartment {

  /**
   * <p> 示例值：6949805467799537964
   */
  @SerializedName("id")
  private String id;
  /**
   * <p> 示例值：
   */
  @SerializedName("name")
  private String name;
  /**
   * <p> 示例值：
   */
  @SerializedName("en_name")
  private String enName;

  // builder 开始
  public ApplicationPrehireDepartment() {
  }

  public ApplicationPrehireDepartment(Builder builder) {
    /**
     *
     * <p> 示例值：6949805467799537964
     */
    this.id = builder.id;
    /**
     *
     * <p> 示例值：
     */
    this.name = builder.name;
    /**
     *
     * <p> 示例值：
     */
    this.enName = builder.enName;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEnName() {
    return this.enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public static class Builder {

    /**
     * <p> 示例值：6949805467799537964
     */
    private String id;
    /**
     * <p> 示例值：
     */
    private String name;
    /**
     * <p> 示例值：
     */
    private String enName;

    /**
     * <p> 示例值：6949805467799537964
     *
     * @param id
     * @return
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param enName
     * @return
     */
    public Builder enName(String enName) {
      this.enName = enName;
      return this;
    }


    public ApplicationPrehireDepartment build() {
      return new ApplicationPrehireDepartment(this);
    }
  }
}