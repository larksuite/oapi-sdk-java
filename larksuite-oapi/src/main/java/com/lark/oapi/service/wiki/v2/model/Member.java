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

package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;

public class Member {

  /**
   * “openchat” - 群id ;;“userid” - 用户id;;“email” - 邮箱;;“opendepartmentid” - 部门id;;“openid” -
   * 应用openid;;“unionid” - unionid
   * <p> 示例值：userid
   */
  @SerializedName("member_type")
  private String memberType;
  /**
   * 用户id
   * <p> 示例值：1565676577122621
   */
  @SerializedName("member_id")
  private String memberId;
  /**
   * 角色:;;“admin” - 管理员;;“member” - 成员
   * <p> 示例值：admin
   */
  @SerializedName("member_role")
  private String memberRole;

  // builder 开始
  public Member() {
  }

  public Member(Builder builder) {
    /**
     * “openchat” - 群id ;;“userid” - 用户id;;“email” - 邮箱;;“opendepartmentid” - 部门id;;“openid” - 应用openid;;“unionid” - unionid
     * <p> 示例值：userid
     */
    this.memberType = builder.memberType;
    /**
     * 用户id
     * <p> 示例值：1565676577122621
     */
    this.memberId = builder.memberId;
    /**
     * 角色:;;“admin” - 管理员;;“member” - 成员
     * <p> 示例值：admin
     */
    this.memberRole = builder.memberRole;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getMemberType() {
    return this.memberType;
  }

  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }

  public String getMemberId() {
    return this.memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberRole() {
    return this.memberRole;
  }

  public void setMemberRole(String memberRole) {
    this.memberRole = memberRole;
  }

  public static class Builder {

    /**
     * “openchat” - 群id ;;“userid” - 用户id;;“email” - 邮箱;;“opendepartmentid” - 部门id;;“openid” -
     * 应用openid;;“unionid” - unionid
     * <p> 示例值：userid
     */
    private String memberType;
    /**
     * 用户id
     * <p> 示例值：1565676577122621
     */
    private String memberId;
    /**
     * 角色:;;“admin” - 管理员;;“member” - 成员
     * <p> 示例值：admin
     */
    private String memberRole;

    /**
     * “openchat” - 群id ;;“userid” - 用户id;;“email” - 邮箱;;“opendepartmentid” - 部门id;;“openid” -
     * 应用openid;;“unionid” - unionid
     * <p> 示例值：userid
     *
     * @param memberType
     * @return
     */
    public Builder memberType(String memberType) {
      this.memberType = memberType;
      return this;
    }


    /**
     * 用户id
     * <p> 示例值：1565676577122621
     *
     * @param memberId
     * @return
     */
    public Builder memberId(String memberId) {
      this.memberId = memberId;
      return this;
    }


    /**
     * 角色:;;“admin” - 管理员;;“member” - 成员
     * <p> 示例值：admin
     *
     * @param memberRole
     * @return
     */
    public Builder memberRole(String memberRole) {
      this.memberRole = memberRole;
      return this;
    }


    public Member build() {
      return new Member(this);
    }
  }
}