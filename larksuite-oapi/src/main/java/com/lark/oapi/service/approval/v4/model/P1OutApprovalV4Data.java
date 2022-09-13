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

package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class P1OutApprovalV4Data {

  @SerializedName("type")
  private String type;
  @SerializedName("app_id")
  private String appId;
  @SerializedName("i18n_resources")
  private P1OutApprovalI18nResourceV4[] i18nResources;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("instance_code")
  private String instanceCode;
  @SerializedName("open_id")
  private String openId;
  @SerializedName("user_id")
  private String userId;
  @SerializedName("out_image")
  private String outImage;
  @SerializedName("out_interval")
  private long outInterval;
  @SerializedName("out_name")
  private String outName;
  @SerializedName("out_reason")
  private String outReason;
  @SerializedName("out_start_time")
  private String outStartTime;
  @SerializedName("out_end_time")
  private String outEndTime;
  @SerializedName("out_unit")
  private String outUnit;
  @SerializedName("start_time")
  private long startTime;
  @SerializedName("end_time")
  private long endTime;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public P1OutApprovalI18nResourceV4[] getI18nResources() {
    return i18nResources;
  }

  public void setI18nResources(
      P1OutApprovalI18nResourceV4[] i18nResources) {
    this.i18nResources = i18nResources;
  }

  public String getTenantKey() {
    return tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public String getInstanceCode() {
    return instanceCode;
  }

  public void setInstanceCode(String instanceCode) {
    this.instanceCode = instanceCode;
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

  public String getOutImage() {
    return outImage;
  }

  public void setOutImage(String outImage) {
    this.outImage = outImage;
  }

  public long getOutInterval() {
    return outInterval;
  }

  public void setOutInterval(long outInterval) {
    this.outInterval = outInterval;
  }

  public String getOutName() {
    return outName;
  }

  public void setOutName(String outName) {
    this.outName = outName;
  }

  public String getOutReason() {
    return outReason;
  }

  public void setOutReason(String outReason) {
    this.outReason = outReason;
  }

  public String getOutStartTime() {
    return outStartTime;
  }

  public void setOutStartTime(String outStartTime) {
    this.outStartTime = outStartTime;
  }

  public String getOutEndTime() {
    return outEndTime;
  }

  public void setOutEndTime(String outEndTime) {
    this.outEndTime = outEndTime;
  }

  public String getOutUnit() {
    return outUnit;
  }

  public void setOutUnit(String outUnit) {
    this.outUnit = outUnit;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public static class P1OutApprovalI18nResourceV4 {

    @SerializedName("is_default")
    private boolean isDefault;
    @SerializedName("locale")
    private String locale;
    @SerializedName("texts")
    private Map<String, String> texts;

    public boolean isDefault() {
      return isDefault;
    }

    public void setDefault(boolean aDefault) {
      isDefault = aDefault;
    }

    public String getLocale() {
      return locale;
    }

    public void setLocale(String locale) {
      this.locale = locale;
    }

    public Map<String, String> getTexts() {
      return texts;
    }

    public void setTexts(Map<String, String> texts) {
      this.texts = texts;
    }
  }

}
