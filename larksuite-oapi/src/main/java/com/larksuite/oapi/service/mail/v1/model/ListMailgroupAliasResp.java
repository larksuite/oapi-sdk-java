// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListMailgroupAliasResp extends BaseResponse {

    @SerializedName("data")
    private ListMailgroupAliasDTO body;

    public ListMailgroupAliasDTO getListMailgroupAliasDTO() {
        return this.body;
    }

    public void setListMailgroupAliasDTO(ListMailgroupAliasDTO body) {
        this.body = body;
    }
}
