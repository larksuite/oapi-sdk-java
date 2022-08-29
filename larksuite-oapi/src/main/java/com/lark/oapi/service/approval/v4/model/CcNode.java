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

public class CcNode {

  /**
   * 审批实例内唯一标识
   * <p> 示例值：123456
   */
  @SerializedName("cc_id")
  private String ccId;
  /**
   * 抄送人 employee id
   * <p> 示例值：12345
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 抄送人 open id，和user id 二选一
   * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
   */
  @SerializedName("open_id")
  private String openId;
  /**
   * 跳转链接，用于【抄送我的】列表中的跳转pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
   * <p> 示例值：
   */
  @SerializedName("links")
  private ExternalInstanceLink links;
  /**
   * 阅读状态，空值表示不支持已读未读：
   * <p> 示例值：READ
   */
  @SerializedName("read_status")
  private String readStatus;
  /**
   * 扩展 json
   * <p> 示例值：{\"xxx\":\"xxx\"}
   */
  @SerializedName("extra")
  private String extra;
  /**
   * 抄送任务名称
   * <p> 示例值：xxx
   */
  @SerializedName("title")
  private String title;
  /**
   * 抄送发起时间，Unix 毫秒时间戳
   * <p> 示例值：1556468012678
   */
  @SerializedName("create_time")
  private String createTime;
  /**
   * 抄送最近更新时间，用于推送数据版本控制更新策略同 instance 的update_time
   * <p> 示例值：1556468012678
   */
  @SerializedName("update_time")
  private String updateTime;
  /**
   * 列表页打开审批任务的方式
   * <p> 示例值：BROWSER
   */
  @SerializedName("display_method")
  private String displayMethod;

  // builder 开始
  public CcNode() {
  }

  public CcNode(Builder builder) {
    /**
     * 审批实例内唯一标识
     * <p> 示例值：123456
     */
    this.ccId = builder.ccId;
    /**
     * 抄送人 employee id
     * <p> 示例值：12345
     */
    this.userId = builder.userId;
    /**
     * 抄送人 open id，和user id 二选一
     * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
     */
    this.openId = builder.openId;
    /**
     * 跳转链接，用于【抄送我的】列表中的跳转pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
     * <p> 示例值：
     */
    this.links = builder.links;
    /**
     * 阅读状态，空值表示不支持已读未读：
     * <p> 示例值：READ
     */
    this.readStatus = builder.readStatus;
    /**
     * 扩展 json
     * <p> 示例值：{\"xxx\":\"xxx\"}
     */
    this.extra = builder.extra;
    /**
     * 抄送任务名称
     * <p> 示例值：xxx
     */
    this.title = builder.title;
    /**
     * 抄送发起时间，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    this.createTime = builder.createTime;
    /**
     * 抄送最近更新时间，用于推送数据版本控制更新策略同 instance 的update_time
     * <p> 示例值：1556468012678
     */
    this.updateTime = builder.updateTime;
    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     */
    this.displayMethod = builder.displayMethod;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getCcId() {
    return this.ccId;
  }

  public void setCcId(String ccId) {
    this.ccId = ccId;
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

  public ExternalInstanceLink getLinks() {
    return this.links;
  }

  public void setLinks(ExternalInstanceLink links) {
    this.links = links;
  }

  public String getReadStatus() {
    return this.readStatus;
  }

  public void setReadStatus(String readStatus) {
    this.readStatus = readStatus;
  }

  public String getExtra() {
    return this.extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getDisplayMethod() {
    return this.displayMethod;
  }

  public void setDisplayMethod(String displayMethod) {
    this.displayMethod = displayMethod;
  }

  public static class Builder {

    /**
     * 审批实例内唯一标识
     * <p> 示例值：123456
     */
    private String ccId;
    /**
     * 抄送人 employee id
     * <p> 示例值：12345
     */
    private String userId;
    /**
     * 抄送人 open id，和user id 二选一
     * <p> 示例值：ou_be73cbc0ee35eb6ca54e9e7cc14998c1
     */
    private String openId;
    /**
     * 跳转链接，用于【抄送我的】列表中的跳转pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
     * <p> 示例值：
     */
    private ExternalInstanceLink links;
    /**
     * 阅读状态，空值表示不支持已读未读：
     * <p> 示例值：READ
     */
    private String readStatus;
    /**
     * 扩展 json
     * <p> 示例值：{\"xxx\":\"xxx\"}
     */
    private String extra;
    /**
     * 抄送任务名称
     * <p> 示例值：xxx
     */
    private String title;
    /**
     * 抄送发起时间，Unix 毫秒时间戳
     * <p> 示例值：1556468012678
     */
    private String createTime;
    /**
     * 抄送最近更新时间，用于推送数据版本控制更新策略同 instance 的update_time
     * <p> 示例值：1556468012678
     */
    private String updateTime;
    /**
     * 列表页打开审批任务的方式
     * <p> 示例值：BROWSER
     */
    private String displayMethod;

    /**
     * 审批实例内唯一标识
     * <p> 示例值：123456
     *
     * @param ccId
     * @return
     */
    public Builder ccId(String ccId) {
      this.ccId = ccId;
      return this;
    }


    /**
     * 抄送人 employee id
     * <p> 示例值：12345
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 抄送人 open id，和user id 二选一
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
     * 跳转链接，用于【抄送我的】列表中的跳转pc_link 和 mobile_link 必须填一个，填写的是哪一端的链接，即会跳转到该链接，不受平台影响
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
     * 阅读状态，空值表示不支持已读未读：
     * <p> 示例值：READ
     *
     * @param readStatus
     * @return
     */
    public Builder readStatus(String readStatus) {
      this.readStatus = readStatus;
      return this;
    }

    /**
     * 阅读状态，空值表示不支持已读未读：
     * <p> 示例值：READ
     *
     * @param readStatus {@link com.lark.oapi.service.approval.v4.enums.CcNodeReadStatusEnum}
     * @return
     */
    public Builder readStatus(
        com.lark.oapi.service.approval.v4.enums.CcNodeReadStatusEnum readStatus) {
      this.readStatus = readStatus.getValue();
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
     * 抄送任务名称
     * <p> 示例值：xxx
     *
     * @param title
     * @return
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }


    /**
     * 抄送发起时间，Unix 毫秒时间戳
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
     * 抄送最近更新时间，用于推送数据版本控制更新策略同 instance 的update_time
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
     * @param displayMethod {@link com.lark.oapi.service.approval.v4.enums.CcNodeDisplayMethodEnum}
     * @return
     */
    public Builder displayMethod(
        com.lark.oapi.service.approval.v4.enums.CcNodeDisplayMethodEnum displayMethod) {
      this.displayMethod = displayMethod.getValue();
      return this;
    }


    public CcNode build() {
      return new CcNode(this);
    }
  }
}