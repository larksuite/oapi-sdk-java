// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateChatTabReqBody {
    @SerializedName("chat_tabs")
    private ChatTab[] chatTabs;

    // builder 开始
    public CreateChatTabReqBody() {
    }

    public CreateChatTabReqBody(Builder builder) {
        this.chatTabs = builder.chatTabs;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ChatTab[] getChatTabs() {
        return this.chatTabs;
    }

    public void setChatTabs(ChatTab[] chatTabs) {
        this.chatTabs = chatTabs;
    }

    public static class Builder {
        private ChatTab[] chatTabs;

        public Builder chatTabs(ChatTab[] chatTabs) {
            this.chatTabs = chatTabs;
            return this;
        }


        public CreateChatTabReqBody build() {
            return new CreateChatTabReqBody(this);
        }
    }
}