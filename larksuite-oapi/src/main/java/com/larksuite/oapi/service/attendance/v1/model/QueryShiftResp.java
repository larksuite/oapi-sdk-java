// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class QueryShiftResp extends BaseResponse {

    @SerializedName("data")
    private QueryShiftDTO body;

    public QueryShiftDTO getQueryShiftDTO() {
        return this.body;
    }

    public void setQueryShiftDTO(QueryShiftDTO body) {
        this.body = body;
    }
}
