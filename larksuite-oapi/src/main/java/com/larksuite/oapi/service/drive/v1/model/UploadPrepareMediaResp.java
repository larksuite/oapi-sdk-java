// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class UploadPrepareMediaResp extends BaseResponse {

    @SerializedName("data")
    private UploadPrepareMediaDTO body;

    public UploadPrepareMediaDTO getUploadPrepareMediaDTO() {
        return this.body;
    }

    public void setUploadPrepareMediaDTO(UploadPrepareMediaDTO body) {
        this.body = body;
    }
}