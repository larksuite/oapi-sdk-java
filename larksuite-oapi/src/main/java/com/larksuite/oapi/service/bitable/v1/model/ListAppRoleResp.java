// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListAppRoleResp extends BaseResponse {

    @SerializedName("data")
    private ListAppRoleDTO body;

    public ListAppRoleDTO getListAppRoleDTO() {
        return this.body;
    }

    public void setListAppRoleDTO(ListAppRoleDTO body) {
        this.body = body;
    }
}
