// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class UploadFinishFileResp extends BaseResponse {

    @SerializedName("data")
    private UploadFinishFileDTO body;

    public UploadFinishFileDTO getUploadFinishFileDTO() {
        return this.body;
    }

    public void setUploadFinishFileDTO(UploadFinishFileDTO body) {
        this.body = body;
    }
}