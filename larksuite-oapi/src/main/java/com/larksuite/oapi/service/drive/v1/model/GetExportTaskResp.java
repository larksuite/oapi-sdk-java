// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetExportTaskResp extends BaseResponse {

    @SerializedName("data")
    private GetExportTaskDTO body;

    public GetExportTaskDTO getGetExportTaskDTO() {
        return this.body;
    }

    public void setGetExportTaskDTO(GetExportTaskDTO body) {
        this.body = body;
    }
}