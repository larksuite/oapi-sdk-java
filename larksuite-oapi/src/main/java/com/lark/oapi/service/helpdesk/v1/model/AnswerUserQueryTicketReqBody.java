// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class AnswerUserQueryTicketReqBody {

  @SerializedName("event_id")
  private String eventId;
  @SerializedName("faqs")
  private UserQueryFaqInfo[] faqs;

  // builder 开始
  public AnswerUserQueryTicketReqBody() {
  }

  public AnswerUserQueryTicketReqBody(Builder builder) {
    this.eventId = builder.eventId;
    this.faqs = builder.faqs;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getEventId() {
    return this.eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public UserQueryFaqInfo[] getFaqs() {
    return this.faqs;
  }

  public void setFaqs(UserQueryFaqInfo[] faqs) {
    this.faqs = faqs;
  }

  public static class Builder {

    private String eventId;
    private UserQueryFaqInfo[] faqs;

    public Builder eventId(String eventId) {
      this.eventId = eventId;
      return this;
    }

    public Builder faqs(UserQueryFaqInfo[] faqs) {
      this.faqs = faqs;
      return this;
    }


    public AnswerUserQueryTicketReqBody build() {
      return new AnswerUserQueryTicketReqBody(this);
    }
  }
}
