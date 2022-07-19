// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class ListDataSourceReq {

  @Query
  @SerializedName("view")
  private Integer view;
  @Query
  @SerializedName("page_token")
  private String pageToken;
  @Query
  @SerializedName("page_size")
  private Integer pageSize;

  // builder 开始
  public ListDataSourceReq() {
  }

  public ListDataSourceReq(Builder builder) {
    this.view = builder.view;
    this.pageToken = builder.pageToken;
    this.pageSize = builder.pageSize;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getView() {
    return this.view;
  }

  public void setView(Integer view) {
    this.view = view;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public static class Builder {

    private Integer view;
    private String pageToken;
    private Integer pageSize;

    public Builder view(Integer view) {
      this.view = view;
      return this;
    }

    public Builder view(com.lark.oapi.service.search.v2.enums.ViewEnum view) {
      this.view = view.getValue();
      return this;
    }

    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public ListDataSourceReq build() {
      return new ListDataSourceReq(this);
    }
  }
}