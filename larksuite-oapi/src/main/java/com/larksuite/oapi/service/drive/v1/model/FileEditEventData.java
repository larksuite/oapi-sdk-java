// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class FileEditEventData {
    @SerializedName("file_type")
    private String fileType;
    @SerializedName("file_token")
    private String fileToken;
    @SerializedName("operator_id_list")
    private UserId[] operatorIdList;
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

    public UserId[] getOperatorIdList() {
        return this.operatorIdList;
    }

    public void setOperatorIdList(UserId[] operatorIdList) {
        this.operatorIdList = operatorIdList;
    }

    public UserId[] getSubscriberIdList() {
        return this.subscriberIdList;
    }

    public void setSubscriberIdList(UserId[] subscriberIdList) {
        this.subscriberIdList = subscriberIdList;
    }

}
