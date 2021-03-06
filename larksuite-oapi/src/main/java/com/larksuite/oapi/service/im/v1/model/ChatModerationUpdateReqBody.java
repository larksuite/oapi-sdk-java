// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class ChatModerationUpdateReqBody {
    @SerializedName("moderation_setting")
    private String moderationSetting;
    @SerializedName("moderator_added_list")
    private String[] moderatorAddedList;
    @SerializedName("moderator_removed_list")
    private String[] moderatorRemovedList;

    public String getModerationSetting() {
        return this.moderationSetting;
    }

    public void setModerationSetting(String moderationSetting) {
        this.moderationSetting = moderationSetting;
    }

    public String[] getModeratorAddedList() {
        return this.moderatorAddedList;
    }

    public void setModeratorAddedList(String[] moderatorAddedList) {
        this.moderatorAddedList = moderatorAddedList;
    }

    public String[] getModeratorRemovedList() {
        return this.moderatorRemovedList;
    }

    public void setModeratorRemovedList(String[] moderatorRemovedList) {
        this.moderatorRemovedList = moderatorRemovedList;
    }

}
