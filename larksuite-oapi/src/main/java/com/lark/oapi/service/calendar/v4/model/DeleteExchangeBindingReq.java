// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;

public class DeleteExchangeBindingReq {

  @Path
  @SerializedName("exchange_binding_id")
  private String exchangeBindingId;

  // builder 开始
  public DeleteExchangeBindingReq() {
  }

  public DeleteExchangeBindingReq(Builder builder) {
    this.exchangeBindingId = builder.exchangeBindingId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getExchangeBindingId() {
    return this.exchangeBindingId;
  }

  public void setExchangeBindingId(String exchangeBindingId) {
    this.exchangeBindingId = exchangeBindingId;
  }

  public static class Builder {

    private String exchangeBindingId;

    public Builder exchangeBindingId(String exchangeBindingId) {
      this.exchangeBindingId = exchangeBindingId;
      return this;
    }

    public DeleteExchangeBindingReq build() {
      return new DeleteExchangeBindingReq(this);
    }
  }
}