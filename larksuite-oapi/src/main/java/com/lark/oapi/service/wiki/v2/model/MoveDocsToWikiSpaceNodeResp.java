// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class MoveDocsToWikiSpaceNodeResp extends BaseResponse {

  @SerializedName("data")
  private MoveDocsToWikiSpaceNode body;

  public MoveDocsToWikiSpaceNode getMoveDocsToWikiSpaceNode() {
    return this.body;
  }

  public void setMoveDocsToWikiSpaceNode(MoveDocsToWikiSpaceNode body) {
    this.body = body;
  }
}
