// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListEntity {

  @SerializedName("entities")
  private Entity[] entities;
  @SerializedName("page_token")
  private String pageToken;

  public Entity[] getEntities() {
    return this.entities;
  }

  public void setEntities(Entity[] entities) {
    this.entities = entities;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

}
