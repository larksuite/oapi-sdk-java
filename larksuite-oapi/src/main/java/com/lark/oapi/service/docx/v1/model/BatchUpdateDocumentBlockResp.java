// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class BatchUpdateDocumentBlockResp extends BaseResponse {

  @SerializedName("data")
  private BatchUpdateDocumentBlock body;

  public BatchUpdateDocumentBlock getBatchUpdateDocumentBlock() {
    return this.body;
  }

  public void setBatchUpdateDocumentBlock(BatchUpdateDocumentBlock body) {
    this.body = body;
  }
}
