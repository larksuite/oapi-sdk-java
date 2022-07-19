// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class BatchMessageRecallProgress {

  @SerializedName("recall")
  private Boolean recall;
  @SerializedName("recall_count")
  private Integer recallCount;

  // builder 开始
  public BatchMessageRecallProgress() {
  }

  public BatchMessageRecallProgress(Builder builder) {
    this.recall = builder.recall;
    this.recallCount = builder.recallCount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Boolean getRecall() {
    return this.recall;
  }

  public void setRecall(Boolean recall) {
    this.recall = recall;
  }

  public Integer getRecallCount() {
    return this.recallCount;
  }

  public void setRecallCount(Integer recallCount) {
    this.recallCount = recallCount;
  }

  public static class Builder {

    private Boolean recall;
    private Integer recallCount;

    public Builder recall(Boolean recall) {
      this.recall = recall;
      return this;
    }

    public Builder recallCount(Integer recallCount) {
      this.recallCount = recallCount;
      return this;
    }


    public BatchMessageRecallProgress build() {
      return new BatchMessageRecallProgress(this);
    }
  }
}