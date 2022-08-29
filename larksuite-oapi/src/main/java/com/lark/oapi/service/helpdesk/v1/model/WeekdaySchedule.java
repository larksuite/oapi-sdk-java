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

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class WeekdaySchedule {

  /**
   * 开始时间, format 00:00 - 23:59
   * <p> 示例值：00:00
   */
  @SerializedName("start_time")
  private String startTime;
  /**
   * 结束时间, format 00:00 - 23:59
   * <p> 示例值：24:00
   */
  @SerializedName("end_time")
  private String endTime;
  /**
   * 星期几, 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 -
   * Sunday, 9 - Everday, 10 - Weekday, 11 - Weekend
   * <p> 示例值：9
   */
  @SerializedName("weekday")
  private Integer weekday;

  // builder 开始
  public WeekdaySchedule() {
  }

  public WeekdaySchedule(Builder builder) {
    /**
     * 开始时间, format 00:00 - 23:59
     * <p> 示例值：00:00
     */
    this.startTime = builder.startTime;
    /**
     * 结束时间, format 00:00 - 23:59
     * <p> 示例值：24:00
     */
    this.endTime = builder.endTime;
    /**
     * 星期几, 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday, 9 - Everday, 10 - Weekday, 11 - Weekend
     * <p> 示例值：9
     */
    this.weekday = builder.weekday;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getStartTime() {
    return this.startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return this.endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Integer getWeekday() {
    return this.weekday;
  }

  public void setWeekday(Integer weekday) {
    this.weekday = weekday;
  }

  public static class Builder {

    /**
     * 开始时间, format 00:00 - 23:59
     * <p> 示例值：00:00
     */
    private String startTime;
    /**
     * 结束时间, format 00:00 - 23:59
     * <p> 示例值：24:00
     */
    private String endTime;
    /**
     * 星期几, 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 -
     * Sunday, 9 - Everday, 10 - Weekday, 11 - Weekend
     * <p> 示例值：9
     */
    private Integer weekday;

    /**
     * 开始时间, format 00:00 - 23:59
     * <p> 示例值：00:00
     *
     * @param startTime
     * @return
     */
    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }


    /**
     * 结束时间, format 00:00 - 23:59
     * <p> 示例值：24:00
     *
     * @param endTime
     * @return
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }


    /**
     * 星期几, 1 - Monday, 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 -
     * Sunday, 9 - Everday, 10 - Weekday, 11 - Weekend
     * <p> 示例值：9
     *
     * @param weekday
     * @return
     */
    public Builder weekday(Integer weekday) {
      this.weekday = weekday;
      return this;
    }


    public WeekdaySchedule build() {
      return new WeekdaySchedule(this);
    }
  }
}