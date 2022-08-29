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

package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class EventSearchFilter {

  /**
   * 搜索过滤项，日程搜索区间的开始时间，被搜索日程的事件必须与搜索区间有交集
   * <p> 示例值：
   */
  @SerializedName("start_time")
  private TimeInfo startTime;
  /**
   * 搜索过滤项，日程搜索区间的结束时间，被搜索日程的事件必须与搜索区间有交集
   * <p> 示例值：
   */
  @SerializedName("end_time")
  private TimeInfo endTime;
  /**
   * 搜索过滤项，参与人的用户ID列表，被搜索日程中必须包含至少一个其中的参与人。参见[用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
   * <p> 示例值：xxxxx
   */
  @SerializedName("user_ids")
  private String[] userIds;
  /**
   * 搜索过滤项，会议室ID列表，被搜索日程中必须包含至少一个其中的会议室
   * <p> 示例值：xxxxx
   */
  @SerializedName("room_ids")
  private String[] roomIds;
  /**
   * 搜索过滤项，群ID列表，被搜索日程的参与人中必须包含至少一个其中的群。参见[群ID 说明](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description)
   * <p> 示例值：xxxxx
   */
  @SerializedName("chat_ids")
  private String[] chatIds;

  // builder 开始
  public EventSearchFilter() {
  }

  public EventSearchFilter(Builder builder) {
    /**
     * 搜索过滤项，日程搜索区间的开始时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     */
    this.startTime = builder.startTime;
    /**
     * 搜索过滤项，日程搜索区间的结束时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     */
    this.endTime = builder.endTime;
    /**
     * 搜索过滤项，参与人的用户ID列表，被搜索日程中必须包含至少一个其中的参与人。参见[用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：xxxxx
     */
    this.userIds = builder.userIds;
    /**
     * 搜索过滤项，会议室ID列表，被搜索日程中必须包含至少一个其中的会议室
     * <p> 示例值：xxxxx
     */
    this.roomIds = builder.roomIds;
    /**
     * 搜索过滤项，群ID列表，被搜索日程的参与人中必须包含至少一个其中的群。参见[群ID 说明](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description)
     * <p> 示例值：xxxxx
     */
    this.chatIds = builder.chatIds;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public TimeInfo getStartTime() {
    return this.startTime;
  }

  public void setStartTime(TimeInfo startTime) {
    this.startTime = startTime;
  }

  public TimeInfo getEndTime() {
    return this.endTime;
  }

  public void setEndTime(TimeInfo endTime) {
    this.endTime = endTime;
  }

  public String[] getUserIds() {
    return this.userIds;
  }

  public void setUserIds(String[] userIds) {
    this.userIds = userIds;
  }

  public String[] getRoomIds() {
    return this.roomIds;
  }

  public void setRoomIds(String[] roomIds) {
    this.roomIds = roomIds;
  }

  public String[] getChatIds() {
    return this.chatIds;
  }

  public void setChatIds(String[] chatIds) {
    this.chatIds = chatIds;
  }

  public static class Builder {

    /**
     * 搜索过滤项，日程搜索区间的开始时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     */
    private TimeInfo startTime;
    /**
     * 搜索过滤项，日程搜索区间的结束时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     */
    private TimeInfo endTime;
    /**
     * 搜索过滤项，参与人的用户ID列表，被搜索日程中必须包含至少一个其中的参与人。参见[用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：xxxxx
     */
    private String[] userIds;
    /**
     * 搜索过滤项，会议室ID列表，被搜索日程中必须包含至少一个其中的会议室
     * <p> 示例值：xxxxx
     */
    private String[] roomIds;
    /**
     * 搜索过滤项，群ID列表，被搜索日程的参与人中必须包含至少一个其中的群。参见[群ID 说明](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description)
     * <p> 示例值：xxxxx
     */
    private String[] chatIds;

    /**
     * 搜索过滤项，日程搜索区间的开始时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     *
     * @param startTime
     * @return
     */
    public Builder startTime(TimeInfo startTime) {
      this.startTime = startTime;
      return this;
    }


    /**
     * 搜索过滤项，日程搜索区间的结束时间，被搜索日程的事件必须与搜索区间有交集
     * <p> 示例值：
     *
     * @param endTime
     * @return
     */
    public Builder endTime(TimeInfo endTime) {
      this.endTime = endTime;
      return this;
    }


    /**
     * 搜索过滤项，参与人的用户ID列表，被搜索日程中必须包含至少一个其中的参与人。参见[用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：xxxxx
     *
     * @param userIds
     * @return
     */
    public Builder userIds(String[] userIds) {
      this.userIds = userIds;
      return this;
    }


    /**
     * 搜索过滤项，会议室ID列表，被搜索日程中必须包含至少一个其中的会议室
     * <p> 示例值：xxxxx
     *
     * @param roomIds
     * @return
     */
    public Builder roomIds(String[] roomIds) {
      this.roomIds = roomIds;
      return this;
    }


    /**
     * 搜索过滤项，群ID列表，被搜索日程的参与人中必须包含至少一个其中的群。参见[群ID 说明](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description)
     * <p> 示例值：xxxxx
     *
     * @param chatIds
     * @return
     */
    public Builder chatIds(String[] chatIds) {
      this.chatIds = chatIds;
      return this;
    }


    public EventSearchFilter build() {
      return new EventSearchFilter(this);
    }
  }
}