// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class HighlightEntityResp extends BaseResponse {

    @SerializedName("data")
    private HighlightEntityDTO body;

    public HighlightEntityDTO getHighlightEntityDTO() {
        return this.body;
    }

    public void setHighlightEntityDTO(HighlightEntityDTO body) {
        this.body = body;
    }
}