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

package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class ListInstanceCommentReq {

  /**
   * 用户ID类型，不填默认为open_id
   * <p> 示例值：user_id
   */
  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  /**
   * 用户ID
   * <p> 示例值：e5286g26
   */
  @Query
  @SerializedName("user_id")
  private String userId;
  /**
   * <p> 示例值：nF1ZXJ5VGhlbkZldGNoCgAAAAAA6PZwFmUzSldvTC1yU
   */
  @Query
  @SerializedName("page_token")
  private String pageToken;
  /**
   * <p> 示例值：10
   */
  @Query
  @SerializedName("page_size")
  private Integer pageSize;
  /**
   * 审批实例code（或者租户自定义审批实例ID）
   * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
   */
  @Path
  @SerializedName("instance_id")
  private String instanceId;

  // builder 开始
  public ListInstanceCommentReq() {
  }

  public ListInstanceCommentReq(Builder builder) {
    /**
     * 用户ID类型，不填默认为open_id
     * <p> 示例值：user_id
     */
    this.userIdType = builder.userIdType;
    /**
     * 用户ID
     * <p> 示例值：e5286g26
     */
    this.userId = builder.userId;
    /**
     *
     * <p> 示例值：nF1ZXJ5VGhlbkZldGNoCgAAAAAA6PZwFmUzSldvTC1yU
     */
    this.pageToken = builder.pageToken;
    /**
     *
     * <p> 示例值：10
     */
    this.pageSize = builder.pageSize;
    /**
     * 审批实例code（或者租户自定义审批实例ID）
     * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
     */
    this.instanceId = builder.instanceId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getInstanceId() {
    return this.instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public static class Builder {

    private String userIdType; // 用户ID类型，不填默认为open_id
    private String userId; // 用户ID
    private String pageToken; //
    private Integer pageSize; //
    private String instanceId; // 审批实例code（或者租户自定义审批实例ID）

    /**
     * 用户ID类型，不填默认为open_id
     * <p> 示例值：user_id
     *
     * @param userIdType
     * @return
     */
    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    /**
     * 用户ID类型，不填默认为open_id
     * <p> 示例值：user_id
     *
     * @param userIdType {@link com.lark.oapi.service.approval.v4.enums.ListInstanceCommentUserIdTypeEnum}
     * @return
     */
    public Builder userIdType(
        com.lark.oapi.service.approval.v4.enums.ListInstanceCommentUserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    /**
     * 用户ID
     * <p> 示例值：e5286g26
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * <p> 示例值：nF1ZXJ5VGhlbkZldGNoCgAAAAAA6PZwFmUzSldvTC1yU
     *
     * @param pageToken
     * @return
     */
    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    /**
     * <p> 示例值：10
     *
     * @param pageSize
     * @return
     */
    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    /**
     * 审批实例code（或者租户自定义审批实例ID）
     * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
     *
     * @param instanceId
     * @return
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    public ListInstanceCommentReq build() {
      return new ListInstanceCommentReq(this);
    }
  }
}