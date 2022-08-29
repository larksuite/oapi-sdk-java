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
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class GetMeetingReq {

  /**
   * 是否需要参会人列表
   * <p> 示例值：false
   */
  @Query
  @SerializedName("with_participants")
  private Boolean withParticipants;
  /**
   * 是否需要会中使用能力统计（仅限tenant_access_token）
   * <p> 示例值：false
   */
  @Query
  @SerializedName("with_meeting_ability")
  private Boolean withMeetingAbility;
  /**
   * 此次调用中使用的用户ID的类型，默认使用open_id可不填
   * <p> 示例值：
   */
  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  /**
   * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
   * <p> 示例值：6911188411932033028
   */
  @Path
  @SerializedName("meeting_id")
  private String meetingId;

  // builder 开始
  public GetMeetingReq() {
  }

  public GetMeetingReq(Builder builder) {
    /**
     * 是否需要参会人列表
     * <p> 示例值：false
     */
    this.withParticipants = builder.withParticipants;
    /**
     * 是否需要会中使用能力统计（仅限tenant_access_token）
     * <p> 示例值：false
     */
    this.withMeetingAbility = builder.withMeetingAbility;
    /**
     * 此次调用中使用的用户ID的类型，默认使用open_id可不填
     * <p> 示例值：
     */
    this.userIdType = builder.userIdType;
    /**
     * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
     * <p> 示例值：6911188411932033028
     */
    this.meetingId = builder.meetingId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Boolean getWithParticipants() {
    return this.withParticipants;
  }

  public void setWithParticipants(Boolean withParticipants) {
    this.withParticipants = withParticipants;
  }

  public Boolean getWithMeetingAbility() {
    return this.withMeetingAbility;
  }

  public void setWithMeetingAbility(Boolean withMeetingAbility) {
    this.withMeetingAbility = withMeetingAbility;
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public String getMeetingId() {
    return this.meetingId;
  }

  public void setMeetingId(String meetingId) {
    this.meetingId = meetingId;
  }

  public static class Builder {

    private Boolean withParticipants; // 是否需要参会人列表
    private Boolean withMeetingAbility; // 是否需要会中使用能力统计（仅限tenant_access_token）
    private String userIdType; // 此次调用中使用的用户ID的类型，默认使用open_id可不填
    private String meetingId; // 会议ID（视频会议的唯一标识，视频会议开始后才会产生）

    /**
     * 是否需要参会人列表
     * <p> 示例值：false
     *
     * @param withParticipants
     * @return
     */
    public Builder withParticipants(Boolean withParticipants) {
      this.withParticipants = withParticipants;
      return this;
    }

    /**
     * 是否需要会中使用能力统计（仅限tenant_access_token）
     * <p> 示例值：false
     *
     * @param withMeetingAbility
     * @return
     */
    public Builder withMeetingAbility(Boolean withMeetingAbility) {
      this.withMeetingAbility = withMeetingAbility;
      return this;
    }

    /**
     * 此次调用中使用的用户ID的类型，默认使用open_id可不填
     * <p> 示例值：
     *
     * @param userIdType
     * @return
     */
    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    /**
     * 此次调用中使用的用户ID的类型，默认使用open_id可不填
     * <p> 示例值：
     *
     * @param userIdType {@link com.lark.oapi.service.vc.v1.enums.GetMeetingUserIdTypeEnum}
     * @return
     */
    public Builder userIdType(
        com.lark.oapi.service.vc.v1.enums.GetMeetingUserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    /**
     * 会议ID（视频会议的唯一标识，视频会议开始后才会产生）
     * <p> 示例值：6911188411932033028
     *
     * @param meetingId
     * @return
     */
    public Builder meetingId(String meetingId) {
      this.meetingId = meetingId;
      return this;
    }

    public GetMeetingReq build() {
      return new GetMeetingReq(this);
    }
  }
}