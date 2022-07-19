// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.acs.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListUser {

  @SerializedName("items")
  private User[] items;
  @SerializedName("page_token")
  private String pageToken;
  @SerializedName("has_more")
  private Boolean hasMore;

  public User[] getItems() {
    return this.items;
  }

  public void setItems(User[] items) {
    this.items = items;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

  public Boolean getHasMore() {
    return this.hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }

}