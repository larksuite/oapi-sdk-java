// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;
import com.google.gson.annotations.SerializedName;

public class UserStatus {
    @SerializedName("is_frozen")
    private Boolean isFrozen;
    @SerializedName("is_resigned")
    private Boolean isResigned;
    @SerializedName("is_activated")
    private Boolean isActivated;

    public Boolean getIsFrozen() {
        return this.isFrozen;
    }

    public void setIsFrozen(Boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Boolean getIsResigned() {
        return this.isResigned;
    }

    public void setIsResigned(Boolean isResigned) {
        this.isResigned = isResigned;
    }

    public Boolean getIsActivated() {
        return this.isActivated;
    }

    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

}
