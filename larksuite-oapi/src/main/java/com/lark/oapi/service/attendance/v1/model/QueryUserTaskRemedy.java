// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class QueryUserTaskRemedy {

  @SerializedName("user_remedys")
  private UserTaskRemedy[] userRemedys;

  public UserTaskRemedy[] getUserRemedys() {
    return this.userRemedys;
  }

  public void setUserRemedys(UserTaskRemedy[] userRemedys) {
    this.userRemedys = userRemedys;
  }

}