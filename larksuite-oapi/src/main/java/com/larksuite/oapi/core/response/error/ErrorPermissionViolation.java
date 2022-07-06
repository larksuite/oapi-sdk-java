package com.larksuite.oapi.core.response.error;

import com.google.gson.annotations.SerializedName;

public class ErrorPermissionViolation {
    @SerializedName("type")
    private String type;
    @SerializedName("subject")
    private String subject;
    @SerializedName("description")
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorPermissionViolation{" +
                "type='" + type + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
