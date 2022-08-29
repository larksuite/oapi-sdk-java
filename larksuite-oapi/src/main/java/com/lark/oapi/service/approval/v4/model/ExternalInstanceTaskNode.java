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

public class ExternalInstanceTaskNode {

  /**
   * 审批实例内的唯一标识，用于更新审批任务时定位数据
   * <p> 示例值：112534
   */
  @SerializedName("task_id")
  private String taskId;
  /**
   * 审批人 user_id，该任务会出现在审批人的【待审批】或【已审批】列表中
   * <p> 示例值：a987sf9s
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 审批人 open id，和 user id 二选一
   * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
   */
  @SerializedName("open_id")
  private String openId;
  /**
   * 审批任务名称
   * <p> 示例值：i18n1
   */
  @SerializedName("title")
  private String title;
  /**
   * 【待审批】或【已审批】中使用的跳转链接，用于跳转回三方系统pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
   * <p> 示例值：
   */
  @SerializedName("links")
  private ExternalInstanceLink links;
  /**
   * 任务状态
   * <p> 示例值：PENDING
   */
  @SerializedName("status")
  private String status;
  /**
   * 扩展 json
   * <p> 示例值：{\"xxx\":\"xxx\"}
   */
  @SerializedName("extra")
  private String extra;
  /**
   * 任务创建时间，Unix 毫秒时间戳
   * <p> 示例值：1556468012678
   */
  @SerializedName("create_time")
  private String createTime;
  /**
   * 任务完成时间：未结束的审批为 0，Unix 毫秒时间戳
   * <p> 示例值：1556468012678
   */
  @SerializedName("end_time")
  private String endTime;
  /**
   * task最近更新时间，用于推送数据版本控制； 更新策略同 instance 中的 update_time
   * <p> 示例值：1556468012678
   */
  @SerializedName("update_time")
  private String updateTime;
  /**
   * 操作上下文，当用户操作时，回调请求中带上该参数，用于传递该任务的上下文数据
   * <p> 示例值：123456
   */
  @SerializedName("action_context")
  private String actionContext;
  /**
   * 任务级别操作配置,快捷审批目前支持移动端操作
   * <p> 示例值：
   */
  @SerializedName("action_configs")
  private ActionConfig[] actionConfigs;
  /**
   * 列表页打开审批任务的方式
   * <p> 示例值：BROWSER
   */
  @SerializedName("display_method")
  private String displayMethod;
  /**
   * 三方任务支持不纳入效率统计
   * <p> 示例值：true
   */
  @SerializedName("exclude_statistics")
  private Boolean excludeStatistics;

  // builder 开始
  public ExternalInstanceTaskNode() {
  }

  public ExternalInstanceTaskNode(Builder builder) {
    /**
     * 审批实例内的唯一标识，用于更新审批任务时定位数据
     * <p> 示例值：112534
     */
    this.taskId = builder.taskId;
    /**
     * 审批人 user_id，该任务会出现在审批人的【待审批】或【已审批】列表中
     * <p> 示例值：a987sf9s
     */
    this.userId = builder.userId;
    /**
     * 审批人 open id，和 user id 二选一
     * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
     */
    this.openId = builder.openId;
    /**
     * 审批任务名称
     * <p> 示例值：i18n1
     */
    this.title = builder.title;
    /**
     * 【待审批】或【已审批】中使用的跳转链接，用于跳转回三方系统pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
     * <p> 示例值：
     */
    this.links = builder.links;
    /**
     * 任务状态
     * <p> 示例值：PENDING
     */
    this.status = builder.status;
    /**
     * 扩展 json
     * <p> 示例值：{\"xxx\":\"xxx\"}
     */
    this.extra = builder.extra;
    /**
     * 任务创建时间，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    this.createTime = builder.createTime;
    /**
     * 任务完成时间：未结束的审批为 0，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    this.endTime = builder.endTime;
    /**
     * task最近更新时间，用于推送数据版本控制； 更新策略同 instance 中的 update_time
     * <p> 示例值：1556468012678
     */
    this.updateTime = builder.updateTime;
    /**
     * 操作上下文，当用户操作时，回调请求中带上该参数，用于传递该任务的上下文数据
     * <p> 示例值：123456
     */
    this.actionContext = builder.actionContext;
    /**
     * 任务级别操作配置,快捷审批目前支持移动端操作
     * <p> 示例值：
     */
    this.actionConfigs = builder.actionConfigs;
    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     */
    this.displayMethod = builder.displayMethod;
    /**
     * 三方任务支持不纳入效率统计
     * <p> 示例值：true
     */
    this.excludeStatistics = builder.excludeStatistics;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTaskId() {
    return this.taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ExternalInstanceLink getLinks() {
    return this.links;
  }

  public void setLinks(ExternalInstanceLink links) {
    this.links = links;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getExtra() {
    return this.extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

  public String getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getEndTime() {
    return this.endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getActionContext() {
    return this.actionContext;
  }

  public void setActionContext(String actionContext) {
    this.actionContext = actionContext;
  }

  public ActionConfig[] getActionConfigs() {
    return this.actionConfigs;
  }

  public void setActionConfigs(ActionConfig[] actionConfigs) {
    this.actionConfigs = actionConfigs;
  }

  public String getDisplayMethod() {
    return this.displayMethod;
  }

  public void setDisplayMethod(String displayMethod) {
    this.displayMethod = displayMethod;
  }

  public Boolean getExcludeStatistics() {
    return this.excludeStatistics;
  }

  public void setExcludeStatistics(Boolean excludeStatistics) {
    this.excludeStatistics = excludeStatistics;
  }

  public static class Builder {

    /**
     * 审批实例内的唯一标识，用于更新审批任务时定位数据
     * <p> 示例值：112534
     */
    private String taskId;
    /**
     * 审批人 user_id，该任务会出现在审批人的【待审批】或【已审批】列表中
     * <p> 示例值：a987sf9s
     */
    private String userId;
    /**
     * 审批人 open id，和 user id 二选一
     * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
     */
    private String openId;
    /**
     * 审批任务名称
     * <p> 示例值：i18n1
     */
    private String title;
    /**
     * 【待审批】或【已审批】中使用的跳转链接，用于跳转回三方系统pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
     * <p> 示例值：
     */
    private ExternalInstanceLink links;
    /**
     * 任务状态
     * <p> 示例值：PENDING
     */
    private String status;
    /**
     * 扩展 json
     * <p> 示例值：{\"xxx\":\"xxx\"}
     */
    private String extra;
    /**
     * 任务创建时间，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    private String createTime;
    /**
     * 任务完成时间：未结束的审批为 0，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    private String endTime;
    /**
     * task最近更新时间，用于推送数据版本控制； 更新策略同 instance 中的 update_time
     * <p> 示例值：1556468012678
     */
    private String updateTime;
    /**
     * 操作上下文，当用户操作时，回调请求中带上该参数，用于传递该任务的上下文数据
     * <p> 示例值：123456
     */
    private String actionContext;
    /**
     * 任务级别操作配置,快捷审批目前支持移动端操作
     * <p> 示例值：
     */
    private ActionConfig[] actionConfigs;
    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     */
    private String displayMethod;
    /**
     * 三方任务支持不纳入效率统计
     * <p> 示例值：true
     */
    private Boolean excludeStatistics;

    /**
     * 审批实例内的唯一标识，用于更新审批任务时定位数据
     * <p> 示例值：112534
     *
     * @param taskId
     * @return
     */
    public Builder taskId(String taskId) {
      this.taskId = taskId;
      return this;
    }


    /**
     * 审批人 user_id，该任务会出现在审批人的【待审批】或【已审批】列表中
     * <p> 示例值：a987sf9s
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 审批人 open id，和 user id 二选一
     * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
     *
     * @param openId
     * @return
     */
    public Builder openId(String openId) {
      this.openId = openId;
      return this;
    }


    /**
     * 审批任务名称
     * <p> 示例值：i18n1
     *
     * @param title
     * @return
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }


    /**
     * 【待审批】或【已审批】中使用的跳转链接，用于跳转回三方系统pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
     * <p> 示例值：
     *
     * @param links
     * @return
     */
    public Builder links(ExternalInstanceLink links) {
      this.links = links;
      return this;
    }


    /**
     * 任务状态
     * <p> 示例值：PENDING
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
     * <p> 示例值：PENDING
     *
     * @param status {@link com.lark.oapi.service.approval.v4.enums.ExternalInstanceTaskNodeStatusEnum}
     * @return
     */
    public Builder status(
        com.lark.oapi.service.approval.v4.enums.ExternalInstanceTaskNodeStatusEnum status) {
      this.status = status.getValue();
      return this;
    }


    /**
     * 扩展 json
     * <p> 示例值：{\"xxx\":\"xxx\"}
     *
     * @param extra
     * @return
     */
    public Builder extra(String extra) {
      this.extra = extra;
      return this;
    }


    /**
     * 任务创建时间，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     *
     * @param createTime
     * @return
     */
    public Builder createTime(String createTime) {
      this.createTime = createTime;
      return this;
    }


    /**
     * 任务完成时间：未结束的审批为 0，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     *
     * @param endTime
     * @return
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }


    /**
     * task最近更新时间，用于推送数据版本控制； 更新策略同 instance 中的 update_time
     * <p> 示例值：1556468012678
     *
     * @param updateTime
     * @return
     */
    public Builder updateTime(String updateTime) {
      this.updateTime = updateTime;
      return this;
    }


    /**
     * 操作上下文，当用户操作时，回调请求中带上该参数，用于传递该任务的上下文数据
     * <p> 示例值：123456
     *
     * @param actionContext
     * @return
     */
    public Builder actionContext(String actionContext) {
      this.actionContext = actionContext;
      return this;
    }


    /**
     * 任务级别操作配置,快捷审批目前支持移动端操作
     * <p> 示例值：
     *
     * @param actionConfigs
     * @return
     */
    public Builder actionConfigs(ActionConfig[] actionConfigs) {
      this.actionConfigs = actionConfigs;
      return this;
    }


    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     *
     * @param displayMethod
     * @return
     */
    public Builder displayMethod(String displayMethod) {
      this.displayMethod = displayMethod;
      return this;
    }

    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     *
     * @param displayMethod {@link com.lark.oapi.service.approval.v4.enums.ExternalInstanceTaskNodeDisplayMethodEnum}
     * @return
     */
    public Builder displayMethod(
        com.lark.oapi.service.approval.v4.enums.ExternalInstanceTaskNodeDisplayMethodEnum displayMethod) {
      this.displayMethod = displayMethod.getValue();
      return this;
    }


    /**
     * 三方任务支持不纳入效率统计
     * <p> 示例值：true
     *
     * @param excludeStatistics
     * @return
     */
    public Builder excludeStatistics(Boolean excludeStatistics) {
      this.excludeStatistics = excludeStatistics;
      return this;
    }


    public ExternalInstanceTaskNode build() {
      return new ExternalInstanceTaskNode(this);
    }
  }
}