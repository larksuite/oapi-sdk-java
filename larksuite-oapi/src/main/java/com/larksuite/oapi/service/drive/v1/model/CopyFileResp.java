// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CopyFileResp extends BaseResponse {

    @SerializedName("data")
    private CopyFileDTO body;

    public CopyFileDTO getCopyFileDTO() {
        return this.body;
    }

    public void setCopyFileDTO(CopyFileDTO body) {
        this.body = body;
    }
}
