// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class PatchTaskResp extends BaseResponse {

  @SerializedName("data")
  private PatchTask body;

  public PatchTask getPatchTask() {
    return this.body;
  }

  public void setPatchTask(PatchTask body) {
    this.body = body;
  }
}