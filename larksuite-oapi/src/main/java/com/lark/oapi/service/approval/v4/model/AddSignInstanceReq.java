// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.lark.oapi.core.annotation.Body;

public class AddSignInstanceReq {

  @Body
  private AddSignInstanceReqBody body;

  // builder 开始
  public AddSignInstanceReq() {
  }

  public AddSignInstanceReq(Builder builder) {
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public AddSignInstanceReqBody getAddSignInstanceReqBody() {
    return this.body;
  }

  public void setAddSignInstanceReqBody(AddSignInstanceReqBody body) {
    this.body = body;
  }

  public static class Builder {

    private AddSignInstanceReqBody body;

    public AddSignInstanceReqBody getAddSignInstanceReqBody() {
      return this.body;
    }

    public Builder addSignInstanceReqBody(AddSignInstanceReqBody body) {
      this.body = body;
      return this;
    }

    public AddSignInstanceReq build() {
      return new AddSignInstanceReq(this);
    }
  }
}