// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateChat {

  @SerializedName("chat_id")
  private String chatId;
  @SerializedName("avatar")
  private String avatar;
  @SerializedName("name")
  private String name;
  @SerializedName("description")
  private String description;
  @SerializedName("i18n_names")
  private I18nNames i18nNames;
  @SerializedName("owner_id")
  private String ownerId;
  @SerializedName("owner_id_type")
  private String ownerIdType;
  @SerializedName("add_member_permission")
  private String addMemberPermission;
  @SerializedName("share_card_permission")
  private String shareCardPermission;
  @SerializedName("at_all_permission")
  private String atAllPermission;
  @SerializedName("edit_permission")
  private String editPermission;
  @SerializedName("chat_mode")
  private String chatMode;
  @SerializedName("chat_type")
  private String chatType;
  @SerializedName("chat_tag")
  private String chatTag;
  @SerializedName("external")
  private Boolean external;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("join_message_visibility")
  private String joinMessageVisibility;
  @SerializedName("leave_message_visibility")
  private String leaveMessageVisibility;
  @SerializedName("membership_approval")
  private String membershipApproval;
  @SerializedName("moderation_permission")
  private String moderationPermission;

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


}
