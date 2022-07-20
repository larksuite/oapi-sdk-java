// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class TicketEvent {

  @SerializedName("ticket_id")
  private String ticketId;
  @SerializedName("helpdesk_id")
  private String helpdeskId;
  @SerializedName("guest")
  private TicketUserEvent guest;
  @SerializedName("stage")
  private Integer stage;
  @SerializedName("status")
  private Integer status;
  @SerializedName("score")
  private Integer score;
  @SerializedName("created_at")
  private Integer createdAt;
  @SerializedName("updated_at")
  private Integer updatedAt;
  @SerializedName("closed_at")
  private Integer closedAt;
  @SerializedName("agents")
  private TicketUserEvent[] agents;
  @SerializedName("channel")
  private Integer channel;
  @SerializedName("solve")
  private Integer solve;
  @SerializedName("closed_by")
  private TicketUserEvent closedBy;
  @SerializedName("collaborators")
  private TicketUserEvent[] collaborators;
  @SerializedName("customized_fields")
  private CustomizedFieldDisplayItem[] customizedFields;
  @SerializedName("chat_id")
  private String chatId;

  // builder 开始
  public TicketEvent() {
  }

  public TicketEvent(Builder builder) {
    this.ticketId = builder.ticketId;
    this.helpdeskId = builder.helpdeskId;
    this.guest = builder.guest;
    this.stage = builder.stage;
    this.status = builder.status;
    this.score = builder.score;
    this.createdAt = builder.createdAt;
    this.updatedAt = builder.updatedAt;
    this.closedAt = builder.closedAt;
    this.agents = builder.agents;
    this.channel = builder.channel;
    this.solve = builder.solve;
    this.closedBy = builder.closedBy;
    this.collaborators = builder.collaborators;
    this.customizedFields = builder.customizedFields;
    this.chatId = builder.chatId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTicketId() {
    return this.ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  public String getHelpdeskId() {
    return this.helpdeskId;
  }

  public void setHelpdeskId(String helpdeskId) {
    this.helpdeskId = helpdeskId;
  }

  public TicketUserEvent getGuest() {
    return this.guest;
  }

  public void setGuest(TicketUserEvent guest) {
    this.guest = guest;
  }

  public Integer getStage() {
    return this.stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getScore() {
    return this.score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Integer getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Integer updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Integer getClosedAt() {
    return this.closedAt;
  }

  public void setClosedAt(Integer closedAt) {
    this.closedAt = closedAt;
  }

  public TicketUserEvent[] getAgents() {
    return this.agents;
  }

  public void setAgents(TicketUserEvent[] agents) {
    this.agents = agents;
  }

  public Integer getChannel() {
    return this.channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }

  public Integer getSolve() {
    return this.solve;
  }

  public void setSolve(Integer solve) {
    this.solve = solve;
  }

  public TicketUserEvent getClosedBy() {
    return this.closedBy;
  }

  public void setClosedBy(TicketUserEvent closedBy) {
    this.closedBy = closedBy;
  }

  public TicketUserEvent[] getCollaborators() {
    return this.collaborators;
  }

  public void setCollaborators(TicketUserEvent[] collaborators) {
    this.collaborators = collaborators;
  }

  public CustomizedFieldDisplayItem[] getCustomizedFields() {
    return this.customizedFields;
  }

  public void setCustomizedFields(CustomizedFieldDisplayItem[] customizedFields) {
    this.customizedFields = customizedFields;
  }

  public String getChatId() {
    return this.chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public static class Builder {

    private String ticketId;
    private String helpdeskId;
    private TicketUserEvent guest;
    private Integer stage;
    private Integer status;
    private Integer score;
    private Integer createdAt;
    private Integer updatedAt;
    private Integer closedAt;
    private TicketUserEvent[] agents;
    private Integer channel;
    private Integer solve;
    private TicketUserEvent closedBy;
    private TicketUserEvent[] collaborators;
    private CustomizedFieldDisplayItem[] customizedFields;
    private String chatId;

    public Builder ticketId(String ticketId) {
      this.ticketId = ticketId;
      return this;
    }

    public Builder helpdeskId(String helpdeskId) {
      this.helpdeskId = helpdeskId;
      return this;
    }

    public Builder guest(TicketUserEvent guest) {
      this.guest = guest;
      return this;
    }

    public Builder stage(Integer stage) {
      this.stage = stage;
      return this;
    }

    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    public Builder score(Integer score) {
      this.score = score;
      return this;
    }

    public Builder createdAt(Integer createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder updatedAt(Integer updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Builder closedAt(Integer closedAt) {
      this.closedAt = closedAt;
      return this;
    }

    public Builder agents(TicketUserEvent[] agents) {
      this.agents = agents;
      return this;
    }

    public Builder channel(Integer channel) {
      this.channel = channel;
      return this;
    }

    public Builder solve(Integer solve) {
      this.solve = solve;
      return this;
    }

    public Builder closedBy(TicketUserEvent closedBy) {
      this.closedBy = closedBy;
      return this;
    }

    public Builder collaborators(TicketUserEvent[] collaborators) {
      this.collaborators = collaborators;
      return this;
    }

    public Builder customizedFields(CustomizedFieldDisplayItem[] customizedFields) {
      this.customizedFields = customizedFields;
      return this;
    }

    public Builder chatId(String chatId) {
      this.chatId = chatId;
      return this;
    }


    public TicketEvent build() {
      return new TicketEvent(this);
    }
  }
}
