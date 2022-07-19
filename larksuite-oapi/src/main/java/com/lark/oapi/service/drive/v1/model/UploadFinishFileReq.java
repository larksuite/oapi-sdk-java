// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.drive.v1.model;

import com.lark.oapi.core.annotation.Body;

public class UploadFinishFileReq {

  @Body
  private UploadFinishFileReqBody body;

  // builder 开始
  public UploadFinishFileReq() {
  }

  public UploadFinishFileReq(Builder builder) {
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public UploadFinishFileReqBody getUploadFinishFileReqBody() {
    return this.body;
  }

  public void setUploadFinishFileReqBody(UploadFinishFileReqBody body) {
    this.body = body;
  }

  public static class Builder {

    private UploadFinishFileReqBody body;

    public UploadFinishFileReqBody getUploadFinishFileReqBody() {
      return this.body;
    }

    public Builder uploadFinishFileReqBody(UploadFinishFileReqBody body) {
      this.body = body;
      return this;
    }

    public UploadFinishFileReq build() {
      return new UploadFinishFileReq(this);
    }
  }
}