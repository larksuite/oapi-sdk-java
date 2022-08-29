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

package com.lark.oapi.service.ehr.v1.model;

import com.google.gson.annotations.SerializedName;

public class Employee {

  /**
   * 员工的用户 ID;;;user_id_type 为 user_id 时返回 user_id；;;;user_id_type 为 open_id 时返回
   * open_id；;;;user_id_type 为 union_id 时返回 union_id；;;;「待入职」和「已取消入职」的员工，此字段值为 null
   * <p> 示例值：ou_db362c0e79f5a26db1ca8e94698ee417
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 系统字段
   * <p> 示例值：
   */
  @SerializedName("system_fields")
  private SystemFields systemFields;
  /**
   * 自定义字段
   * <p> 示例值：
   */
  @SerializedName("custom_fields")
  private CustomFields[] customFields;

  // builder 开始
  public Employee() {
  }

  public Employee(Builder builder) {
    /**
     * 员工的用户 ID;;;user_id_type 为 user_id 时返回 user_id；;;;user_id_type 为 open_id 时返回 open_id；;;;user_id_type 为 union_id 时返回 union_id；;;;「待入职」和「已取消入职」的员工，此字段值为 null
     * <p> 示例值：ou_db362c0e79f5a26db1ca8e94698ee417
     */
    this.userId = builder.userId;
    /**
     * 系统字段
     * <p> 示例值：
     */
    this.systemFields = builder.systemFields;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    this.customFields = builder.customFields;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public SystemFields getSystemFields() {
    return this.systemFields;
  }

  public void setSystemFields(SystemFields systemFields) {
    this.systemFields = systemFields;
  }

  public CustomFields[] getCustomFields() {
    return this.customFields;
  }

  public void setCustomFields(CustomFields[] customFields) {
    this.customFields = customFields;
  }

  public static class Builder {

    /**
     * 员工的用户 ID;;;user_id_type 为 user_id 时返回 user_id；;;;user_id_type 为 open_id 时返回
     * open_id；;;;user_id_type 为 union_id 时返回 union_id；;;;「待入职」和「已取消入职」的员工，此字段值为 null
     * <p> 示例值：ou_db362c0e79f5a26db1ca8e94698ee417
     */
    private String userId;
    /**
     * 系统字段
     * <p> 示例值：
     */
    private SystemFields systemFields;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    private CustomFields[] customFields;

    /**
     * 员工的用户 ID;;;user_id_type 为 user_id 时返回 user_id；;;;user_id_type 为 open_id 时返回
     * open_id；;;;user_id_type 为 union_id 时返回 union_id；;;;「待入职」和「已取消入职」的员工，此字段值为 null
     * <p> 示例值：ou_db362c0e79f5a26db1ca8e94698ee417
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 系统字段
     * <p> 示例值：
     *
     * @param systemFields
     * @return
     */
    public Builder systemFields(SystemFields systemFields) {
      this.systemFields = systemFields;
      return this;
    }


    /**
     * 自定义字段
     * <p> 示例值：
     *
     * @param customFields
     * @return
     */
    public Builder customFields(CustomFields[] customFields) {
      this.customFields = customFields;
      return this;
    }


    public Employee build() {
      return new Employee(this);
    }
  }
}