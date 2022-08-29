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

public class ApprovalEvent {

  /**
   * <p> 示例值：
   */
  @SerializedName("approval_id")
  private String approvalId;
  /**
   * <p> 示例值：
   */
  @SerializedName("approval_code")
  private String approvalCode;
  /**
   * <p> 示例值：
   */
  @SerializedName("version_id")
  private String versionId;
  /**
   * <p> 示例值：
   */
  @SerializedName("widget_group_type")
  private Integer widgetGroupType;
  /**
   * <p> 示例值：
   */
  @SerializedName("form_definition_id")
  private String formDefinitionId;
  /**
   * <p> 示例值：
   */
  @SerializedName("process_obj")
  private String processObj;
  /**
   * <p> 示例值：
   */
  @SerializedName("timestamp")
  private String timestamp;
  /**
   * <p> 示例值：
   */
  @SerializedName("extra")
  private String extra;

  // builder 开始
  public ApprovalEvent() {
  }

  public ApprovalEvent(Builder builder) {
    /**
     *
     * <p> 示例值：
     */
    this.approvalId = builder.approvalId;
    /**
     *
     * <p> 示例值：
     */
    this.approvalCode = builder.approvalCode;
    /**
     *
     * <p> 示例值：
     */
    this.versionId = builder.versionId;
    /**
     *
     * <p> 示例值：
     */
    this.widgetGroupType = builder.widgetGroupType;
    /**
     *
     * <p> 示例值：
     */
    this.formDefinitionId = builder.formDefinitionId;
    /**
     *
     * <p> 示例值：
     */
    this.processObj = builder.processObj;
    /**
     *
     * <p> 示例值：
     */
    this.timestamp = builder.timestamp;
    /**
     *
     * <p> 示例值：
     */
    this.extra = builder.extra;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getApprovalId() {
    return this.approvalId;
  }

  public void setApprovalId(String approvalId) {
    this.approvalId = approvalId;
  }

  public String getApprovalCode() {
    return this.approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getVersionId() {
    return this.versionId;
  }

  public void setVersionId(String versionId) {
    this.versionId = versionId;
  }

  public Integer getWidgetGroupType() {
    return this.widgetGroupType;
  }

  public void setWidgetGroupType(Integer widgetGroupType) {
    this.widgetGroupType = widgetGroupType;
  }

  public String getFormDefinitionId() {
    return this.formDefinitionId;
  }

  public void setFormDefinitionId(String formDefinitionId) {
    this.formDefinitionId = formDefinitionId;
  }

  public String getProcessObj() {
    return this.processObj;
  }

  public void setProcessObj(String processObj) {
    this.processObj = processObj;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getExtra() {
    return this.extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

  public static class Builder {

    /**
     * <p> 示例值：
     */
    private String approvalId;
    /**
     * <p> 示例值：
     */
    private String approvalCode;
    /**
     * <p> 示例值：
     */
    private String versionId;
    /**
     * <p> 示例值：
     */
    private Integer widgetGroupType;
    /**
     * <p> 示例值：
     */
    private String formDefinitionId;
    /**
     * <p> 示例值：
     */
    private String processObj;
    /**
     * <p> 示例值：
     */
    private String timestamp;
    /**
     * <p> 示例值：
     */
    private String extra;

    /**
     * <p> 示例值：
     *
     * @param approvalId
     * @return
     */
    public Builder approvalId(String approvalId) {
      this.approvalId = approvalId;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param approvalCode
     * @return
     */
    public Builder approvalCode(String approvalCode) {
      this.approvalCode = approvalCode;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param versionId
     * @return
     */
    public Builder versionId(String versionId) {
      this.versionId = versionId;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param widgetGroupType
     * @return
     */
    public Builder widgetGroupType(Integer widgetGroupType) {
      this.widgetGroupType = widgetGroupType;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param formDefinitionId
     * @return
     */
    public Builder formDefinitionId(String formDefinitionId) {
      this.formDefinitionId = formDefinitionId;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param processObj
     * @return
     */
    public Builder processObj(String processObj) {
      this.processObj = processObj;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param timestamp
     * @return
     */
    public Builder timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }


    /**
     * <p> 示例值：
     *
     * @param extra
     * @return
     */
    public Builder extra(String extra) {
      this.extra = extra;
      return this;
    }


    public ApprovalEvent build() {
      return new ApprovalEvent(this);
    }
  }
}