// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class RemoveInstanceComment {

  @SerializedName("instance_id")
  private String instanceId;
  @SerializedName("external_id")
  private String externalId;

  public String getInstanceId() {
    return this.instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public String getExternalId() {
    return this.externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

}
