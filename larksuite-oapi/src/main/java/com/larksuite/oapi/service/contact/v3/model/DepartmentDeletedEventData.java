// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class DepartmentDeletedEventData {
    @SerializedName("object")
    private DepartmentEvent object;
    @SerializedName("old_object")
    private OldDepartmentObject oldObject;

    public DepartmentEvent getObject() {
        return this.object;
    }

    public void setObject(DepartmentEvent object) {
        this.object = object;
    }

    public OldDepartmentObject getOldObject() {
        return this.oldObject;
    }

    public void setOldObject(OldDepartmentObject oldObject) {
        this.oldObject = oldObject;
    }

}
