// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class ReadUserBatchMessageDTO {

  @SerializedName("read_user")
  private BatchMessageReadUser readUser;

  public BatchMessageReadUser getReadUser() {
    return this.readUser;
  }

  public void setReadUser(BatchMessageReadUser readUser) {
    this.readUser = readUser;
  }

}