// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class RawContentDocumentResp extends BaseResponse {

  @SerializedName("data")
  private RawContentDocument body;

  public RawContentDocument getRawContentDocument() {
    return this.body;
  }

  public void setRawContentDocument(RawContentDocument body) {
    this.body = body;
  }
}