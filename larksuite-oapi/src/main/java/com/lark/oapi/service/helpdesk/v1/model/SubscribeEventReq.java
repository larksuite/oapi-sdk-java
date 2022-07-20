// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.lark.oapi.core.annotation.Body;

public class SubscribeEventReq {

  @Body
  private SubscribeEventReqBody body;

  // builder 开始
  public SubscribeEventReq() {
  }

  public SubscribeEventReq(Builder builder) {
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public SubscribeEventReqBody getSubscribeEventReqBody() {
    return this.body;
  }

  public void setSubscribeEventReqBody(SubscribeEventReqBody body) {
    this.body = body;
  }

  public static class Builder {

    private SubscribeEventReqBody body;

    public SubscribeEventReqBody getSubscribeEventReqBody() {
      return this.body;
    }

    public Builder subscribeEventReqBody(SubscribeEventReqBody body) {
      this.body = body;
      return this;
    }

    public SubscribeEventReq build() {
      return new SubscribeEventReq(this);
    }
  }
}
