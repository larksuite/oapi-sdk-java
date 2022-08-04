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

public class P1WorkApprovalV4Data {

  @SerializedName("type")
  private String type;
  @SerializedName("app_id")
  private String appId;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("instance_code")
  private String instanceCode;
  @SerializedName("open_id")
  private String openId;
  @SerializedName("employee_id")
  private String employeeId;
  @SerializedName("start_time")
  private long startTime;
  @SerializedName("end_time")
  private long endTime;

  @SerializedName("work_type")
  private String workType;
  @SerializedName("work_start_time")
  private String workStartTime;
  @SerializedName("work_end_time")
  private String workEndTime;

  @SerializedName("work_interval")
  private long workInterval;
  @SerializedName("work_reason")
  private String workReason;

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

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
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

  public String getWorkType() {
    return workType;
  }

  public void setWorkType(String workType) {
    this.workType = workType;
  }

  public String getWorkStartTime() {
    return workStartTime;
  }

  public void setWorkStartTime(String workStartTime) {
    this.workStartTime = workStartTime;
  }

  public String getWorkEndTime() {
    return workEndTime;
  }

  public void setWorkEndTime(String workEndTime) {
    this.workEndTime = workEndTime;
  }

  public long getWorkInterval() {
    return workInterval;
  }

  public void setWorkInterval(long workInterval) {
    this.workInterval = workInterval;
  }

  public String getWorkReason() {
    return workReason;
  }

  public void setWorkReason(String workReason) {
    this.workReason = workReason;
  }
}
