// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class CustomAttrEventUpdatedEventData {
    @SerializedName("object")
    private CustomAttrEvent object;
    @SerializedName("old_object")
    private CustomAttrEvent oldObject;

    public CustomAttrEvent getObject() {
        return this.object;
    }

    public void setObject(CustomAttrEvent object) {
        this.object = object;
    }

    public CustomAttrEvent getOldObject() {
        return this.oldObject;
    }

    public void setOldObject(CustomAttrEvent oldObject) {
        this.oldObject = oldObject;
    }

}
