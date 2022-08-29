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

package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class AppTableFieldPropertyOption {

  /**
   * 选项名
   * <p> 示例值：红色
   */
  @SerializedName("name")
  private String name;
  /**
   * 选项 ID，创建时不允许指定 ID
   * <p> 示例值：optKl35lnG
   */
  @SerializedName("id")
  private String id;
  /**
   * 选项颜色
   * <p> 示例值：0
   */
  @SerializedName("color")
  private Integer color;

  // builder 开始
  public AppTableFieldPropertyOption() {
  }

  public AppTableFieldPropertyOption(Builder builder) {
    /**
     * 选项名
     * <p> 示例值：红色
     */
    this.name = builder.name;
    /**
     * 选项 ID，创建时不允许指定 ID
     * <p> 示例值：optKl35lnG
     */
    this.id = builder.id;
    /**
     * 选项颜色
     * <p> 示例值：0
     */
    this.color = builder.color;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getColor() {
    return this.color;
  }

  public void setColor(Integer color) {
    this.color = color;
  }

  public static class Builder {

    /**
     * 选项名
     * <p> 示例值：红色
     */
    private String name;
    /**
     * 选项 ID，创建时不允许指定 ID
     * <p> 示例值：optKl35lnG
     */
    private String id;
    /**
     * 选项颜色
     * <p> 示例值：0
     */
    private Integer color;

    /**
     * 选项名
     * <p> 示例值：红色
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 选项 ID，创建时不允许指定 ID
     * <p> 示例值：optKl35lnG
     *
     * @param id
     * @return
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }


    /**
     * 选项颜色
     * <p> 示例值：0
     *
     * @param color
     * @return
     */
    public Builder color(Integer color) {
      this.color = color;
      return this;
    }


    public AppTableFieldPropertyOption build() {
      return new AppTableFieldPropertyOption(this);
    }
  }
}