// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class GetCalendarDTO {
    @SerializedName("calendar_id")
    private String calendarId;
    @SerializedName("summary")
    private String summary;
    @SerializedName("description")
    private String description;
    @SerializedName("permissions")
    private String permissions;
    @SerializedName("color")
    private Integer color;
    @SerializedName("type")
    private String type;
    @SerializedName("summary_alias")
    private String summaryAlias;
    @SerializedName("is_deleted")
    private Boolean isDeleted;
    @SerializedName("is_third_party")
    private Boolean isThirdParty;
    @SerializedName("role")
    private String role;

    public String getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermissions() {
        return this.permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getColor() {
        return this.color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummaryAlias() {
        return this.summaryAlias;
    }

    public void setSummaryAlias(String summaryAlias) {
        this.summaryAlias = summaryAlias;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsThirdParty() {
        return this.isThirdParty;
    }

    public void setIsThirdParty(Boolean isThirdParty) {
        this.isThirdParty = isThirdParty;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
