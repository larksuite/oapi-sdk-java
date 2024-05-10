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

import com.lark.oapi.core.response.EmptyData;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class CreateChatRespBody {
    /**
     * 群 ID，详情参见：[群ID 说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description)
     * <p> 示例值：oc_a0553eda9014c201e6969b478895c230
     */
    @SerializedName("chat_id")
    private String chatId;
    /**
     * 群头像 URL
     * <p> 示例值：https://p3-lark-file.byteimg.com/img/lark-avatar-staging/default-avatar_44ae0ca3-e140-494b-956f-78091e348435~100x100.jpg
     */
    @SerializedName("avatar")
    private String avatar;
    /**
     * 群名称
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
     * 群主 ID，ID值与查询参数中的 ==user_id_type== 对应；不同 ID 的说明参见 [用户相关的 ID 概念](https://open.feishu.cn/document/home/user-identity-introduction/introduction);;**注意**：当群主是机器人时，该字段不返回
     * <p> 示例值：4d7a3c6g
     */
    @SerializedName("owner_id")
    private String ownerId;
    /**
     * 群主 ID 对应的ID类型，与查询参数中的 ==user_id_type== 相同。取值为：`open_id`、`user_id`、`union_id`其中之一;;**注意**：当群主是机器人时，该字段不返回
     * <p> 示例值：user_id
     */
    @SerializedName("owner_id_type")
    private String ownerIdType;
    /**
     * 谁可以加急
     * <p> 示例值：all_members
     */
    @SerializedName("urgent_setting")
    private String urgentSetting;
    /**
     * 谁可以发起视频会议
     * <p> 示例值：all_members
     */
    @SerializedName("video_conference_setting")
    private String videoConferenceSetting;
    /**
     * 谁可以管理置顶
     * <p> 示例值：all_members
     */
    @SerializedName("pin_manage_setting")
    private String pinManageSetting;
    /**
     * 拉 用户或机器人 入群权限;;**可选值有**：;- `only_owner`：仅群主和管理员;- `all_members`：所有成员
     * <p> 示例值：all members
     */
    @SerializedName("add_member_permission")
    private String addMemberPermission;
    /**
     * 群分享权限;;**可选值有**：;- `allowed`：允许;- `not_allowed`：不允许
     * <p> 示例值：allowed
     */
    @SerializedName("share_card_permission")
    private String shareCardPermission;
    /**
     * at 所有人权限;;**可选值有**：;- `only_owner`：仅群主和管理员;- `all_members`：所有成员
     * <p> 示例值：all members
     */
    @SerializedName("at_all_permission")
    private String atAllPermission;
    /**
     * 群编辑权限;;**可选值有**：;- `only_owner`：仅群主和管理员;- `all_members`：所有成员
     * <p> 示例值：all members
     */
    @SerializedName("edit_permission")
    private String editPermission;
    /**
     * 群消息模式
     * <p> 示例值：chat
     */
    @SerializedName("group_message_type")
    private String groupMessageType;
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
     * 群标签，如有多个，则按照下列顺序返回第一个;;**可选值有**：;- `inner`：内部群;- `tenant`：公司群;- `department`：部门群;- `edu`：教育群;- `meeting`：会议群;- `customer_service`：客服群
     * <p> 示例值：inner
     */
    @SerializedName("chat_tag")
    private String chatTag;
    /**
     * 是否是外部群
     * <p> 示例值：false
     */
    @SerializedName("external")
    private Boolean external;
    /**
     * 租户在飞书上的唯一标识，用来换取对应的tenant_access_token，也可以用作租户在应用里面的唯一标识
     * <p> 示例值：736588c9260f175e
     */
    @SerializedName("tenant_key")
    private String tenantKey;
    /**
     * 入群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
     * <p> 示例值：all_members
     */
    @SerializedName("join_message_visibility")
    private String joinMessageVisibility;
    /**
     * 出群消息可见性;;**可选值有**：;- `only_owner`：仅群主和管理员可见;- `all_members`：所有成员可见;- `not_anyone`：任何人均不可见
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
    /**
     * 发言权限;;**可选值有**：;- `only_owner`：仅群主和管理员;- `all_members`：所有成员;- `moderator_list`：指定群成员
     * <p> 示例值：all_members
     */
    @SerializedName("moderation_permission")
    private String moderationPermission;
    /**
     * 防泄密模式设置
     * <p> 示例值：
     */
    @SerializedName("restricted_mode_setting")
    private RestrictedModeSetting restrictedModeSetting;
    /**
     * 隐藏群成员人数设置
     * <p> 示例值：all_members
     */
    @SerializedName("hide_member_count_setting")
    private String hideMemberCountSetting;

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
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

    public String getOwnerIdType() {
        return this.ownerIdType;
    }

    public void setOwnerIdType(String ownerIdType) {
        this.ownerIdType = ownerIdType;
    }

    public String getUrgentSetting() {
        return this.urgentSetting;
    }

    public void setUrgentSetting(String urgentSetting) {
        this.urgentSetting = urgentSetting;
    }

    public String getVideoConferenceSetting() {
        return this.videoConferenceSetting;
    }

    public void setVideoConferenceSetting(String videoConferenceSetting) {
        this.videoConferenceSetting = videoConferenceSetting;
    }

    public String getPinManageSetting() {
        return this.pinManageSetting;
    }

    public void setPinManageSetting(String pinManageSetting) {
        this.pinManageSetting = pinManageSetting;
    }

    public String getAddMemberPermission() {
        return this.addMemberPermission;
    }

    public void setAddMemberPermission(String addMemberPermission) {
        this.addMemberPermission = addMemberPermission;
    }

    public String getShareCardPermission() {
        return this.shareCardPermission;
    }

    public void setShareCardPermission(String shareCardPermission) {
        this.shareCardPermission = shareCardPermission;
    }

    public String getAtAllPermission() {
        return this.atAllPermission;
    }

    public void setAtAllPermission(String atAllPermission) {
        this.atAllPermission = atAllPermission;
    }

    public String getEditPermission() {
        return this.editPermission;
    }

    public void setEditPermission(String editPermission) {
        this.editPermission = editPermission;
    }

    public String getGroupMessageType() {
        return this.groupMessageType;
    }

    public void setGroupMessageType(String groupMessageType) {
        this.groupMessageType = groupMessageType;
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

    public String getChatTag() {
        return this.chatTag;
    }

    public void setChatTag(String chatTag) {
        this.chatTag = chatTag;
    }

    public Boolean getExternal() {
        return this.external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public String getTenantKey() {
        return this.tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
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

    public String getModerationPermission() {
        return this.moderationPermission;
    }

    public void setModerationPermission(String moderationPermission) {
        this.moderationPermission = moderationPermission;
    }


    public RestrictedModeSetting getRestrictedModeSetting() {
        return this.restrictedModeSetting;
    }

    public void setRestrictedModeSetting(RestrictedModeSetting restrictedModeSetting) {
        this.restrictedModeSetting = restrictedModeSetting;
    }

    public String getHideMemberCountSetting() {
        return this.hideMemberCountSetting;
    }

    public void setHideMemberCountSetting(String hideMemberCountSetting) {
        this.hideMemberCountSetting = hideMemberCountSetting;
    }

}
