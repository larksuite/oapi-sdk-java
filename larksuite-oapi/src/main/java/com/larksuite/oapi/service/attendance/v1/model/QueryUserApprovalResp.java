// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class QueryUserApprovalResp extends BaseResponse {

    @SerializedName("data")
    private QueryUserApprovalDTO body;

    public QueryUserApprovalDTO getQueryUserApprovalDTO() {
        return this.body;
    }

    public void setQueryUserApprovalDTO(QueryUserApprovalDTO body) {
        this.body = body;
    }
}