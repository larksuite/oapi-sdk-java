// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class FileTitleUpdatedEventData {
    @SerializedName("file_type")
    private String fileType;
    @SerializedName("file_token")
    private String fileToken;
    @SerializedName("operator_id")
    private UserId operatorId;
    @SerializedName("subscriber_id_list")
    private UserId[] subscriberIdList;

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    public UserId getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(UserId operatorId) {
        this.operatorId = operatorId;
    }

    public UserId[] getSubscriberIdList() {
        return this.subscriberIdList;
    }

    public void setSubscriberIdList(UserId[] subscriberIdList) {
        this.subscriberIdList = subscriberIdList;
    }

}
