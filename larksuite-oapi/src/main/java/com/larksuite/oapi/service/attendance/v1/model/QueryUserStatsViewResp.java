// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class QueryUserStatsViewResp extends BaseResponse {

    @SerializedName("data")
    private QueryUserStatsViewDTO body;

    public QueryUserStatsViewDTO getQueryUserStatsViewDTO() {
        return this.body;
    }

    public void setQueryUserStatsViewDTO(QueryUserStatsViewDTO body) {
        this.body = body;
    }
}