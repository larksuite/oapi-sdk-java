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

public class InstanceSearch {

  /**
   * 根据x_user_type填写用户 id
   * <p> 示例值：lwiu098wj
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 审批定义 code
   * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED942
   */
  @SerializedName("approval_code")
  private String approvalCode;
  /**
   * 审批实例 code
   * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
   */
  @SerializedName("instance_code")
  private String instanceCode;
  /**
   * 审批实例第三方 id 注：和 approval_code 取并集
   * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED976
   */
  @SerializedName("instance_external_id")
  private String instanceExternalId;
  /**
   * 审批定义分组第三方 id 注：和 instance_code 取并集
   * <p> 示例值：1234567
   */
  @SerializedName("group_external_id")
  private String groupExternalId;
  /**
   * 审批实例标题（只有第三方审批有）
   * <p> 示例值：test
   */
  @SerializedName("instance_title")
  private String instanceTitle;
  /**
   * 审批实例状态，注：若不设置，查询全部状态 若不在集合中，报错
   * <p> 示例值：PENDING
   */
  @SerializedName("instance_status")
  private String instanceStatus;
  /**
   * 实例查询开始时间（unix毫秒时间戳）
   * <p> 示例值：1547654251506
   */
  @SerializedName("instance_start_time_from")
  private String instanceStartTimeFrom;
  /**
   * 实例查询结束时间 (unix毫秒时间戳)
   * <p> 示例值：1547654251506
   */
  @SerializedName("instance_start_time_to")
  private String instanceStartTimeTo;
  /**
   * 地区
   * <p> 示例值：zh-CN
   */
  @SerializedName("locale")
  private String locale;

  // builder 开始
  public InstanceSearch() {
  }

  public InstanceSearch(Builder builder) {
    /**
     * 根据x_user_type填写用户 id
     * <p> 示例值：lwiu098wj
     */
    this.userId = builder.userId;
    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED942
     */
    this.approvalCode = builder.approvalCode;
    /**
     * 审批实例 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     */
    this.instanceCode = builder.instanceCode;
    /**
     * 审批实例第三方 id 注：和 approval_code 取并集
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED976
     */
    this.instanceExternalId = builder.instanceExternalId;
    /**
     * 审批定义分组第三方 id 注：和 instance_code 取并集
     * <p> 示例值：1234567
     */
    this.groupExternalId = builder.groupExternalId;
    /**
     * 审批实例标题（只有第三方审批有）
     * <p> 示例值：test
     */
    this.instanceTitle = builder.instanceTitle;
    /**
     * 审批实例状态，注：若不设置，查询全部状态 若不在集合中，报错
     * <p> 示例值：PENDING
     */
    this.instanceStatus = builder.instanceStatus;
    /**
     * 实例查询开始时间（unix毫秒时间戳）
     * <p> 示例值：1547654251506
     */
    this.instanceStartTimeFrom = builder.instanceStartTimeFrom;
    /**
     * 实例查询结束时间 (unix毫秒时间戳)
     * <p> 示例值：1547654251506
     */
    this.instanceStartTimeTo = builder.instanceStartTimeTo;
    /**
     * 地区
     * <p> 示例值：zh-CN
     */
    this.locale = builder.locale;
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

  public String getApprovalCode() {
    return this.approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getInstanceCode() {
    return this.instanceCode;
  }

  public void setInstanceCode(String instanceCode) {
    this.instanceCode = instanceCode;
  }

  public String getInstanceExternalId() {
    return this.instanceExternalId;
  }

  public void setInstanceExternalId(String instanceExternalId) {
    this.instanceExternalId = instanceExternalId;
  }

  public String getGroupExternalId() {
    return this.groupExternalId;
  }

  public void setGroupExternalId(String groupExternalId) {
    this.groupExternalId = groupExternalId;
  }

  public String getInstanceTitle() {
    return this.instanceTitle;
  }

  public void setInstanceTitle(String instanceTitle) {
    this.instanceTitle = instanceTitle;
  }

  public String getInstanceStatus() {
    return this.instanceStatus;
  }

  public void setInstanceStatus(String instanceStatus) {
    this.instanceStatus = instanceStatus;
  }

  public String getInstanceStartTimeFrom() {
    return this.instanceStartTimeFrom;
  }

  public void setInstanceStartTimeFrom(String instanceStartTimeFrom) {
    this.instanceStartTimeFrom = instanceStartTimeFrom;
  }

  public String getInstanceStartTimeTo() {
    return this.instanceStartTimeTo;
  }

  public void setInstanceStartTimeTo(String instanceStartTimeTo) {
    this.instanceStartTimeTo = instanceStartTimeTo;
  }

  public String getLocale() {
    return this.locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public static class Builder {

    /**
     * 根据x_user_type填写用户 id
     * <p> 示例值：lwiu098wj
     */
    private String userId;
    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED942
     */
    private String approvalCode;
    /**
     * 审批实例 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     */
    private String instanceCode;
    /**
     * 审批实例第三方 id 注：和 approval_code 取并集
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED976
     */
    private String instanceExternalId;
    /**
     * 审批定义分组第三方 id 注：和 instance_code 取并集
     * <p> 示例值：1234567
     */
    private String groupExternalId;
    /**
     * 审批实例标题（只有第三方审批有）
     * <p> 示例值：test
     */
    private String instanceTitle;
    /**
     * 审批实例状态，注：若不设置，查询全部状态 若不在集合中，报错
     * <p> 示例值：PENDING
     */
    private String instanceStatus;
    /**
     * 实例查询开始时间（unix毫秒时间戳）
     * <p> 示例值：1547654251506
     */
    private String instanceStartTimeFrom;
    /**
     * 实例查询结束时间 (unix毫秒时间戳)
     * <p> 示例值：1547654251506
     */
    private String instanceStartTimeTo;
    /**
     * 地区
     * <p> 示例值：zh-CN
     */
    private String locale;

    /**
     * 根据x_user_type填写用户 id
     * <p> 示例值：lwiu098wj
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 审批定义 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED942
     *
     * @param approvalCode
     * @return
     */
    public Builder approvalCode(String approvalCode) {
      this.approvalCode = approvalCode;
      return this;
    }


    /**
     * 审批实例 code
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED943
     *
     * @param instanceCode
     * @return
     */
    public Builder instanceCode(String instanceCode) {
      this.instanceCode = instanceCode;
      return this;
    }


    /**
     * 审批实例第三方 id 注：和 approval_code 取并集
     * <p> 示例值：EB828003-9FFE-4B3F-AA50-2E199E2ED976
     *
     * @param instanceExternalId
     * @return
     */
    public Builder instanceExternalId(String instanceExternalId) {
      this.instanceExternalId = instanceExternalId;
      return this;
    }


    /**
     * 审批定义分组第三方 id 注：和 instance_code 取并集
     * <p> 示例值：1234567
     *
     * @param groupExternalId
     * @return
     */
    public Builder groupExternalId(String groupExternalId) {
      this.groupExternalId = groupExternalId;
      return this;
    }


    /**
     * 审批实例标题（只有第三方审批有）
     * <p> 示例值：test
     *
     * @param instanceTitle
     * @return
     */
    public Builder instanceTitle(String instanceTitle) {
      this.instanceTitle = instanceTitle;
      return this;
    }


    /**
     * 审批实例状态，注：若不设置，查询全部状态 若不在集合中，报错
     * <p> 示例值：PENDING
     *
     * @param instanceStatus
     * @return
     */
    public Builder instanceStatus(String instanceStatus) {
      this.instanceStatus = instanceStatus;
      return this;
    }

    /**
     * 审批实例状态，注：若不设置，查询全部状态 若不在集合中，报错
     * <p> 示例值：PENDING
     *
     * @param instanceStatus {@link com.lark.oapi.service.approval.v4.enums.InstanceSearchInstanceStatusEnum}
     * @return
     */
    public Builder instanceStatus(
        com.lark.oapi.service.approval.v4.enums.InstanceSearchInstanceStatusEnum instanceStatus) {
      this.instanceStatus = instanceStatus.getValue();
      return this;
    }


    /**
     * 实例查询开始时间（unix毫秒时间戳）
     * <p> 示例值：1547654251506
     *
     * @param instanceStartTimeFrom
     * @return
     */
    public Builder instanceStartTimeFrom(String instanceStartTimeFrom) {
      this.instanceStartTimeFrom = instanceStartTimeFrom;
      return this;
    }


    /**
     * 实例查询结束时间 (unix毫秒时间戳)
     * <p> 示例值：1547654251506
     *
     * @param instanceStartTimeTo
     * @return
     */
    public Builder instanceStartTimeTo(String instanceStartTimeTo) {
      this.instanceStartTimeTo = instanceStartTimeTo;
      return this;
    }


    /**
     * 地区
     * <p> 示例值：zh-CN
     *
     * @param locale
     * @return
     */
    public Builder locale(String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * 地区
     * <p> 示例值：zh-CN
     *
     * @param locale {@link com.lark.oapi.service.approval.v4.enums.InstanceSearchLocaleEnum}
     * @return
     */
    public Builder locale(com.lark.oapi.service.approval.v4.enums.InstanceSearchLocaleEnum locale) {
      this.locale = locale.getValue();
      return this;
    }


    public InstanceSearch build() {
      return new InstanceSearch(this);
    }
  }
}