// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class CreateTimeoffEvent {

  @SerializedName("timeoff_event_id")
  private String timeoffEventId;
  @SerializedName("user_id")
  private String userId;
  @SerializedName("timezone")
  private String timezone;
  @SerializedName("start_time")
  private String startTime;
  @SerializedName("end_time")
  private String endTime;
  @SerializedName("title")
  private String title;
  @SerializedName("description")
  private String description;

  public String getTimeoffEventId() {
    return this.timeoffEventId;
  }

  public void setTimeoffEventId(String timeoffEventId) {
    this.timeoffEventId = timeoffEventId;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getTimezone() {
    return this.timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getStartTime() {
    return this.startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return this.endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
