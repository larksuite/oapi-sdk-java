// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class CreateInstanceCommentReq {

  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  @Query
  @SerializedName("user_id")
  private Long userId;
  @Path
  @SerializedName("instance_id")
  private String instanceId;
  @Body
  private CommentRequest body;

  // builder 开始
  public CreateInstanceCommentReq() {
  }

  public CreateInstanceCommentReq(Builder builder) {
    this.userIdType = builder.userIdType;
    this.userId = builder.userId;
    this.instanceId = builder.instanceId;
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getInstanceId() {
    return this.instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public CommentRequest getCommentRequest() {
    return this.body;
  }

  public void setCommentRequest(CommentRequest body) {
    this.body = body;
  }

  public static class Builder {

    private String userIdType;
    private Long userId;
    private String instanceId;
    private CommentRequest body;

    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    public Builder userIdType(com.lark.oapi.service.approval.v4.enums.UserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    public Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    public CommentRequest getCommentRequest() {
      return this.body;
    }

    public Builder commentRequest(CommentRequest body) {
      this.body = body;
      return this;
    }

    public CreateInstanceCommentReq build() {
      return new CreateInstanceCommentReq(this);
    }
  }
}