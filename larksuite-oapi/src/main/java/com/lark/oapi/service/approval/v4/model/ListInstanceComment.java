// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ListInstanceComment {

  @SerializedName("comments")
  private Comment[] comments;

  public Comment[] getComments() {
    return this.comments;
  }

  public void setComments(Comment[] comments) {
    this.comments = comments;
  }

}