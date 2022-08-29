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

package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateChatReqBody {

  /**
   * 群头像对应的 Image Key，可通过[上传图片](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create)获取（注意：上传图片的
   * ==image_type== 需要指定为 ==avatar==）
   * <p> 示例值：default-avatar_44ae0ca3-e140-494b-956f-78091e348435
   */
  @SerializedName("avatar")
  private String avatar;
  /**
   * 群名称;; **注意：** 公开群名称的长度不得少于2个字符
   * <p> 示例值：测试群名称
   */
  @SerializedName("name")
  private String name;
  /**
   * 群描述
   * <p> 示例值：测试群描述
   */
  @SerializedName("description")
  private String description;
  /**
   * 群国际化名称
   * <p> 示例值：
   */
  @SerializedName("i18n_names")
  private I18nNames i18nNames;
  /**
   * 创建群时指定的群主，不填时指定建群的机器人为群主。;;群主 ID，ID值与查询参数中的 user_id_type 对应。;;不同 ID 的说明参见 [用户相关的 ID
   * 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
   * <p> 示例值：4d7a3c6g
   */
  @SerializedName("owner_id")
  private String ownerId;
  /**
   * 创建群时邀请的群成员，id 类型为 user_id_type
   * <p> 示例值：["4d7a3c6g"]
   */
  @SerializedName("user_id_list")
  private String[] userIdList;
  /**
   * 创建群时邀请的群机器人; ;**注意：** 拉机器人入群请使用 ==app_id==
   * <p> 示例值：["cli_a10fbf7e94b8d01d"]
   */
  @SerializedName("bot_id_list")
  private String[] botIdList;
  /**
   * 群模式;;**可选值有**：;- `group`：群组
   * <p> 示例值：group
   */
  @SerializedName("chat_mode")
  private String chatMode;
  /**
   * 群类型;;**可选值有**：;- `private`：私有群;- `public`：公开群
   * <p> 示例值：private
   */
  @SerializedName("chat_type")
  private String chatType;
  /**
   * 是否是外部群
   * <p> 示例值：false
   */
  @SerializedName("external")
  private Boolean external;
  /**
   * 入群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
   * <p> 示例值：all_members
   */
  @SerializedName("join_message_visibility")
  private String joinMessageVisibility;
  /**
   * 退群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
   * <p> 示例值：all_members
   */
  @SerializedName("leave_message_visibility")
  private String leaveMessageVisibility;
  /**
   * 加群审批;;**可选值有**：;- `no_approval_required`：无需审批;- `approval_required`：需要审批
   * <p> 示例值：no_approval_required
   */
  @SerializedName("membership_approval")
  private String membershipApproval;

  // builder 开始
  public CreateChatReqBody() {
  }

  public CreateChatReqBody(Builder builder) {
    /**
     * 群头像对应的 Image Key，可通过[上传图片](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create)获取（注意：上传图片的 ==image_type== 需要指定为 ==avatar==）
     * <p> 示例值：default-avatar_44ae0ca3-e140-494b-956f-78091e348435
     */
    this.avatar = builder.avatar;
    /**
     * 群名称;; **注意：** 公开群名称的长度不得少于2个字符
     * <p> 示例值：测试群名称
     */
    this.name = builder.name;
    /**
     * 群描述
     * <p> 示例值：测试群描述
     */
    this.description = builder.description;
    /**
     * 群国际化名称
     * <p> 示例值：
     */
    this.i18nNames = builder.i18nNames;
    /**
     * 创建群时指定的群主，不填时指定建群的机器人为群主。;;群主 ID，ID值与查询参数中的 user_id_type 对应。;;不同 ID 的说明参见 [用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：4d7a3c6g
     */
    this.ownerId = builder.ownerId;
    /**
     * 创建群时邀请的群成员，id 类型为 user_id_type
     * <p> 示例值：["4d7a3c6g"]
     */
    this.userIdList = builder.userIdList;
    /**
     * 创建群时邀请的群机器人; ;**注意：** 拉机器人入群请使用 ==app_id==
     * <p> 示例值：["cli_a10fbf7e94b8d01d"]
     */
    this.botIdList = builder.botIdList;
    /**
     * 群模式;;**可选值有**：;- `group`：群组
     * <p> 示例值：group
     */
    this.chatMode = builder.chatMode;
    /**
     * 群类型;;**可选值有**：;- `private`：私有群;- `public`：公开群
     * <p> 示例值：private
     */
    this.chatType = builder.chatType;
    /**
     * 是否是外部群
     * <p> 示例值：false
     */
    this.external = builder.external;
    /**
     * 入群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     */
    this.joinMessageVisibility = builder.joinMessageVisibility;
    /**
     * 退群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     */
    this.leaveMessageVisibility = builder.leaveMessageVisibility;
    /**
     * 加群审批;;**可选值有**：;- `no_approval_required`：无需审批;- `approval_required`：需要审批
     * <p> 示例值：no_approval_required
     */
    this.membershipApproval = builder.membershipApproval;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public I18nNames getI18nNames() {
    return this.i18nNames;
  }

  public void setI18nNames(I18nNames i18nNames) {
    this.i18nNames = i18nNames;
  }

  public String getOwnerId() {
    return this.ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String[] getUserIdList() {
    return this.userIdList;
  }

  public void setUserIdList(String[] userIdList) {
    this.userIdList = userIdList;
  }

  public String[] getBotIdList() {
    return this.botIdList;
  }

  public void setBotIdList(String[] botIdList) {
    this.botIdList = botIdList;
  }

  public String getChatMode() {
    return this.chatMode;
  }

  public void setChatMode(String chatMode) {
    this.chatMode = chatMode;
  }

  public String getChatType() {
    return this.chatType;
  }

  public void setChatType(String chatType) {
    this.chatType = chatType;
  }

  public Boolean getExternal() {
    return this.external;
  }

  public void setExternal(Boolean external) {
    this.external = external;
  }

  public String getJoinMessageVisibility() {
    return this.joinMessageVisibility;
  }

  public void setJoinMessageVisibility(String joinMessageVisibility) {
    this.joinMessageVisibility = joinMessageVisibility;
  }

  public String getLeaveMessageVisibility() {
    return this.leaveMessageVisibility;
  }

  public void setLeaveMessageVisibility(String leaveMessageVisibility) {
    this.leaveMessageVisibility = leaveMessageVisibility;
  }

  public String getMembershipApproval() {
    return this.membershipApproval;
  }

  public void setMembershipApproval(String membershipApproval) {
    this.membershipApproval = membershipApproval;
  }

  public static class Builder {

    /**
     * 群头像对应的 Image Key，可通过[上传图片](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create)获取（注意：上传图片的
     * ==image_type== 需要指定为 ==avatar==）
     * <p> 示例值：default-avatar_44ae0ca3-e140-494b-956f-78091e348435
     */
    private String avatar;
    /**
     * 群名称;; **注意：** 公开群名称的长度不得少于2个字符
     * <p> 示例值：测试群名称
     */
    private String name;
    /**
     * 群描述
     * <p> 示例值：测试群描述
     */
    private String description;
    /**
     * 群国际化名称
     * <p> 示例值：
     */
    private I18nNames i18nNames;
    /**
     * 创建群时指定的群主，不填时指定建群的机器人为群主。;;群主 ID，ID值与查询参数中的 user_id_type 对应。;;不同 ID 的说明参见 [用户相关的 ID
     * 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：4d7a3c6g
     */
    private String ownerId;
    /**
     * 创建群时邀请的群成员，id 类型为 user_id_type
     * <p> 示例值：["4d7a3c6g"]
     */
    private String[] userIdList;
    /**
     * 创建群时邀请的群机器人; ;**注意：** 拉机器人入群请使用 ==app_id==
     * <p> 示例值：["cli_a10fbf7e94b8d01d"]
     */
    private String[] botIdList;
    /**
     * 群模式;;**可选值有**：;- `group`：群组
     * <p> 示例值：group
     */
    private String chatMode;
    /**
     * 群类型;;**可选值有**：;- `private`：私有群;- `public`：公开群
     * <p> 示例值：private
     */
    private String chatType;
    /**
     * 是否是外部群
     * <p> 示例值：false
     */
    private Boolean external;
    /**
     * 入群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     */
    private String joinMessageVisibility;
    /**
     * 退群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     */
    private String leaveMessageVisibility;
    /**
     * 加群审批;;**可选值有**：;- `no_approval_required`：无需审批;- `approval_required`：需要审批
     * <p> 示例值：no_approval_required
     */
    private String membershipApproval;

    /**
     * 群头像对应的 Image Key，可通过[上传图片](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create)获取（注意：上传图片的
     * ==image_type== 需要指定为 ==avatar==）
     * <p> 示例值：default-avatar_44ae0ca3-e140-494b-956f-78091e348435
     *
     * @param avatar
     * @return
     */
    public Builder avatar(String avatar) {
      this.avatar = avatar;
      return this;
    }


    /**
     * 群名称;; **注意：** 公开群名称的长度不得少于2个字符
     * <p> 示例值：测试群名称
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 群描述
     * <p> 示例值：测试群描述
     *
     * @param description
     * @return
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }


    /**
     * 群国际化名称
     * <p> 示例值：
     *
     * @param i18nNames
     * @return
     */
    public Builder i18nNames(I18nNames i18nNames) {
      this.i18nNames = i18nNames;
      return this;
    }


    /**
     * 创建群时指定的群主，不填时指定建群的机器人为群主。;;群主 ID，ID值与查询参数中的 user_id_type 对应。;;不同 ID 的说明参见 [用户相关的 ID
     * 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：4d7a3c6g
     *
     * @param ownerId
     * @return
     */
    public Builder ownerId(String ownerId) {
      this.ownerId = ownerId;
      return this;
    }


    /**
     * 创建群时邀请的群成员，id 类型为 user_id_type
     * <p> 示例值：["4d7a3c6g"]
     *
     * @param userIdList
     * @return
     */
    public Builder userIdList(String[] userIdList) {
      this.userIdList = userIdList;
      return this;
    }


    /**
     * 创建群时邀请的群机器人; ;**注意：** 拉机器人入群请使用 ==app_id==
     * <p> 示例值：["cli_a10fbf7e94b8d01d"]
     *
     * @param botIdList
     * @return
     */
    public Builder botIdList(String[] botIdList) {
      this.botIdList = botIdList;
      return this;
    }


    /**
     * 群模式;;**可选值有**：;- `group`：群组
     * <p> 示例值：group
     *
     * @param chatMode
     * @return
     */
    public Builder chatMode(String chatMode) {
      this.chatMode = chatMode;
      return this;
    }


    /**
     * 群类型;;**可选值有**：;- `private`：私有群;- `public`：公开群
     * <p> 示例值：private
     *
     * @param chatType
     * @return
     */
    public Builder chatType(String chatType) {
      this.chatType = chatType;
      return this;
    }


    /**
     * 是否是外部群
     * <p> 示例值：false
     *
     * @param external
     * @return
     */
    public Builder external(Boolean external) {
      this.external = external;
      return this;
    }


    /**
     * 入群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     *
     * @param joinMessageVisibility
     * @return
     */
    public Builder joinMessageVisibility(String joinMessageVisibility) {
      this.joinMessageVisibility = joinMessageVisibility;
      return this;
    }


    /**
     * 退群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     *
     * @param leaveMessageVisibility
     * @return
     */
    public Builder leaveMessageVisibility(String leaveMessageVisibility) {
      this.leaveMessageVisibility = leaveMessageVisibility;
      return this;
    }


    /**
     * 加群审批;;**可选值有**：;- `no_approval_required`：无需审批;- `approval_required`：需要审批
     * <p> 示例值：no_approval_required
     *
     * @param membershipApproval
     * @return
     */
    public Builder membershipApproval(String membershipApproval) {
      this.membershipApproval = membershipApproval;
      return this;
    }


    public CreateChatReqBody build() {
      return new CreateChatReqBody(this);
    }
  }
}