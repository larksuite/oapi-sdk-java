// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class QueryUserTaskResp extends BaseResponse {

    @SerializedName("data")
    private QueryUserTaskDTO body;

    public QueryUserTaskDTO getQueryUserTaskDTO() {
        return this.body;
    }

    public void setQueryUserTaskDTO(QueryUserTaskDTO body) {
        this.body = body;
    }
}