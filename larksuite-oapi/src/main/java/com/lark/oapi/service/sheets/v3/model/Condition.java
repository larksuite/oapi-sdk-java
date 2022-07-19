// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class Condition {

  @SerializedName("filter_type")
  private String filterType;
  @SerializedName("compare_type")
  private String compareType;
  @SerializedName("expected")
  private String[] expected;

  // builder 开始
  public Condition() {
  }

  public Condition(Builder builder) {
    this.filterType = builder.filterType;
    this.compareType = builder.compareType;
    this.expected = builder.expected;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getFilterType() {
    return this.filterType;
  }

  public void setFilterType(String filterType) {
    this.filterType = filterType;
  }

  public String getCompareType() {
    return this.compareType;
  }

  public void setCompareType(String compareType) {
    this.compareType = compareType;
  }

  public String[] getExpected() {
    return this.expected;
  }

  public void setExpected(String[] expected) {
    this.expected = expected;
  }

  public static class Builder {

    private String filterType;
    private String compareType;
    private String[] expected;

    public Builder filterType(String filterType) {
      this.filterType = filterType;
      return this;
    }

    public Builder compareType(String compareType) {
      this.compareType = compareType;
      return this;
    }

    public Builder expected(String[] expected) {
      this.expected = expected;
      return this;
    }


    public Condition build() {
      return new Condition(this);
    }
  }
}