// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class UpdateTextStyleRequest {

  @SerializedName("style")
  private TextStyle style;
  @SerializedName("fields")
  private Integer[] fields;

  // builder 开始
  public UpdateTextStyleRequest() {
  }

  public UpdateTextStyleRequest(Builder builder) {
    this.style = builder.style;
    this.fields = builder.fields;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public TextStyle getStyle() {
    return this.style;
  }

  public void setStyle(TextStyle style) {
    this.style = style;
  }

  public Integer[] getFields() {
    return this.fields;
  }

  public void setFields(Integer[] fields) {
    this.fields = fields;
  }

  public static class Builder {

    private TextStyle style;
    private Integer[] fields;

    public Builder style(TextStyle style) {
      this.style = style;
      return this;
    }

    public Builder fields(Integer[] fields) {
      this.fields = fields;
      return this;
    }


    public UpdateTextStyleRequest build() {
      return new UpdateTextStyleRequest(this);
    }
  }
}