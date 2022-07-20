// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class P2TicketCreatedV1Data {

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
  @SerializedName("channel")
  private Integer channel;
  @SerializedName("solve")
  private Integer solve;
  @SerializedName("customized_fields")
  private CustomizedFieldDisplayItem[] customizedFields;
  @SerializedName("chat_id")
  private String chatId;

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

}
