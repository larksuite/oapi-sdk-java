// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateUserMailboxAlias {

  @SerializedName("user_mailbox_alias")
  private EmailAlias userMailboxAlias;

  public EmailAlias getUserMailboxAlias() {
    return this.userMailboxAlias;
  }

  public void setUserMailboxAlias(EmailAlias userMailboxAlias) {
    this.userMailboxAlias = userMailboxAlias;
  }

}
