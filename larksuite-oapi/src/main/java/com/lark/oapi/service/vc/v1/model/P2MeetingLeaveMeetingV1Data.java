// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class P2MeetingLeaveMeetingV1Data {

  @SerializedName("meeting")
  private MeetingEventMeeting meeting;
  @SerializedName("operator")
  private MeetingEventUser operator;
  @SerializedName("leave_reason")
  private Integer leaveReason;

  public MeetingEventMeeting getMeeting() {
    return this.meeting;
  }

  public void setMeeting(MeetingEventMeeting meeting) {
    this.meeting = meeting;
  }

  public MeetingEventUser getOperator() {
    return this.operator;
  }

  public void setOperator(MeetingEventUser operator) {
    this.operator = operator;
  }

  public Integer getLeaveReason() {
    return this.leaveReason;
  }

  public void setLeaveReason(Integer leaveReason) {
    this.leaveReason = leaveReason;
  }

}