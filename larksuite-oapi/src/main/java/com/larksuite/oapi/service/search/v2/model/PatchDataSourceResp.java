// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class PatchDataSourceResp extends BaseResponse {

    @SerializedName("data")
    private PatchDataSourceDTO body;

    public PatchDataSourceDTO getPatchDataSourceDTO() {
        return this.body;
    }

    public void setPatchDataSourceDTO(PatchDataSourceDTO body) {
        this.body = body;
    }
}