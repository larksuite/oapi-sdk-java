// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;
import com.google.gson.annotations.SerializedName;

public class MeetingEventUser {
    @SerializedName("id")
    private UserId id;
    @SerializedName("user_role")
    private Integer userRole;
    @SerializedName("user_type")
    private Integer userType;

    public UserId getId() {
        return this.id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public Integer getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

}
