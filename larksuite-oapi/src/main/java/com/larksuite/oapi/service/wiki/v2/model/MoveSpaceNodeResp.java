// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class MoveSpaceNodeResp extends BaseResponse {

    @SerializedName("data")
    private MoveSpaceNodeDTO body;

    public MoveSpaceNodeDTO getMoveSpaceNodeDTO() {
        return this.body;
    }

    public void setMoveSpaceNodeDTO(MoveSpaceNodeDTO body) {
        this.body = body;
    }
}