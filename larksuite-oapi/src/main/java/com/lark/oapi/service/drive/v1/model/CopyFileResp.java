// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CopyFileResp extends BaseResponse {

  @SerializedName("data")
  private CopyFile body;

  public CopyFile getCopyFile() {
    return this.body;
  }

  public void setCopyFile(CopyFile body) {
    this.body = body;
  }
}
