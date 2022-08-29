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

package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class MeetingEventMeeting {

  /**
   * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
   * <p> 示例值：6911188411934433028
   */
  @SerializedName("id")
  private String id;
  /**
   * 会议主题
   * <p> 示例值：my meeting
   */
  @SerializedName("topic")
  private String topic;
  /**
   * 9位会议号（飞书用户可通过输入9位会议号快捷入会）
   * <p> 示例值：235812466
   */
  @SerializedName("meeting_no")
  private String meetingNo;
  /**
   * 会议开始时间（unix时间，单位sec）
   * <p> 示例值：1608883322
   */
  @SerializedName("start_time")
  private String startTime;
  /**
   * 会议结束时间（unix时间，单位sec）
   * <p> 示例值：1608883899
   */
  @SerializedName("end_time")
  private String endTime;
  /**
   * 会议主持人
   * <p> 示例值：
   */
  @SerializedName("host_user")
  private MeetingEventUser hostUser;
  /**
   * 会议拥有者
   * <p> 示例值：
   */
  @SerializedName("owner")
  private MeetingEventUser owner;

  // builder 开始
  public MeetingEventMeeting() {
  }

  public MeetingEventMeeting(Builder builder) {
    /**
     * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
     * <p> 示例值：6911188411934433028
     */
    this.id = builder.id;
    /**
     * 会议主题
     * <p> 示例值：my meeting
     */
    this.topic = builder.topic;
    /**
     * 9位会议号（飞书用户可通过输入9位会议号快捷入会）
     * <p> 示例值：235812466
     */
    this.meetingNo = builder.meetingNo;
    /**
     * 会议开始时间（unix时间，单位sec）
     * <p> 示例值：1608883322
     */
    this.startTime = builder.startTime;
    /**
     * 会议结束时间（unix时间，单位sec）
     * <p> 示例值：1608883899
     */
    this.endTime = builder.endTime;
    /**
     * 会议主持人
     * <p> 示例值：
     */
    this.hostUser = builder.hostUser;
    /**
     * 会议拥有者
     * <p> 示例值：
     */
    this.owner = builder.owner;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTopic() {
    return this.topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getMeetingNo() {
    return this.meetingNo;
  }

  public void setMeetingNo(String meetingNo) {
    this.meetingNo = meetingNo;
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

  public MeetingEventUser getHostUser() {
    return this.hostUser;
  }

  public void setHostUser(MeetingEventUser hostUser) {
    this.hostUser = hostUser;
  }

  public MeetingEventUser getOwner() {
    return this.owner;
  }

  public void setOwner(MeetingEventUser owner) {
    this.owner = owner;
  }

  public static class Builder {

    /**
     * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
     * <p> 示例值：6911188411934433028
     */
    private String id;
    /**
     * 会议主题
     * <p> 示例值：my meeting
     */
    private String topic;
    /**
     * 9位会议号（飞书用户可通过输入9位会议号快捷入会）
     * <p> 示例值：235812466
     */
    private String meetingNo;
    /**
     * 会议开始时间（unix时间，单位sec）
     * <p> 示例值：1608883322
     */
    private String startTime;
    /**
     * 会议结束时间（unix时间，单位sec）
     * <p> 示例值：1608883899
     */
    private String endTime;
    /**
     * 会议主持人
     * <p> 示例值：
     */
    private MeetingEventUser hostUser;
    /**
     * 会议拥有者
     * <p> 示例值：
     */
    private MeetingEventUser owner;

    /**
     * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
     * <p> 示例值：6911188411934433028
     *
     * @param id
     * @return
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }


    /**
     * 会议主题
     * <p> 示例值：my meeting
     *
     * @param topic
     * @return
     */
    public Builder topic(String topic) {
      this.topic = topic;
      return this;
    }


    /**
     * 9位会议号（飞书用户可通过输入9位会议号快捷入会）
     * <p> 示例值：235812466
     *
     * @param meetingNo
     * @return
     */
    public Builder meetingNo(String meetingNo) {
      this.meetingNo = meetingNo;
      return this;
    }


    /**
     * 会议开始时间（unix时间，单位sec）
     * <p> 示例值：1608883322
     *
     * @param startTime
     * @return
     */
    public Builder startTime(String startTime) {
      this.startTime = startTime;
      return this;
    }


    /**
     * 会议结束时间（unix时间，单位sec）
     * <p> 示例值：1608883899
     *
     * @param endTime
     * @return
     */
    public Builder endTime(String endTime) {
      this.endTime = endTime;
      return this;
    }


    /**
     * 会议主持人
     * <p> 示例值：
     *
     * @param hostUser
     * @return
     */
    public Builder hostUser(MeetingEventUser hostUser) {
      this.hostUser = hostUser;
      return this;
    }


    /**
     * 会议拥有者
     * <p> 示例值：
     *
     * @param owner
     * @return
     */
    public Builder owner(MeetingEventUser owner) {
      this.owner = owner;
      return this;
    }


    public MeetingEventMeeting build() {
      return new MeetingEventMeeting(this);
    }
  }
}