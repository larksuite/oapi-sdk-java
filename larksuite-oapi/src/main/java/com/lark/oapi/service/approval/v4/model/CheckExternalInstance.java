// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class CheckExternalInstance {

  @SerializedName("diff_instances")
  private ExteranlInstanceCheckResponse[] diffInstances;

  public ExteranlInstanceCheckResponse[] getDiffInstances() {
    return this.diffInstances;
  }

  public void setDiffInstances(ExteranlInstanceCheckResponse[] diffInstances) {
    this.diffInstances = diffInstances;
  }

}
