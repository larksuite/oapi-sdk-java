package com.lark.oapi.event.model;

import com.google.gson.annotations.SerializedName;

public class AppTicketEvent extends BaseEvent {

  @SerializedName("event")
  private AppTicketEventData event;

  public AppTicketEventData getEvent() {
    return event;
  }

  public void setEvent(AppTicketEventData event) {
    this.event = event;
  }

  public static class AppTicketEventData {

    @SerializedName("app_ticket")
    private String appTicket;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("type")
    private String type;

    public String getAppId() {
      return appId;
    }

    public void setAppId(String appId) {
      this.appId = appId;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getAppTicket() {
      return appTicket;
    }

    public void setAppTicket(String appTicket) {
      this.appTicket = appTicket;
    }
  }
}
