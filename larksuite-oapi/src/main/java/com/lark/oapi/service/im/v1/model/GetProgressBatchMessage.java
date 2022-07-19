// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class GetProgressBatchMessage {

  @SerializedName("batch_message_send_progress")
  private BatchMessageSendProgress batchMessageSendProgress;
  @SerializedName("batch_message_recall_progress")
  private BatchMessageRecallProgress batchMessageRecallProgress;

  public BatchMessageSendProgress getBatchMessageSendProgress() {
    return this.batchMessageSendProgress;
  }

  public void setBatchMessageSendProgress(BatchMessageSendProgress batchMessageSendProgress) {
    this.batchMessageSendProgress = batchMessageSendProgress;
  }

  public BatchMessageRecallProgress getBatchMessageRecallProgress() {
    return this.batchMessageRecallProgress;
  }

  public void setBatchMessageRecallProgress(BatchMessageRecallProgress batchMessageRecallProgress) {
    this.batchMessageRecallProgress = batchMessageRecallProgress;
  }

}
