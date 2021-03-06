// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;
import com.google.gson.annotations.SerializedName;

public class PublicMailbox {
    @SerializedName("public_mailbox_id")
    private String publicMailboxId;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;

    public String getPublicMailboxId() {
        return this.publicMailboxId;
    }

    public void setPublicMailboxId(String publicMailboxId) {
        this.publicMailboxId = publicMailboxId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
