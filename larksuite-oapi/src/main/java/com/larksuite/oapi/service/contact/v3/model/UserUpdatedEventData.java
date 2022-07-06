// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class UserUpdatedEventData {
    @SerializedName("object")
    private UserEvent object;
    @SerializedName("old_object")
    private UserEvent oldObject;

    public UserEvent getObject() {
        return this.object;
    }

    public void setObject(UserEvent object) {
        this.object = object;
    }

    public UserEvent getOldObject() {
        return this.oldObject;
    }

    public void setOldObject(UserEvent oldObject) {
        this.oldObject = oldObject;
    }

}
