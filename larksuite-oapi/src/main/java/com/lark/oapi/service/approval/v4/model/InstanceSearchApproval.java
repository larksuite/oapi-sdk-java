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

package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class InstanceSearchApproval {

  /**
   * 审批定义 code
   * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
   */
  @SerializedName("code")
  private String code;
  /**
   * 审批定义名称
   * <p> 示例值：approval
   */
  @SerializedName("name")
  private String name;
  /**
   * 是否为第三方审批
   * <p> 示例值：true
   */
  @SerializedName("is_external")
  private Boolean isExternal;
  /**
   * 第三方审批信息
   * <p> 示例值：
   */
  @SerializedName("external")
  private InstanceSearchApprovalExternal external;

  // builder 开始
  public InstanceSearchApproval() {
  }

  public InstanceSearchApproval(Builder builder) {
    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     */
    this.code = builder.code;
    /**
     * 审批定义名称
     * <p> 示例值：approval
     */
    this.name = builder.name;
    /**
     * 是否为第三方审批
     * <p> 示例值：true
     */
    this.isExternal = builder.isExternal;
    /**
     * 第三方审批信息
     * <p> 示例值：
     */
    this.external = builder.external;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsExternal() {
    return this.isExternal;
  }

  public void setIsExternal(Boolean isExternal) {
    this.isExternal = isExternal;
  }

  public InstanceSearchApprovalExternal getExternal() {
    return this.external;
  }

  public void setExternal(InstanceSearchApprovalExternal external) {
    this.external = external;
  }

  public static class Builder {

    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     */
    private String code;
    /**
     * 审批定义名称
     * <p> 示例值：approval
     */
    private String name;
    /**
     * 是否为第三方审批
     * <p> 示例值：true
     */
    private Boolean isExternal;
    /**
     * 第三方审批信息
     * <p> 示例值：
     */
    private InstanceSearchApprovalExternal external;

    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     *
     * @param code
     * @return
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }


    /**
     * 审批定义名称
     * <p> 示例值：approval
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 是否为第三方审批
     * <p> 示例值：true
     *
     * @param isExternal
     * @return
     */
    public Builder isExternal(Boolean isExternal) {
      this.isExternal = isExternal;
      return this;
    }


    /**
     * 第三方审批信息
     * <p> 示例值：
     *
     * @param external
     * @return
     */
    public Builder external(InstanceSearchApprovalExternal external) {
      this.external = external;
      return this;
    }


    public InstanceSearchApproval build() {
      return new InstanceSearchApproval(this);
    }
  }
}