// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
public class ScopeUpdatedEventData {
    @SerializedName("added")
    private Scope added;
    @SerializedName("removed")
    private Scope removed;

    public Scope getAdded() {
        return this.added;
    }

    public void setAdded(Scope added) {
        this.added = added;
    }

    public Scope getRemoved() {
        return this.removed;
    }

    public void setRemoved(Scope removed) {
        this.removed = removed;
    }

}
