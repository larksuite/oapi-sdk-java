// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class Chat {
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
    @SerializedName("only_owner_add")
    private Boolean onlyOwnerAdd;
    @SerializedName("share_allowed")
    private Boolean shareAllowed;
    @SerializedName("only_owner_at_all")
    private Boolean onlyOwnerAtAll;
    @SerializedName("only_owner_edit")
    private Boolean onlyOwnerEdit;
    @SerializedName("owner_user_id")
    private String ownerUserId;
    @SerializedName("type")
    private String type;

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

    public Boolean getOnlyOwnerAdd() {
        return this.onlyOwnerAdd;
    }

    public void setOnlyOwnerAdd(Boolean onlyOwnerAdd) {
        this.onlyOwnerAdd = onlyOwnerAdd;
    }

    public Boolean getShareAllowed() {
        return this.shareAllowed;
    }

    public void setShareAllowed(Boolean shareAllowed) {
        this.shareAllowed = shareAllowed;
    }

    public Boolean getOnlyOwnerAtAll() {
        return this.onlyOwnerAtAll;
    }

    public void setOnlyOwnerAtAll(Boolean onlyOwnerAtAll) {
        this.onlyOwnerAtAll = onlyOwnerAtAll;
    }

    public Boolean getOnlyOwnerEdit() {
        return this.onlyOwnerEdit;
    }

    public void setOnlyOwnerEdit(Boolean onlyOwnerEdit) {
        this.onlyOwnerEdit = onlyOwnerEdit;
    }

    public String getOwnerUserId() {
        return this.ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


}