// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class ApplicationAppVersionAuditEventData {
    @SerializedName("operator_id")
    private UserId operatorId;
    @SerializedName("version_id")
    private String versionId;
    @SerializedName("creator_id")
    private UserId creatorId;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("operation")
    private String operation;
    @SerializedName("remark")
    private String remark;
    @SerializedName("audit_source")
    private String auditSource;

    public UserId getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(UserId operatorId) {
        this.operatorId = operatorId;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public UserId getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(UserId creatorId) {
        this.creatorId = creatorId;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditSource() {
        return this.auditSource;
    }

    public void setAuditSource(String auditSource) {
        this.auditSource = auditSource;
    }

}
