// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateDocumentResp extends BaseResponse {

    @SerializedName("data")
    private CreateDocumentDTO body;

    public CreateDocumentDTO getCreateDocumentDTO() {
        return this.body;
    }

    public void setCreateDocumentDTO(CreateDocumentDTO body) {
        this.body = body;
    }
}