// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListAgentSkillResp extends BaseResponse {

  @SerializedName("data")
  private ListAgentSkill body;

  public ListAgentSkill getListAgentSkill() {
    return this.body;
  }

  public void setListAgentSkill(ListAgentSkill body) {
    this.body = body;
  }
}
