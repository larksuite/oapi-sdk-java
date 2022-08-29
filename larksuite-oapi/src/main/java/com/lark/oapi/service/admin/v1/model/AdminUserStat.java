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

public class AdminUserStat {

  /**
   * 日期
   * <p> 示例值：2020-02-15
   */
  @SerializedName("date")
  private String date;
  /**
   * 用户ID
   * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 用户名
   * <p> 示例值：Zhang San
   */
  @SerializedName("user_name")
  private String userName;
  /**
   * 部门名
   * <p> 示例值：testcqlbfaaasdasdasd
   */
  @SerializedName("department_name")
  private String departmentName;
  /**
   * 部门路径
   * <p> 示例值：testkkk/testcqlbfaaasdasdasd
   */
  @SerializedName("department_path")
  private String departmentPath;
  /**
   * 账号创建时间
   * <p> 示例值：2020-09-04 11:17:55
   */
  @SerializedName("create_time")
  private String createTime;
  /**
   * 用户激活状态
   * <p> 示例值：1
   */
  @SerializedName("user_active_flag")
  private Integer userActiveFlag;
  /**
   * 激活时间
   * <p> 示例值：2020-09-04 11:18:32
   */
  @SerializedName("register_time")
  private String registerTime;
  /**
   * 用户活跃状态，用户在飞书套件任意应用登陆，即为活跃。包括飞书即时消息，文档，日历，会议，开放平台等
   * <p> 示例值：1
   */
  @SerializedName("suite_active_flag")
  private Integer suiteActiveFlag;
  /**
   * 最近活跃时间
   * <p> 示例值：2020-12-21 22:21:28
   */
  @SerializedName("last_active_time")
  private String lastActiveTime;
  /**
   * 用户消息活跃状态，发生过如下事件，则认为该用户消息活跃：;发送消息、回复消息、reaction、转发消息、阅读消息、查看会话、发送表情消息等
   * <p> 示例值：1
   */
  @SerializedName("im_active_flag")
  private Integer imActiveFlag;
  /**
   * 发送消息数
   * <p> 示例值：0
   */
  @SerializedName("send_messenger_num")
  private Integer sendMessengerNum;
  /**
   * 用户云文档活跃状态，"发生过如下事件，则认为该用户云文档活跃： ;事件1：文档/文件打开;事件2：进入docs相关页面：如文档详情页，space的各个页面"
   * <p> 示例值：1
   */
  @SerializedName("docs_active_flag")
  private Integer docsActiveFlag;
  /**
   * 创建文件数
   * <p> 示例值：1
   */
  @SerializedName("create_docs_num")
  private Integer createDocsNum;
  /**
   * 用户日历活跃状态，发生过如下事件，则认为用户日历活跃，包含进入日历、创建日程、收到日程邀请等
   * <p> 示例值：1
   */
  @SerializedName("cal_active_flag")
  private Integer calActiveFlag;
  /**
   * 创建日程数
   * <p> 示例值：0
   */
  @SerializedName("create_cal_num")
  private Integer createCalNum;
  /**
   * 用户音视频会议活跃状态，用户进入会中状态（不包含妙计和直播）即为活跃
   * <p> 示例值：1
   */
  @SerializedName("vc_active_flag")
  private Integer vcActiveFlag;
  /**
   * 会议时长
   * <p> 示例值：0
   */
  @SerializedName("vc_duration")
  private Integer vcDuration;
  /**
   * 活跃设备
   * <p> 示例值：'ios 14.2,-','ios 14.2,feishu 3.40.0-alpha'
   */
  @SerializedName("active_os")
  private String activeOs;
  /**
   * 创建任务数
   * <p> 示例值：0
   */
  @SerializedName("create_task_num")
  private Integer createTaskNum;
  /**
   * 会议数
   * <p> 示例值：0
   */
  @SerializedName("vc_num")
  private Integer vcNum;
  /**
   * 飞书的应用类型名称
   * <p> 示例值：
   */
  @SerializedName("app_package_type")
  private String appPackageType;
  /**
   * 操作系统名称
   * <p> 示例值：
   */
  @SerializedName("os_name")
  private String osName;

  // builder 开始
  public AdminUserStat() {
  }

  public AdminUserStat(Builder builder) {
    /**
     * 日期
     * <p> 示例值：2020-02-15
     */
    this.date = builder.date;
    /**
     * 用户ID
     * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
     */
    this.userId = builder.userId;
    /**
     * 用户名
     * <p> 示例值：Zhang San
     */
    this.userName = builder.userName;
    /**
     * 部门名
     * <p> 示例值：testcqlbfaaasdasdasd
     */
    this.departmentName = builder.departmentName;
    /**
     * 部门路径
     * <p> 示例值：testkkk/testcqlbfaaasdasdasd
     */
    this.departmentPath = builder.departmentPath;
    /**
     * 账号创建时间
     * <p> 示例值：2020-09-04 11:17:55
     */
    this.createTime = builder.createTime;
    /**
     * 用户激活状态
     * <p> 示例值：1
     */
    this.userActiveFlag = builder.userActiveFlag;
    /**
     * 激活时间
     * <p> 示例值：2020-09-04 11:18:32
     */
    this.registerTime = builder.registerTime;
    /**
     * 用户活跃状态，用户在飞书套件任意应用登陆，即为活跃。包括飞书即时消息，文档，日历，会议，开放平台等
     * <p> 示例值：1
     */
    this.suiteActiveFlag = builder.suiteActiveFlag;
    /**
     * 最近活跃时间
     * <p> 示例值：2020-12-21 22:21:28
     */
    this.lastActiveTime = builder.lastActiveTime;
    /**
     * 用户消息活跃状态，发生过如下事件，则认为该用户消息活跃：;发送消息、回复消息、reaction、转发消息、阅读消息、查看会话、发送表情消息等
     * <p> 示例值：1
     */
    this.imActiveFlag = builder.imActiveFlag;
    /**
     * 发送消息数
     * <p> 示例值：0
     */
    this.sendMessengerNum = builder.sendMessengerNum;
    /**
     * 用户云文档活跃状态，"发生过如下事件，则认为该用户云文档活跃： ;事件1：文档/文件打开;事件2：进入docs相关页面：如文档详情页，space的各个页面"
     * <p> 示例值：1
     */
    this.docsActiveFlag = builder.docsActiveFlag;
    /**
     * 创建文件数
     * <p> 示例值：1
     */
    this.createDocsNum = builder.createDocsNum;
    /**
     * 用户日历活跃状态，发生过如下事件，则认为用户日历活跃，包含进入日历、创建日程、收到日程邀请等
     * <p> 示例值：1
     */
    this.calActiveFlag = builder.calActiveFlag;
    /**
     * 创建日程数
     * <p> 示例值：0
     */
    this.createCalNum = builder.createCalNum;
    /**
     * 用户音视频会议活跃状态，用户进入会中状态（不包含妙计和直播）即为活跃
     * <p> 示例值：1
     */
    this.vcActiveFlag = builder.vcActiveFlag;
    /**
     * 会议时长
     * <p> 示例值：0
     */
    this.vcDuration = builder.vcDuration;
    /**
     * 活跃设备
     * <p> 示例值：'ios 14.2,-','ios 14.2,feishu 3.40.0-alpha'
     */
    this.activeOs = builder.activeOs;
    /**
     * 创建任务数
     * <p> 示例值：0
     */
    this.createTaskNum = builder.createTaskNum;
    /**
     * 会议数
     * <p> 示例值：0
     */
    this.vcNum = builder.vcNum;
    /**
     * 飞书的应用类型名称
     * <p> 示例值：
     */
    this.appPackageType = builder.appPackageType;
    /**
     * 操作系统名称
     * <p> 示例值：
     */
    this.osName = builder.osName;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDepartmentName() {
    return this.departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentPath() {
    return this.departmentPath;
  }

  public void setDepartmentPath(String departmentPath) {
    this.departmentPath = departmentPath;
  }

  public String getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Integer getUserActiveFlag() {
    return this.userActiveFlag;
  }

  public void setUserActiveFlag(Integer userActiveFlag) {
    this.userActiveFlag = userActiveFlag;
  }

  public String getRegisterTime() {
    return this.registerTime;
  }

  public void setRegisterTime(String registerTime) {
    this.registerTime = registerTime;
  }

  public Integer getSuiteActiveFlag() {
    return this.suiteActiveFlag;
  }

  public void setSuiteActiveFlag(Integer suiteActiveFlag) {
    this.suiteActiveFlag = suiteActiveFlag;
  }

  public String getLastActiveTime() {
    return this.lastActiveTime;
  }

  public void setLastActiveTime(String lastActiveTime) {
    this.lastActiveTime = lastActiveTime;
  }

  public Integer getImActiveFlag() {
    return this.imActiveFlag;
  }

  public void setImActiveFlag(Integer imActiveFlag) {
    this.imActiveFlag = imActiveFlag;
  }

  public Integer getSendMessengerNum() {
    return this.sendMessengerNum;
  }

  public void setSendMessengerNum(Integer sendMessengerNum) {
    this.sendMessengerNum = sendMessengerNum;
  }

  public Integer getDocsActiveFlag() {
    return this.docsActiveFlag;
  }

  public void setDocsActiveFlag(Integer docsActiveFlag) {
    this.docsActiveFlag = docsActiveFlag;
  }

  public Integer getCreateDocsNum() {
    return this.createDocsNum;
  }

  public void setCreateDocsNum(Integer createDocsNum) {
    this.createDocsNum = createDocsNum;
  }

  public Integer getCalActiveFlag() {
    return this.calActiveFlag;
  }

  public void setCalActiveFlag(Integer calActiveFlag) {
    this.calActiveFlag = calActiveFlag;
  }

  public Integer getCreateCalNum() {
    return this.createCalNum;
  }

  public void setCreateCalNum(Integer createCalNum) {
    this.createCalNum = createCalNum;
  }

  public Integer getVcActiveFlag() {
    return this.vcActiveFlag;
  }

  public void setVcActiveFlag(Integer vcActiveFlag) {
    this.vcActiveFlag = vcActiveFlag;
  }

  public Integer getVcDuration() {
    return this.vcDuration;
  }

  public void setVcDuration(Integer vcDuration) {
    this.vcDuration = vcDuration;
  }

  public String getActiveOs() {
    return this.activeOs;
  }

  public void setActiveOs(String activeOs) {
    this.activeOs = activeOs;
  }

  public Integer getCreateTaskNum() {
    return this.createTaskNum;
  }

  public void setCreateTaskNum(Integer createTaskNum) {
    this.createTaskNum = createTaskNum;
  }

  public Integer getVcNum() {
    return this.vcNum;
  }

  public void setVcNum(Integer vcNum) {
    this.vcNum = vcNum;
  }

  public String getAppPackageType() {
    return this.appPackageType;
  }

  public void setAppPackageType(String appPackageType) {
    this.appPackageType = appPackageType;
  }

  public String getOsName() {
    return this.osName;
  }

  public void setOsName(String osName) {
    this.osName = osName;
  }

  public static class Builder {

    /**
     * 日期
     * <p> 示例值：2020-02-15
     */
    private String date;
    /**
     * 用户ID
     * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
     */
    private String userId;
    /**
     * 用户名
     * <p> 示例值：Zhang San
     */
    private String userName;
    /**
     * 部门名
     * <p> 示例值：testcqlbfaaasdasdasd
     */
    private String departmentName;
    /**
     * 部门路径
     * <p> 示例值：testkkk/testcqlbfaaasdasdasd
     */
    private String departmentPath;
    /**
     * 账号创建时间
     * <p> 示例值：2020-09-04 11:17:55
     */
    private String createTime;
    /**
     * 用户激活状态
     * <p> 示例值：1
     */
    private Integer userActiveFlag;
    /**
     * 激活时间
     * <p> 示例值：2020-09-04 11:18:32
     */
    private String registerTime;
    /**
     * 用户活跃状态，用户在飞书套件任意应用登陆，即为活跃。包括飞书即时消息，文档，日历，会议，开放平台等
     * <p> 示例值：1
     */
    private Integer suiteActiveFlag;
    /**
     * 最近活跃时间
     * <p> 示例值：2020-12-21 22:21:28
     */
    private String lastActiveTime;
    /**
     * 用户消息活跃状态，发生过如下事件，则认为该用户消息活跃：;发送消息、回复消息、reaction、转发消息、阅读消息、查看会话、发送表情消息等
     * <p> 示例值：1
     */
    private Integer imActiveFlag;
    /**
     * 发送消息数
     * <p> 示例值：0
     */
    private Integer sendMessengerNum;
    /**
     * 用户云文档活跃状态，"发生过如下事件，则认为该用户云文档活跃： ;事件1：文档/文件打开;事件2：进入docs相关页面：如文档详情页，space的各个页面"
     * <p> 示例值：1
     */
    private Integer docsActiveFlag;
    /**
     * 创建文件数
     * <p> 示例值：1
     */
    private Integer createDocsNum;
    /**
     * 用户日历活跃状态，发生过如下事件，则认为用户日历活跃，包含进入日历、创建日程、收到日程邀请等
     * <p> 示例值：1
     */
    private Integer calActiveFlag;
    /**
     * 创建日程数
     * <p> 示例值：0
     */
    private Integer createCalNum;
    /**
     * 用户音视频会议活跃状态，用户进入会中状态（不包含妙计和直播）即为活跃
     * <p> 示例值：1
     */
    private Integer vcActiveFlag;
    /**
     * 会议时长
     * <p> 示例值：0
     */
    private Integer vcDuration;
    /**
     * 活跃设备
     * <p> 示例值：'ios 14.2,-','ios 14.2,feishu 3.40.0-alpha'
     */
    private String activeOs;
    /**
     * 创建任务数
     * <p> 示例值：0
     */
    private Integer createTaskNum;
    /**
     * 会议数
     * <p> 示例值：0
     */
    private Integer vcNum;
    /**
     * 飞书的应用类型名称
     * <p> 示例值：
     */
    private String appPackageType;
    /**
     * 操作系统名称
     * <p> 示例值：
     */
    private String osName;

    /**
     * 日期
     * <p> 示例值：2020-02-15
     *
     * @param date
     * @return
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }


    /**
     * 用户ID
     * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 用户名
     * <p> 示例值：Zhang San
     *
     * @param userName
     * @return
     */
    public Builder userName(String userName) {
      this.userName = userName;
      return this;
    }


    /**
     * 部门名
     * <p> 示例值：testcqlbfaaasdasdasd
     *
     * @param departmentName
     * @return
     */
    public Builder departmentName(String departmentName) {
      this.departmentName = departmentName;
      return this;
    }


    /**
     * 部门路径
     * <p> 示例值：testkkk/testcqlbfaaasdasdasd
     *
     * @param departmentPath
     * @return
     */
    public Builder departmentPath(String departmentPath) {
      this.departmentPath = departmentPath;
      return this;
    }


    /**
     * 账号创建时间
     * <p> 示例值：2020-09-04 11:17:55
     *
     * @param createTime
     * @return
     */
    public Builder createTime(String createTime) {
      this.createTime = createTime;
      return this;
    }


    /**
     * 用户激活状态
     * <p> 示例值：1
     *
     * @param userActiveFlag
     * @return
     */
    public Builder userActiveFlag(Integer userActiveFlag) {
      this.userActiveFlag = userActiveFlag;
      return this;
    }

    /**
     * 用户激活状态
     * <p> 示例值：1
     *
     * @param userActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatUserActiveFlagEnum}
     * @return
     */
    public Builder userActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatUserActiveFlagEnum userActiveFlag) {
      this.userActiveFlag = userActiveFlag.getValue();
      return this;
    }


    /**
     * 激活时间
     * <p> 示例值：2020-09-04 11:18:32
     *
     * @param registerTime
     * @return
     */
    public Builder registerTime(String registerTime) {
      this.registerTime = registerTime;
      return this;
    }


    /**
     * 用户活跃状态，用户在飞书套件任意应用登陆，即为活跃。包括飞书即时消息，文档，日历，会议，开放平台等
     * <p> 示例值：1
     *
     * @param suiteActiveFlag
     * @return
     */
    public Builder suiteActiveFlag(Integer suiteActiveFlag) {
      this.suiteActiveFlag = suiteActiveFlag;
      return this;
    }

    /**
     * 用户活跃状态，用户在飞书套件任意应用登陆，即为活跃。包括飞书即时消息，文档，日历，会议，开放平台等
     * <p> 示例值：1
     *
     * @param suiteActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatSuiteActiveFlagEnum}
     * @return
     */
    public Builder suiteActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatSuiteActiveFlagEnum suiteActiveFlag) {
      this.suiteActiveFlag = suiteActiveFlag.getValue();
      return this;
    }


    /**
     * 最近活跃时间
     * <p> 示例值：2020-12-21 22:21:28
     *
     * @param lastActiveTime
     * @return
     */
    public Builder lastActiveTime(String lastActiveTime) {
      this.lastActiveTime = lastActiveTime;
      return this;
    }


    /**
     * 用户消息活跃状态，发生过如下事件，则认为该用户消息活跃：;发送消息、回复消息、reaction、转发消息、阅读消息、查看会话、发送表情消息等
     * <p> 示例值：1
     *
     * @param imActiveFlag
     * @return
     */
    public Builder imActiveFlag(Integer imActiveFlag) {
      this.imActiveFlag = imActiveFlag;
      return this;
    }

    /**
     * 用户消息活跃状态，发生过如下事件，则认为该用户消息活跃：;发送消息、回复消息、reaction、转发消息、阅读消息、查看会话、发送表情消息等
     * <p> 示例值：1
     *
     * @param imActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatImActiveFlagEnum}
     * @return
     */
    public Builder imActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatImActiveFlagEnum imActiveFlag) {
      this.imActiveFlag = imActiveFlag.getValue();
      return this;
    }


    /**
     * 发送消息数
     * <p> 示例值：0
     *
     * @param sendMessengerNum
     * @return
     */
    public Builder sendMessengerNum(Integer sendMessengerNum) {
      this.sendMessengerNum = sendMessengerNum;
      return this;
    }


    /**
     * 用户云文档活跃状态，"发生过如下事件，则认为该用户云文档活跃： ;事件1：文档/文件打开;事件2：进入docs相关页面：如文档详情页，space的各个页面"
     * <p> 示例值：1
     *
     * @param docsActiveFlag
     * @return
     */
    public Builder docsActiveFlag(Integer docsActiveFlag) {
      this.docsActiveFlag = docsActiveFlag;
      return this;
    }

    /**
     * 用户云文档活跃状态，"发生过如下事件，则认为该用户云文档活跃： ;事件1：文档/文件打开;事件2：进入docs相关页面：如文档详情页，space的各个页面"
     * <p> 示例值：1
     *
     * @param docsActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatDocsActiveFlagEnum}
     * @return
     */
    public Builder docsActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatDocsActiveFlagEnum docsActiveFlag) {
      this.docsActiveFlag = docsActiveFlag.getValue();
      return this;
    }


    /**
     * 创建文件数
     * <p> 示例值：1
     *
     * @param createDocsNum
     * @return
     */
    public Builder createDocsNum(Integer createDocsNum) {
      this.createDocsNum = createDocsNum;
      return this;
    }


    /**
     * 用户日历活跃状态，发生过如下事件，则认为用户日历活跃，包含进入日历、创建日程、收到日程邀请等
     * <p> 示例值：1
     *
     * @param calActiveFlag
     * @return
     */
    public Builder calActiveFlag(Integer calActiveFlag) {
      this.calActiveFlag = calActiveFlag;
      return this;
    }

    /**
     * 用户日历活跃状态，发生过如下事件，则认为用户日历活跃，包含进入日历、创建日程、收到日程邀请等
     * <p> 示例值：1
     *
     * @param calActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatCalActiveFlagEnum}
     * @return
     */
    public Builder calActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatCalActiveFlagEnum calActiveFlag) {
      this.calActiveFlag = calActiveFlag.getValue();
      return this;
    }


    /**
     * 创建日程数
     * <p> 示例值：0
     *
     * @param createCalNum
     * @return
     */
    public Builder createCalNum(Integer createCalNum) {
      this.createCalNum = createCalNum;
      return this;
    }


    /**
     * 用户音视频会议活跃状态，用户进入会中状态（不包含妙计和直播）即为活跃
     * <p> 示例值：1
     *
     * @param vcActiveFlag
     * @return
     */
    public Builder vcActiveFlag(Integer vcActiveFlag) {
      this.vcActiveFlag = vcActiveFlag;
      return this;
    }

    /**
     * 用户音视频会议活跃状态，用户进入会中状态（不包含妙计和直播）即为活跃
     * <p> 示例值：1
     *
     * @param vcActiveFlag {@link com.lark.oapi.service.admin.v1.enums.AdminUserStatVcActiveFlagEnum}
     * @return
     */
    public Builder vcActiveFlag(
        com.lark.oapi.service.admin.v1.enums.AdminUserStatVcActiveFlagEnum vcActiveFlag) {
      this.vcActiveFlag = vcActiveFlag.getValue();
      return this;
    }


    /**
     * 会议时长
     * <p> 示例值：0
     *
     * @param vcDuration
     * @return
     */
    public Builder vcDuration(Integer vcDuration) {
      this.vcDuration = vcDuration;
      return this;
    }


    /**
     * 活跃设备
     * <p> 示例值：'ios 14.2,-','ios 14.2,feishu 3.40.0-alpha'
     *
     * @param activeOs
     * @return
     */
    public Builder activeOs(String activeOs) {
      this.activeOs = activeOs;
      return this;
    }


    /**
     * 创建任务数
     * <p> 示例值：0
     *
     * @param createTaskNum
     * @return
     */
    public Builder createTaskNum(Integer createTaskNum) {
      this.createTaskNum = createTaskNum;
      return this;
    }


    /**
     * 会议数
     * <p> 示例值：0
     *
     * @param vcNum
     * @return
     */
    public Builder vcNum(Integer vcNum) {
      this.vcNum = vcNum;
      return this;
    }


    /**
     * 飞书的应用类型名称
     * <p> 示例值：
     *
     * @param appPackageType
     * @return
     */
    public Builder appPackageType(String appPackageType) {
      this.appPackageType = appPackageType;
      return this;
    }


    /**
     * 操作系统名称
     * <p> 示例值：
     *
     * @param osName
     * @return
     */
    public Builder osName(String osName) {
      this.osName = osName;
      return this;
    }


    public AdminUserStat build() {
      return new AdminUserStat(this);
    }
  }
}