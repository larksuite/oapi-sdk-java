// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class SimplelistGroupMemberReq {

  @Query
  @SerializedName("page_size")
  private Integer pageSize;
  @Query
  @SerializedName("page_token")
  private String pageToken;
  @Query
  @SerializedName("member_id_type")
  private String memberIdType;
  @Query
  @SerializedName("member_type")
  private String memberType;
  @Path
  @SerializedName("group_id")
  private String groupId;

  // builder 开始
  public SimplelistGroupMemberReq() {
  }

  public SimplelistGroupMemberReq(Builder builder) {
    this.pageSize = builder.pageSize;
    this.pageToken = builder.pageToken;
    this.memberIdType = builder.memberIdType;
    this.memberType = builder.memberType;
    this.groupId = builder.groupId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

  public String getMemberIdType() {
    return this.memberIdType;
  }

  public void setMemberIdType(String memberIdType) {
    this.memberIdType = memberIdType;
  }

  public String getMemberType() {
    return this.memberType;
  }

  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }

  public String getGroupId() {
    return this.groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public static class Builder {

    private Integer pageSize;
    private String pageToken;
    private String memberIdType;
    private String memberType;
    private String groupId;

    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public Builder memberIdType(String memberIdType) {
      this.memberIdType = memberIdType;
      return this;
    }

    public Builder memberIdType(
        com.lark.oapi.service.contact.v3.enums.MemberIdTypeEnum memberIdType) {
      this.memberIdType = memberIdType.getValue();
      return this;
    }

    public Builder memberType(String memberType) {
      this.memberType = memberType;
      return this;
    }

    public Builder memberType(com.lark.oapi.service.contact.v3.enums.MemberTypeEnum memberType) {
      this.memberType = memberType.getValue();
      return this;
    }

    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }

    public SimplelistGroupMemberReq build() {
      return new SimplelistGroupMemberReq(this);
    }
  }
}