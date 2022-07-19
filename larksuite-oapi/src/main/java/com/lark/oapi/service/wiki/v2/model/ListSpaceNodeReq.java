// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class ListSpaceNodeReq {

  @Query
  @SerializedName("page_size")
  private Integer pageSize;
  @Query
  @SerializedName("page_token")
  private String pageToken;
  @Query
  @SerializedName("parent_node_token")
  private String parentNodeToken;
  @Path
  @SerializedName("space_id")
  private String spaceId;

  // builder 开始
  public ListSpaceNodeReq() {
  }

  public ListSpaceNodeReq(Builder builder) {
    this.pageSize = builder.pageSize;
    this.pageToken = builder.pageToken;
    this.parentNodeToken = builder.parentNodeToken;
    this.spaceId = builder.spaceId;
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

  public String getParentNodeToken() {
    return this.parentNodeToken;
  }

  public void setParentNodeToken(String parentNodeToken) {
    this.parentNodeToken = parentNodeToken;
  }

  public String getSpaceId() {
    return this.spaceId;
  }

  public void setSpaceId(String spaceId) {
    this.spaceId = spaceId;
  }

  public static class Builder {

    private Integer pageSize;
    private String pageToken;
    private String parentNodeToken;
    private String spaceId;

    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public Builder parentNodeToken(String parentNodeToken) {
      this.parentNodeToken = parentNodeToken;
      return this;
    }

    public Builder spaceId(String spaceId) {
      this.spaceId = spaceId;
      return this;
    }

    public ListSpaceNodeReq build() {
      return new ListSpaceNodeReq(this);
    }
  }
}