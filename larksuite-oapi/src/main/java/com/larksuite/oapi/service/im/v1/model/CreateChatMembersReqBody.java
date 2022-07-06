// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateChatMembersReqBody {
    @SerializedName("id_list")
    private String[] idList;

    // builder 开始
    public CreateChatMembersReqBody() {
    }

    public CreateChatMembersReqBody(Builder builder) {
        this.idList = builder.idList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getIdList() {
        return this.idList;
    }

    public void setIdList(String[] idList) {
        this.idList = idList;
    }

    public static class Builder {
        private String[] idList;

        public Builder idList(String[] idList) {
            this.idList = idList;
            return this;
        }


        public CreateChatMembersReqBody build() {
            return new CreateChatMembersReqBody(this);
        }
    }
}
