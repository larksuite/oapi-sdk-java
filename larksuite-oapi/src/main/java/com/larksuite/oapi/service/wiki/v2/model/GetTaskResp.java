// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetTaskResp extends BaseResponse {

    @SerializedName("data")
    private GetTaskDTO body;

    public GetTaskDTO getGetTaskDTO() {
        return this.body;
    }

    public void setGetTaskDTO(GetTaskDTO body) {
        this.body = body;
    }
}