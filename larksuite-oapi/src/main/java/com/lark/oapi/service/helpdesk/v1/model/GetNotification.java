// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class GetNotification {

  @SerializedName("notification")
  private Notification notification;
  @SerializedName("approval_app_link")
  private String approvalAppLink;

  public Notification getNotification() {
    return this.notification;
  }

  public void setNotification(Notification notification) {
    this.notification = notification;
  }

  public String getApprovalAppLink() {
    return this.approvalAppLink;
  }

  public void setApprovalAppLink(String approvalAppLink) {
    this.approvalAppLink = approvalAppLink;
  }

}
