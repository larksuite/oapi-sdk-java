// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class UploadFinishFileResp extends BaseResponse {

  @SerializedName("data")
  private UploadFinishFile body;

  public UploadFinishFile getUploadFinishFile() {
    return this.body;
  }

  public void setUploadFinishFile(UploadFinishFile body) {
    this.body = body;
  }
}
