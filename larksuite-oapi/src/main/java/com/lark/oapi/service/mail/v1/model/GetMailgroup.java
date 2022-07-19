// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;

public class GetMailgroup {

  @SerializedName("mailgroup_id")
  private String mailgroupId;
  @SerializedName("email")
  private String email;
  @SerializedName("name")
  private String name;
  @SerializedName("description")
  private String description;
  @SerializedName("direct_members_count")
  private String directMembersCount;
  @SerializedName("include_external_member")
  private Boolean includeExternalMember;
  @SerializedName("include_all_company_member")
  private Boolean includeAllCompanyMember;
  @SerializedName("who_can_send_mail")
  private String whoCanSendMail;

  public String getMailgroupId() {
    return this.mailgroupId;
  }

  public void setMailgroupId(String mailgroupId) {
    this.mailgroupId = mailgroupId;
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

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDirectMembersCount() {
    return this.directMembersCount;
  }

  public void setDirectMembersCount(String directMembersCount) {
    this.directMembersCount = directMembersCount;
  }

  public Boolean getIncludeExternalMember() {
    return this.includeExternalMember;
  }

  public void setIncludeExternalMember(Boolean includeExternalMember) {
    this.includeExternalMember = includeExternalMember;
  }

  public Boolean getIncludeAllCompanyMember() {
    return this.includeAllCompanyMember;
  }

  public void setIncludeAllCompanyMember(Boolean includeAllCompanyMember) {
    this.includeAllCompanyMember = includeAllCompanyMember;
  }

  public String getWhoCanSendMail() {
    return this.whoCanSendMail;
  }

  public void setWhoCanSendMail(String whoCanSendMail) {
    this.whoCanSendMail = whoCanSendMail;
  }

}
