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

public class TaskApprove {

  /**
   * 审批定义 Code
   * <p> 示例值：7C468A54-8745-2245-9675-08B7C63E7A85
   */
  @SerializedName("approval_code")
  private String approvalCode;
  /**
   * 审批实例 Code
   * <p> 示例值：81D31358-93AF-92D6-7425-01A5D67C4E71
   */
  @SerializedName("instance_code")
  private String instanceCode;
  /**
   * 根据user_id_type填写操作用户id
   * <p> 示例值：f7cb567e
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 意见
   * <p> 示例值：OK
   */
  @SerializedName("comment")
  private String comment;
  /**
   * 任务 ID， 审批实例详情task_list中id
   * <p> 示例值：12345
   */
  @SerializedName("task_id")
  private String taskId;
  /**
   * json 数组，控件值
   * <p> 示例值：[{\"id\":\"111\", \"type\": \"input\", \"value\":\"test\"}]
   */
  @SerializedName("form")
  private String form;

  // builder 开始
  public TaskApprove() {
  }

  public TaskApprove(Builder builder) {
    /**
     * 审批定义 Code
     * <p> 示例值：7C468A54-8745-2245-9675-08B7C63E7A85
     */
    this.approvalCode = builder.approvalCode;
    /**
     * 审批实例 Code
     * <p> 示例值：81D31358-93AF-92D6-7425-01A5D67C4E71
     */
    this.instanceCode = builder.instanceCode;
    /**
     * 根据user_id_type填写操作用户id
     * <p> 示例值：f7cb567e
     */
    this.userId = builder.userId;
    /**
     * 意见
     * <p> 示例值：OK
     */
    this.comment = builder.comment;
    /**
     * 任务 ID， 审批实例详情task_list中id
     * <p> 示例值：12345
     */
    this.taskId = builder.taskId;
    /**
     * json 数组，控件值
     * <p> 示例值：[{\"id\":\"111\", \"type\": \"input\", \"value\":\"test\"}]
     */
    this.form = builder.form;
  }

  public static Builder newBuilder() {
    return new Builder();
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

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getTaskId() {
    return this.taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getForm() {
    return this.form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public static class Builder {

    /**
     * 审批定义 Code
     * <p> 示例值：7C468A54-8745-2245-9675-08B7C63E7A85
     */
    private String approvalCode;
    /**
     * 审批实例 Code
     * <p> 示例值：81D31358-93AF-92D6-7425-01A5D67C4E71
     */
    private String instanceCode;
    /**
     * 根据user_id_type填写操作用户id
     * <p> 示例值：f7cb567e
     */
    private String userId;
    /**
     * 意见
     * <p> 示例值：OK
     */
    private String comment;
    /**
     * 任务 ID， 审批实例详情task_list中id
     * <p> 示例值：12345
     */
    private String taskId;
    /**
     * json 数组，控件值
     * <p> 示例值：[{\"id\":\"111\", \"type\": \"input\", \"value\":\"test\"}]
     */
    private String form;

    /**
     * 审批定义 Code
     * <p> 示例值：7C468A54-8745-2245-9675-08B7C63E7A85
     *
     * @param approvalCode
     * @return
     */
    public Builder approvalCode(String approvalCode) {
      this.approvalCode = approvalCode;
      return this;
    }


    /**
     * 审批实例 Code
     * <p> 示例值：81D31358-93AF-92D6-7425-01A5D67C4E71
     *
     * @param instanceCode
     * @return
     */
    public Builder instanceCode(String instanceCode) {
      this.instanceCode = instanceCode;
      return this;
    }


    /**
     * 根据user_id_type填写操作用户id
     * <p> 示例值：f7cb567e
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 意见
     * <p> 示例值：OK
     *
     * @param comment
     * @return
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }


    /**
     * 任务 ID， 审批实例详情task_list中id
     * <p> 示例值：12345
     *
     * @param taskId
     * @return
     */
    public Builder taskId(String taskId) {
      this.taskId = taskId;
      return this;
    }


    /**
     * json 数组，控件值
     * <p> 示例值：[{\"id\":\"111\", \"type\": \"input\", \"value\":\"test\"}]
     *
     * @param form
     * @return
     */
    public Builder form(String form) {
      this.form = form;
      return this;
    }


    public TaskApprove build() {
      return new TaskApprove(this);
    }
  }
}