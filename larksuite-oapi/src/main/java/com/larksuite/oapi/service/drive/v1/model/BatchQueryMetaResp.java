// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class BatchQueryMetaResp extends BaseResponse {

    @SerializedName("data")
    private BatchQueryMetaDTO body;

    public BatchQueryMetaDTO getBatchQueryMetaDTO() {
        return this.body;
    }

    public void setBatchQueryMetaDTO(BatchQueryMetaDTO body) {
        this.body = body;
    }
}
