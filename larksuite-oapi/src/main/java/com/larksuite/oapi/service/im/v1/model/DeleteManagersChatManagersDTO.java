// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class DeleteManagersChatManagersDTO {
    @SerializedName("chat_managers")
    private String[] chatManagers;
    @SerializedName("chat_bot_managers")
    private String[] chatBotManagers;

    public String[] getChatManagers() {
        return this.chatManagers;
    }

    public void setChatManagers(String[] chatManagers) {
        this.chatManagers = chatManagers;
    }

    public String[] getChatBotManagers() {
        return this.chatBotManagers;
    }

    public void setChatBotManagers(String[] chatBotManagers) {
        this.chatBotManagers = chatBotManagers;
    }

}
