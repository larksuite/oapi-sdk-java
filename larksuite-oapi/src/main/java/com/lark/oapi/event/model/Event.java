package com.lark.oapi.event.model;

import com.google.gson.annotations.SerializedName;

public class Event {

  @SerializedName("type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
