// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class MatchEntityResp extends BaseResponse {

    @SerializedName("data")
    private MatchEntityDTO body;

    public MatchEntityDTO getMatchEntityDTO() {
        return this.body;
    }

    public void setMatchEntityDTO(MatchEntityDTO body) {
        this.body = body;
    }
}