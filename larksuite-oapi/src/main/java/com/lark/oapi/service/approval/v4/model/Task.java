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

public class Task {

  /**
   * 任务所属的任务分组，如「待办」、「已办」等
   * <p> 示例值：1
   */
  @SerializedName("topic")
  private String topic;
  /**
   * 任务所属的用户 ID
   * <p> 示例值：example_user_id
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 任务题目
   * <p> 示例值：任务题目示例
   */
  @SerializedName("title")
  private String title;
  /**
   * 任务相关 URL
   * <p> 示例值：
   */
  @SerializedName("urls")
  private TaskUrls urls;
  /**
   * 流程三方 ID，仅第三方流程，需要在当前租户、当前 APP 内唯一
   * <p> 示例值：example_instance_id
   */
  @SerializedName("process_external_id")
  private String processExternalId;
  /**
   * 任务三方 ID，仅第三方流程，需要在当前流程实例内唯一
   * <p> 示例值：example_task_id
   */
  @SerializedName("task_external_id")
  private String taskExternalId;
  /**
   * 任务状态
   * <p> 示例值：Todo
   */
  @SerializedName("status")
  private String status;
  /**
   * 流程实例状态
   * <p> 示例值：Running
   */
  @SerializedName("process_status")
  private String processStatus;
  /**
   * 流程定义 Code
   * <p> 示例值：000000-00000000000000-0example
   */
  @SerializedName("definition_code")
  private String definitionCode;
  /**
   * 发起人 ID 列表
   * <p> 示例值：
   */
  @SerializedName("initiators")
  private String[] initiators;
  /**
   * 发起人姓名列表
   * <p> 示例值：
   */
  @SerializedName("initiator_names")
  private String[] initiatorNames;
  /**
   * 任务 ID，全局唯一
   * <p> 示例值：1212564555454
   */
  @SerializedName("task_id")
  private String taskId;
  /**
   * 流程 ID，全局唯一
   * <p> 示例值：1214564545474
   */
  @SerializedName("process_id")
  private String processId;
  /**
   * 流程 Code
   * <p> 示例值：123e4567-e89b-12d3-a456-426655440000
   */
  @SerializedName("process_code")
  private String processCode;
  /**
   * 流程定义分组 ID
   * <p> 示例值：1212564555454
   */
  @SerializedName("definition_group_id")
  private String definitionGroupId;
  /**
   * 流程定义分组名称
   * <p> 示例值：流程定义名称
   */
  @SerializedName("definition_group_name")
  private String definitionGroupName;
  /**
   * 流程定义 ID
   * <p> 示例值：1212564555454
   */
  @SerializedName("definition_id")
  private String definitionId;
  /**
   * 流程定义名称
   * <p> 示例值：流程定义组名称
   */
  @SerializedName("definition_name")
  private String definitionName;

  // builder 开始
  public Task() {
  }

  public Task(Builder builder) {
    /**
     * 任务所属的任务分组，如「待办」、「已办」等
     * <p> 示例值：1
     */
    this.topic = builder.topic;
    /**
     * 任务所属的用户 ID
     * <p> 示例值：example_user_id
     */
    this.userId = builder.userId;
    /**
     * 任务题目
     * <p> 示例值：任务题目示例
     */
    this.title = builder.title;
    /**
     * 任务相关 URL
     * <p> 示例值：
     */
    this.urls = builder.urls;
    /**
     * 流程三方 ID，仅第三方流程，需要在当前租户、当前 APP 内唯一
     * <p> 示例值：example_instance_id
     */
    this.processExternalId = builder.processExternalId;
    /**
     * 任务三方 ID，仅第三方流程，需要在当前流程实例内唯一
     * <p> 示例值：example_task_id
     */
    this.taskExternalId = builder.taskExternalId;
    /**
     * 任务状态
     * <p> 示例值：Todo
     */
    this.status = builder.status;
    /**
     * 流程实例状态
     * <p> 示例值：Running
     */
    this.processStatus = builder.processStatus;
    /**
     * 流程定义 Code
     * <p> 示例值：000000-00000000000000-0example
     */
    this.definitionCode = builder.definitionCode;
    /**
     * 发起人 ID 列表
     * <p> 示例值：
     */
    this.initiators = builder.initiators;
    /**
     * 发起人姓名列表
     * <p> 示例值：
     */
    this.initiatorNames = builder.initiatorNames;
    /**
     * 任务 ID，全局唯一
     * <p> 示例值：1212564555454
     */
    this.taskId = builder.taskId;
    /**
     * 流程 ID，全局唯一
     * <p> 示例值：1214564545474
     */
    this.processId = builder.processId;
    /**
     * 流程 Code
     * <p> 示例值：123e4567-e89b-12d3-a456-426655440000
     */
    this.processCode = builder.processCode;
    /**
     * 流程定义分组 ID
     * <p> 示例值：1212564555454
     */
    this.definitionGroupId = builder.definitionGroupId;
    /**
     * 流程定义分组名称
     * <p> 示例值：流程定义名称
     */
    this.definitionGroupName = builder.definitionGroupName;
    /**
     * 流程定义 ID
     * <p> 示例值：1212564555454
     */
    this.definitionId = builder.definitionId;
    /**
     * 流程定义名称
     * <p> 示例值：流程定义组名称
     */
    this.definitionName = builder.definitionName;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTopic() {
    return this.topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskUrls getUrls() {
    return this.urls;
  }

  public void setUrls(TaskUrls urls) {
    this.urls = urls;
  }

  public String getProcessExternalId() {
    return this.processExternalId;
  }

  public void setProcessExternalId(String processExternalId) {
    this.processExternalId = processExternalId;
  }

  public String getTaskExternalId() {
    return this.taskExternalId;
  }

  public void setTaskExternalId(String taskExternalId) {
    this.taskExternalId = taskExternalId;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getProcessStatus() {
    return this.processStatus;
  }

  public void setProcessStatus(String processStatus) {
    this.processStatus = processStatus;
  }

  public String getDefinitionCode() {
    return this.definitionCode;
  }

  public void setDefinitionCode(String definitionCode) {
    this.definitionCode = definitionCode;
  }

  public String[] getInitiators() {
    return this.initiators;
  }

  public void setInitiators(String[] initiators) {
    this.initiators = initiators;
  }

  public String[] getInitiatorNames() {
    return this.initiatorNames;
  }

  public void setInitiatorNames(String[] initiatorNames) {
    this.initiatorNames = initiatorNames;
  }

  public String getTaskId() {
    return this.taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getProcessId() {
    return this.processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  public String getProcessCode() {
    return this.processCode;
  }

  public void setProcessCode(String processCode) {
    this.processCode = processCode;
  }

  public String getDefinitionGroupId() {
    return this.definitionGroupId;
  }

  public void setDefinitionGroupId(String definitionGroupId) {
    this.definitionGroupId = definitionGroupId;
  }

  public String getDefinitionGroupName() {
    return this.definitionGroupName;
  }

  public void setDefinitionGroupName(String definitionGroupName) {
    this.definitionGroupName = definitionGroupName;
  }

  public String getDefinitionId() {
    return this.definitionId;
  }

  public void setDefinitionId(String definitionId) {
    this.definitionId = definitionId;
  }

  public String getDefinitionName() {
    return this.definitionName;
  }

  public void setDefinitionName(String definitionName) {
    this.definitionName = definitionName;
  }

  public static class Builder {

    /**
     * 任务所属的任务分组，如「待办」、「已办」等
     * <p> 示例值：1
     */
    private String topic;
    /**
     * 任务所属的用户 ID
     * <p> 示例值：example_user_id
     */
    private String userId;
    /**
     * 任务题目
     * <p> 示例值：任务题目示例
     */
    private String title;
    /**
     * 任务相关 URL
     * <p> 示例值：
     */
    private TaskUrls urls;
    /**
     * 流程三方 ID，仅第三方流程，需要在当前租户、当前 APP 内唯一
     * <p> 示例值：example_instance_id
     */
    private String processExternalId;
    /**
     * 任务三方 ID，仅第三方流程，需要在当前流程实例内唯一
     * <p> 示例值：example_task_id
     */
    private String taskExternalId;
    /**
     * 任务状态
     * <p> 示例值：Todo
     */
    private String status;
    /**
     * 流程实例状态
     * <p> 示例值：Running
     */
    private String processStatus;
    /**
     * 流程定义 Code
     * <p> 示例值：000000-00000000000000-0example
     */
    private String definitionCode;
    /**
     * 发起人 ID 列表
     * <p> 示例值：
     */
    private String[] initiators;
    /**
     * 发起人姓名列表
     * <p> 示例值：
     */
    private String[] initiatorNames;
    /**
     * 任务 ID，全局唯一
     * <p> 示例值：1212564555454
     */
    private String taskId;
    /**
     * 流程 ID，全局唯一
     * <p> 示例值：1214564545474
     */
    private String processId;
    /**
     * 流程 Code
     * <p> 示例值：123e4567-e89b-12d3-a456-426655440000
     */
    private String processCode;
    /**
     * 流程定义分组 ID
     * <p> 示例值：1212564555454
     */
    private String definitionGroupId;
    /**
     * 流程定义分组名称
     * <p> 示例值：流程定义名称
     */
    private String definitionGroupName;
    /**
     * 流程定义 ID
     * <p> 示例值：1212564555454
     */
    private String definitionId;
    /**
     * 流程定义名称
     * <p> 示例值：流程定义组名称
     */
    private String definitionName;

    /**
     * 任务所属的任务分组，如「待办」、「已办」等
     * <p> 示例值：1
     *
     * @param topic
     * @return
     */
    public Builder topic(String topic) {
      this.topic = topic;
      return this;
    }

    /**
     * 任务所属的任务分组，如「待办」、「已办」等
     * <p> 示例值：1
     *
     * @param topic {@link com.lark.oapi.service.approval.v4.enums.TaskTopicEnum}
     * @return
     */
    public Builder topic(com.lark.oapi.service.approval.v4.enums.TaskTopicEnum topic) {
      this.topic = topic.getValue();
      return this;
    }


    /**
     * 任务所属的用户 ID
     * <p> 示例值：example_user_id
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 任务题目
     * <p> 示例值：任务题目示例
     *
     * @param title
     * @return
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }


    /**
     * 任务相关 URL
     * <p> 示例值：
     *
     * @param urls
     * @return
     */
    public Builder urls(TaskUrls urls) {
      this.urls = urls;
      return this;
    }


    /**
     * 流程三方 ID，仅第三方流程，需要在当前租户、当前 APP 内唯一
     * <p> 示例值：example_instance_id
     *
     * @param processExternalId
     * @return
     */
    public Builder processExternalId(String processExternalId) {
      this.processExternalId = processExternalId;
      return this;
    }


    /**
     * 任务三方 ID，仅第三方流程，需要在当前流程实例内唯一
     * <p> 示例值：example_task_id
     *
     * @param taskExternalId
     * @return
     */
    public Builder taskExternalId(String taskExternalId) {
      this.taskExternalId = taskExternalId;
      return this;
    }


    /**
     * 任务状态
     * <p> 示例值：Todo
     *
     * @param status
     * @return
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * 任务状态
     * <p> 示例值：Todo
     *
     * @param status {@link com.lark.oapi.service.approval.v4.enums.TaskTaskStatusEnum}
     * @return
     */
    public Builder status(com.lark.oapi.service.approval.v4.enums.TaskTaskStatusEnum status) {
      this.status = status.getValue();
      return this;
    }


    /**
     * 流程实例状态
     * <p> 示例值：Running
     *
     * @param processStatus
     * @return
     */
    public Builder processStatus(String processStatus) {
      this.processStatus = processStatus;
      return this;
    }

    /**
     * 流程实例状态
     * <p> 示例值：Running
     *
     * @param processStatus {@link com.lark.oapi.service.approval.v4.enums.TaskProcessStatusEnum}
     * @return
     */
    public Builder processStatus(
        com.lark.oapi.service.approval.v4.enums.TaskProcessStatusEnum processStatus) {
      this.processStatus = processStatus.getValue();
      return this;
    }


    /**
     * 流程定义 Code
     * <p> 示例值：000000-00000000000000-0example
     *
     * @param definitionCode
     * @return
     */
    public Builder definitionCode(String definitionCode) {
      this.definitionCode = definitionCode;
      return this;
    }


    /**
     * 发起人 ID 列表
     * <p> 示例值：
     *
     * @param initiators
     * @return
     */
    public Builder initiators(String[] initiators) {
      this.initiators = initiators;
      return this;
    }


    /**
     * 发起人姓名列表
     * <p> 示例值：
     *
     * @param initiatorNames
     * @return
     */
    public Builder initiatorNames(String[] initiatorNames) {
      this.initiatorNames = initiatorNames;
      return this;
    }


    /**
     * 任务 ID，全局唯一
     * <p> 示例值：1212564555454
     *
     * @param taskId
     * @return
     */
    public Builder taskId(String taskId) {
      this.taskId = taskId;
      return this;
    }


    /**
     * 流程 ID，全局唯一
     * <p> 示例值：1214564545474
     *
     * @param processId
     * @return
     */
    public Builder processId(String processId) {
      this.processId = processId;
      return this;
    }


    /**
     * 流程 Code
     * <p> 示例值：123e4567-e89b-12d3-a456-426655440000
     *
     * @param processCode
     * @return
     */
    public Builder processCode(String processCode) {
      this.processCode = processCode;
      return this;
    }


    /**
     * 流程定义分组 ID
     * <p> 示例值：1212564555454
     *
     * @param definitionGroupId
     * @return
     */
    public Builder definitionGroupId(String definitionGroupId) {
      this.definitionGroupId = definitionGroupId;
      return this;
    }


    /**
     * 流程定义分组名称
     * <p> 示例值：流程定义名称
     *
     * @param definitionGroupName
     * @return
     */
    public Builder definitionGroupName(String definitionGroupName) {
      this.definitionGroupName = definitionGroupName;
      return this;
    }


    /**
     * 流程定义 ID
     * <p> 示例值：1212564555454
     *
     * @param definitionId
     * @return
     */
    public Builder definitionId(String definitionId) {
      this.definitionId = definitionId;
      return this;
    }


    /**
     * 流程定义名称
     * <p> 示例值：流程定义组名称
     *
     * @param definitionName
     * @return
     */
    public Builder definitionName(String definitionName) {
      this.definitionName = definitionName;
      return this;
    }


    public Task build() {
      return new Task(this);
    }
  }
}