// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class ApplicationVisibilityAddedEventData {
    @SerializedName("users")
    private User[] users;
    @SerializedName("source")
    private Integer source;

    public User[] getUsers() {
        return this.users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

}
