// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateMailgroupAliasDTO {
    @SerializedName("mailgroup_alias")
    private EmailAlias mailgroupAlias;

    public EmailAlias getMailgroupAlias() {
        return this.mailgroupAlias;
    }

    public void setMailgroupAlias(EmailAlias mailgroupAlias) {
        this.mailgroupAlias = mailgroupAlias;
    }

}