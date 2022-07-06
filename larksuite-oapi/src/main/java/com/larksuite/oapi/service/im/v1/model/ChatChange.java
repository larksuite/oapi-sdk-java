// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class ChatChange {
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("i18n_names")
    private I18nNames i18nNames;
    @SerializedName("add_member_permission")
    private String addMemberPermission;
    @SerializedName("share_card_permission")
    private String shareCardPermission;
    @SerializedName("at_all_permission")
    private String atAllPermission;
    @SerializedName("edit_permission")
    private String editPermission;
    @SerializedName("membership_approval")
    private String membershipApproval;
    @SerializedName("join_message_visibility")
    private String joinMessageVisibility;
    @SerializedName("leave_message_visibility")
    private String leaveMessageVisibility;
    @SerializedName("moderation_permission")
    private String moderationPermission;
    @SerializedName("owner_id")
    private UserId ownerId;

    // builder 开始
    public ChatChange() {
    }

    public ChatChange(Builder builder) {
        this.avatar = builder.avatar;
        this.name = builder.name;
        this.description = builder.description;
        this.i18nNames = builder.i18nNames;
        this.addMemberPermission = builder.addMemberPermission;
        this.shareCardPermission = builder.shareCardPermission;
        this.atAllPermission = builder.atAllPermission;
        this.editPermission = builder.editPermission;
        this.membershipApproval = builder.membershipApproval;
        this.joinMessageVisibility = builder.joinMessageVisibility;
        this.leaveMessageVisibility = builder.leaveMessageVisibility;
        this.moderationPermission = builder.moderationPermission;
        this.ownerId = builder.ownerId;
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

    public String getMembershipApproval() {
        return this.membershipApproval;
    }

    public void setMembershipApproval(String membershipApproval) {
        this.membershipApproval = membershipApproval;
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

    public String getModerationPermission() {
        return this.moderationPermission;
    }

    public void setModerationPermission(String moderationPermission) {
        this.moderationPermission = moderationPermission;
    }

    public UserId getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(UserId ownerId) {
        this.ownerId = ownerId;
    }

    public static class Builder {
        private String avatar;
        private String name;
        private String description;
        private I18nNames i18nNames;
        private String addMemberPermission;
        private String shareCardPermission;
        private String atAllPermission;
        private String editPermission;
        private String membershipApproval;
        private String joinMessageVisibility;
        private String leaveMessageVisibility;
        private String moderationPermission;
        private UserId ownerId;

        public Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder i18nNames(I18nNames i18nNames) {
            this.i18nNames = i18nNames;
            return this;
        }

        public Builder addMemberPermission(String addMemberPermission) {
            this.addMemberPermission = addMemberPermission;
            return this;
        }

        public Builder shareCardPermission(String shareCardPermission) {
            this.shareCardPermission = shareCardPermission;
            return this;
        }

        public Builder atAllPermission(String atAllPermission) {
            this.atAllPermission = atAllPermission;
            return this;
        }

        public Builder editPermission(String editPermission) {
            this.editPermission = editPermission;
            return this;
        }

        public Builder membershipApproval(String membershipApproval) {
            this.membershipApproval = membershipApproval;
            return this;
        }

        public Builder joinMessageVisibility(String joinMessageVisibility) {
            this.joinMessageVisibility = joinMessageVisibility;
            return this;
        }

        public Builder leaveMessageVisibility(String leaveMessageVisibility) {
            this.leaveMessageVisibility = leaveMessageVisibility;
            return this;
        }

        public Builder moderationPermission(String moderationPermission) {
            this.moderationPermission = moderationPermission;
            return this;
        }

        public Builder ownerId(UserId ownerId) {
            this.ownerId = ownerId;
            return this;
        }


        public ChatChange build() {
            return new ChatChange(this);
        }
    }
}
