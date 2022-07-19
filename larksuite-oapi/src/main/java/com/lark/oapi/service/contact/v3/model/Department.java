// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class Department {

  @SerializedName("name")
  private String name;
  @SerializedName("i18n_name")
  private DepartmentI18nName i18nName;
  @SerializedName("parent_department_id")
  private String parentDepartmentId;
  @SerializedName("department_id")
  private String departmentId;
  @SerializedName("open_department_id")
  private String openDepartmentId;
  @SerializedName("leader_user_id")
  private String leaderUserId;
  @SerializedName("chat_id")
  private String chatId;
  @SerializedName("order")
  private Long order;
  @SerializedName("unit_ids")
  private String[] unitIds;
  @SerializedName("member_count")
  private Integer memberCount;
  @SerializedName("status")
  private DepartmentStatus status;
  @SerializedName("create_group_chat")
  private Boolean createGroupChat;

  // builder 开始
  public Department() {
  }

  public Department(Builder builder) {
    this.name = builder.name;
    this.i18nName = builder.i18nName;
    this.parentDepartmentId = builder.parentDepartmentId;
    this.departmentId = builder.departmentId;
    this.openDepartmentId = builder.openDepartmentId;
    this.leaderUserId = builder.leaderUserId;
    this.chatId = builder.chatId;
    this.order = builder.order;
    this.unitIds = builder.unitIds;
    this.memberCount = builder.memberCount;
    this.status = builder.status;
    this.createGroupChat = builder.createGroupChat;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DepartmentI18nName getI18nName() {
    return this.i18nName;
  }

  public void setI18nName(DepartmentI18nName i18nName) {
    this.i18nName = i18nName;
  }

  public String getParentDepartmentId() {
    return this.parentDepartmentId;
  }

  public void setParentDepartmentId(String parentDepartmentId) {
    this.parentDepartmentId = parentDepartmentId;
  }

  public String getDepartmentId() {
    return this.departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getOpenDepartmentId() {
    return this.openDepartmentId;
  }

  public void setOpenDepartmentId(String openDepartmentId) {
    this.openDepartmentId = openDepartmentId;
  }

  public String getLeaderUserId() {
    return this.leaderUserId;
  }

  public void setLeaderUserId(String leaderUserId) {
    this.leaderUserId = leaderUserId;
  }

  public String getChatId() {
    return this.chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public Long getOrder() {
    return this.order;
  }

  public void setOrder(Long order) {
    this.order = order;
  }

  public String[] getUnitIds() {
    return this.unitIds;
  }

  public void setUnitIds(String[] unitIds) {
    this.unitIds = unitIds;
  }

  public Integer getMemberCount() {
    return this.memberCount;
  }

  public void setMemberCount(Integer memberCount) {
    this.memberCount = memberCount;
  }

  public DepartmentStatus getStatus() {
    return this.status;
  }

  public void setStatus(DepartmentStatus status) {
    this.status = status;
  }

  public Boolean getCreateGroupChat() {
    return this.createGroupChat;
  }

  public void setCreateGroupChat(Boolean createGroupChat) {
    this.createGroupChat = createGroupChat;
  }

  public static class Builder {

    private String name;
    private DepartmentI18nName i18nName;
    private String parentDepartmentId;
    private String departmentId;
    private String openDepartmentId;
    private String leaderUserId;
    private String chatId;
    private Long order;
    private String[] unitIds;
    private Integer memberCount;
    private DepartmentStatus status;
    private Boolean createGroupChat;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder i18nName(DepartmentI18nName i18nName) {
      this.i18nName = i18nName;
      return this;
    }

    public Builder parentDepartmentId(String parentDepartmentId) {
      this.parentDepartmentId = parentDepartmentId;
      return this;
    }

    public Builder departmentId(String departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public Builder openDepartmentId(String openDepartmentId) {
      this.openDepartmentId = openDepartmentId;
      return this;
    }

    public Builder leaderUserId(String leaderUserId) {
      this.leaderUserId = leaderUserId;
      return this;
    }

    public Builder chatId(String chatId) {
      this.chatId = chatId;
      return this;
    }

    public Builder order(Long order) {
      this.order = order;
      return this;
    }

    public Builder unitIds(String[] unitIds) {
      this.unitIds = unitIds;
      return this;
    }

    public Builder memberCount(Integer memberCount) {
      this.memberCount = memberCount;
      return this;
    }

    public Builder status(DepartmentStatus status) {
      this.status = status;
      return this;
    }

    public Builder createGroupChat(Boolean createGroupChat) {
      this.createGroupChat = createGroupChat;
      return this;
    }


    public Department build() {
      return new Department(this);
    }
  }
}