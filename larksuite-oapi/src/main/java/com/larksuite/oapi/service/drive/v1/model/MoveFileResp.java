// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class MoveFileResp extends BaseResponse {

    @SerializedName("data")
    private MoveFileDTO body;

    public MoveFileDTO getMoveFileDTO() {
        return this.body;
    }

    public void setMoveFileDTO(MoveFileDTO body) {
        this.body = body;
    }
}
