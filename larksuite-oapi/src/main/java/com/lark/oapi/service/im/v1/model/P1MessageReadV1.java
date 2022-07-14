package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEvent;

public class P1MessageReadV1 extends BaseEvent {

  @SerializedName("event")
  private P1MessageReadV1Data p1MessageReadV1Data;

  public P1MessageReadV1Data getP1MessageReadV1Data() {
    return p1MessageReadV1Data;
  }

  public void setP1MessageReadV1Data(P1MessageReadV1Data p1MessageReadV1Data) {
    this.p1MessageReadV1Data = p1MessageReadV1Data;
  }
}
