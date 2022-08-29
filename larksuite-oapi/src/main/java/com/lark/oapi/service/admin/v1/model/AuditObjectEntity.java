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

public class AuditObjectEntity {

  /**
   * 操作对象类型
   * <p> 示例值：
   */
  @SerializedName("object_type")
  private String objectType;
  /**
   * 操作对象值，可能存在department_id、user_id等，需要进行lark_id的转换
   * <p> 示例值：
   */
  @SerializedName("object_value")
  private String objectValue;
  /**
   * 操作对象名称，如会话名、文档名等
   * <p> 示例值：
   */
  @SerializedName("object_name")
  private String objectName;
  /**
   * 操作对象的所有者
   * <p> 示例值：
   */
  @SerializedName("object_owner")
  private String objectOwner;
  /**
   * object 详情
   * <p> 示例值：
   */
  @SerializedName("object_detail")
  private AuditObjectDetail objectDetail;

  // builder 开始
  public AuditObjectEntity() {
  }

  public AuditObjectEntity(Builder builder) {
    /**
     * 操作对象类型
     * <p> 示例值：
     */
    this.objectType = builder.objectType;
    /**
     * 操作对象值，可能存在department_id、user_id等，需要进行lark_id的转换
     * <p> 示例值：
     */
    this.objectValue = builder.objectValue;
    /**
     * 操作对象名称，如会话名、文档名等
     * <p> 示例值：
     */
    this.objectName = builder.objectName;
    /**
     * 操作对象的所有者
     * <p> 示例值：
     */
    this.objectOwner = builder.objectOwner;
    /**
     * object 详情
     * <p> 示例值：
     */
    this.objectDetail = builder.objectDetail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getObjectType() {
    return this.objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String getObjectValue() {
    return this.objectValue;
  }

  public void setObjectValue(String objectValue) {
    this.objectValue = objectValue;
  }

  public String getObjectName() {
    return this.objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getObjectOwner() {
    return this.objectOwner;
  }

  public void setObjectOwner(String objectOwner) {
    this.objectOwner = objectOwner;
  }

  public AuditObjectDetail getObjectDetail() {
    return this.objectDetail;
  }

  public void setObjectDetail(AuditObjectDetail objectDetail) {
    this.objectDetail = objectDetail;
  }

  public static class Builder {

    /**
     * 操作对象类型
     * <p> 示例值：
     */
    private String objectType;
    /**
     * 操作对象值，可能存在department_id、user_id等，需要进行lark_id的转换
     * <p> 示例值：
     */
    private String objectValue;
    /**
     * 操作对象名称，如会话名、文档名等
     * <p> 示例值：
     */
    private String objectName;
    /**
     * 操作对象的所有者
     * <p> 示例值：
     */
    private String objectOwner;
    /**
     * object 详情
     * <p> 示例值：
     */
    private AuditObjectDetail objectDetail;

    /**
     * 操作对象类型
     * <p> 示例值：
     *
     * @param objectType
     * @return
     */
    public Builder objectType(String objectType) {
      this.objectType = objectType;
      return this;
    }


    /**
     * 操作对象值，可能存在department_id、user_id等，需要进行lark_id的转换
     * <p> 示例值：
     *
     * @param objectValue
     * @return
     */
    public Builder objectValue(String objectValue) {
      this.objectValue = objectValue;
      return this;
    }


    /**
     * 操作对象名称，如会话名、文档名等
     * <p> 示例值：
     *
     * @param objectName
     * @return
     */
    public Builder objectName(String objectName) {
      this.objectName = objectName;
      return this;
    }


    /**
     * 操作对象的所有者
     * <p> 示例值：
     *
     * @param objectOwner
     * @return
     */
    public Builder objectOwner(String objectOwner) {
      this.objectOwner = objectOwner;
      return this;
    }


    /**
     * object 详情
     * <p> 示例值：
     *
     * @param objectDetail
     * @return
     */
    public Builder objectDetail(AuditObjectDetail objectDetail) {
      this.objectDetail = objectDetail;
      return this;
    }


    public AuditObjectEntity build() {
      return new AuditObjectEntity(this);
    }
  }
}