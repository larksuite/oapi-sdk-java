/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.request.EventReq;

public class CardAction {

  @SerializedName("open_id")
  private String openId;
  @SerializedName("user_id")
  private String userId;
  @SerializedName("open_message_id")
  private String openMessageId;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("token")
  private String token;
  @SerializedName("timezone")
  private String timezone;
  @SerializedName("action")
  private Action action;
  @SerializedName("challenge")
  private String challenge;
  @SerializedName("type")
  private String type;
  private EventReq eventReq;

  public EventReq getEventReq() {
    return eventReq;
  }

  public void setEventReq(EventReq eventReq) {
    this.eventReq = eventReq;
  }

  public String getRequestId() {
    return eventReq == null ? "" : eventReq.getRequestID();
  }

  public String getChallenge() {
    return challenge;
  }

  public void setChallenge(String challenge) {
    this.challenge = challenge;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOpenMessageId() {
    return openMessageId;
  }

  public void setOpenMessageId(String openMessageId) {
    this.openMessageId = openMessageId;
  }

  public String getTenantKey() {
    return tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return "Card{" +
        "openId='" + openId + '\'' +
        ", userId='" + userId + '\'' +
        ", openMessageId='" + openMessageId + '\'' +
        ", tenantKey='" + tenantKey + '\'' +
        ", token='" + token + '\'' +
        ", timezone='" + timezone + '\'' +
        ", action=" + action + '\'' +
        ", type=" + type + '\'' +
        ", challenge=" + challenge + '\'' +
        '}';
  }
}
