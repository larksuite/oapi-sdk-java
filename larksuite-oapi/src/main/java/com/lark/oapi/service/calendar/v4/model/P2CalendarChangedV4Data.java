// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class P2CalendarChangedV4Data {

  @SerializedName("user_id_list")
  private UserId[] userIdList;

  public UserId[] getUserIdList() {
    return this.userIdList;
  }

  public void setUserIdList(UserId[] userIdList) {
    this.userIdList = userIdList;
  }

}