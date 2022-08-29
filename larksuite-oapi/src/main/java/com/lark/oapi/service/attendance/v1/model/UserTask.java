// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class UserTask {

  /**
   * 打卡记录 ID
   * <p> 示例值：6709359313699356941
   */
  @SerializedName("result_id")
  private String resultId;
  /**
   * 用户 ID
   * <p> 示例值：abd754f7
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 用户姓名
   * <p> 示例值：张三
   */
  @SerializedName("employee_name")
  private String employeeName;
  /**
   * 日期
   * <p> 示例值：20190819
   */
  @SerializedName("day")
  private Integer day;
  /**
   * 考勤组 ID
   * <p> 示例值：6737202939523236110
   */
  @SerializedName("group_id")
  private String groupId;
  /**
   * 班次 ID
   * <p> 示例值：6753520403404030215
   */
  @SerializedName("shift_id")
  private String shiftId;
  /**
   * 用户考勤记录
   * <p> 示例值：
   */
  @SerializedName("records")
  private TaskResult[] records;

  // builder 开始
  public UserTask() {
  }

  public UserTask(Builder builder) {
    /**
     * 打卡记录 ID
     * <p> 示例值：6709359313699356941
     */
    this.resultId = builder.resultId;
    /**
     * 用户 ID
     * <p> 示例值：abd754f7
     */
    this.userId = builder.userId;
    /**
     * 用户姓名
     * <p> 示例值：张三
     */
    this.employeeName = builder.employeeName;
    /**
     * 日期
     * <p> 示例值：20190819
     */
    this.day = builder.day;
    /**
     * 考勤组 ID
     * <p> 示例值：6737202939523236110
     */
    this.groupId = builder.groupId;
    /**
     * 班次 ID
     * <p> 示例值：6753520403404030215
     */
    this.shiftId = builder.shiftId;
    /**
     * 用户考勤记录
     * <p> 示例值：
     */
    this.records = builder.records;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getResultId() {
    return this.resultId;
  }

  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmployeeName() {
    return this.employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Integer getDay() {
    return this.day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public String getGroupId() {
    return this.groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getShiftId() {
    return this.shiftId;
  }

  public void setShiftId(String shiftId) {
    this.shiftId = shiftId;
  }

  public TaskResult[] getRecords() {
    return this.records;
  }

  public void setRecords(TaskResult[] records) {
    this.records = records;
  }

  public static class Builder {

    /**
     * 打卡记录 ID
     * <p> 示例值：6709359313699356941
     */
    private String resultId;
    /**
     * 用户 ID
     * <p> 示例值：abd754f7
     */
    private String userId;
    /**
     * 用户姓名
     * <p> 示例值：张三
     */
    private String employeeName;
    /**
     * 日期
     * <p> 示例值：20190819
     */
    private Integer day;
    /**
     * 考勤组 ID
     * <p> 示例值：6737202939523236110
     */
    private String groupId;
    /**
     * 班次 ID
     * <p> 示例值：6753520403404030215
     */
    private String shiftId;
    /**
     * 用户考勤记录
     * <p> 示例值：
     */
    private TaskResult[] records;

    /**
     * 打卡记录 ID
     * <p> 示例值：6709359313699356941
     *
     * @param resultId
     * @return
     */
    public Builder resultId(String resultId) {
      this.resultId = resultId;
      return this;
    }


    /**
     * 用户 ID
     * <p> 示例值：abd754f7
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 用户姓名
     * <p> 示例值：张三
     *
     * @param employeeName
     * @return
     */
    public Builder employeeName(String employeeName) {
      this.employeeName = employeeName;
      return this;
    }


    /**
     * 日期
     * <p> 示例值：20190819
     *
     * @param day
     * @return
     */
    public Builder day(Integer day) {
      this.day = day;
      return this;
    }


    /**
     * 考勤组 ID
     * <p> 示例值：6737202939523236110
     *
     * @param groupId
     * @return
     */
    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }


    /**
     * 班次 ID
     * <p> 示例值：6753520403404030215
     *
     * @param shiftId
     * @return
     */
    public Builder shiftId(String shiftId) {
      this.shiftId = shiftId;
      return this;
    }


    /**
     * 用户考勤记录
     * <p> 示例值：
     *
     * @param records
     * @return
     */
    public Builder records(TaskResult[] records) {
      this.records = records;
      return this;
    }


    public UserTask build() {
      return new UserTask(this);
    }
  }
}