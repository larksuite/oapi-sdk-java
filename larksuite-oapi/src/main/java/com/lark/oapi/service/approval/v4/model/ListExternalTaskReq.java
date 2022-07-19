// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class ListExternalTaskReq {

  @Query
  @SerializedName("page_size")
  private Integer pageSize;
  @Query
  @SerializedName("page_token")
  private String pageToken;
  @Body
  private ListExternalTaskReqBody body;

  // builder 开始
  public ListExternalTaskReq() {
  }

  public ListExternalTaskReq(Builder builder) {
    this.pageSize = builder.pageSize;
    this.pageToken = builder.pageToken;
    this.body = builder.body;
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

  public ListExternalTaskReqBody getListExternalTaskReqBody() {
    return this.body;
  }

  public void setListExternalTaskReqBody(ListExternalTaskReqBody body) {
    this.body = body;
  }

  public static class Builder {

    private Integer pageSize;
    private String pageToken;
    private ListExternalTaskReqBody body;

    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public ListExternalTaskReqBody getListExternalTaskReqBody() {
      return this.body;
    }

    public Builder listExternalTaskReqBody(ListExternalTaskReqBody body) {
      this.body = body;
      return this;
    }

    public ListExternalTaskReq build() {
      return new ListExternalTaskReq(this);
    }
  }
}