// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;

public class DeleteTicketCustomizedFieldReq {

  @Path
  @SerializedName("ticket_customized_field_id")
  private String ticketCustomizedFieldId;

  // builder 开始
  public DeleteTicketCustomizedFieldReq() {
  }

  public DeleteTicketCustomizedFieldReq(Builder builder) {
    this.ticketCustomizedFieldId = builder.ticketCustomizedFieldId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTicketCustomizedFieldId() {
    return this.ticketCustomizedFieldId;
  }

  public void setTicketCustomizedFieldId(String ticketCustomizedFieldId) {
    this.ticketCustomizedFieldId = ticketCustomizedFieldId;
  }

  public static class Builder {

    private String ticketCustomizedFieldId;

    public Builder ticketCustomizedFieldId(String ticketCustomizedFieldId) {
      this.ticketCustomizedFieldId = ticketCustomizedFieldId;
      return this;
    }

    public DeleteTicketCustomizedFieldReq build() {
      return new DeleteTicketCustomizedFieldReq(this);
    }
  }
}
