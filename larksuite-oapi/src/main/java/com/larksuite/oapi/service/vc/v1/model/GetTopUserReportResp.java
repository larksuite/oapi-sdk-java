// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetTopUserReportResp extends BaseResponse {

    @SerializedName("data")
    private GetTopUserReportDTO body;

    public GetTopUserReportDTO getGetTopUserReportDTO() {
        return this.body;
    }

    public void setGetTopUserReportDTO(GetTopUserReportDTO body) {
        this.body = body;
    }
}