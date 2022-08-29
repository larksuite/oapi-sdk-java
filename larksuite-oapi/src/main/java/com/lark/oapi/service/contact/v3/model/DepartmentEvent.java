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

package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class DepartmentEvent {

  /**
   * 部门名称
   * <p> 示例值：测试部门
   */
  @SerializedName("name")
  private String name;
  /**
   * 父部门的部门open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
   * <p> 示例值：jkfsd89782
   */
  @SerializedName("parent_department_id")
  private String parentDepartmentId;
  /**
   * 本部门的department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
   * <p> 示例值：yd7sa8yf2j
   */
  @SerializedName("department_id")
  private String departmentId;
  /**
   * 部门的open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
   * <p> 示例值：od_j10j52hjksd9g0isdfg43
   */
  @SerializedName("open_department_id")
  private String openDepartmentId;
  /**
   * 部门主管用户open_id [用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
   * <p> 示例值：ou_3j1kh45jk18fgh23hf
   */
  @SerializedName("leader_user_id")
  private String leaderUserId;
  /**
   * 部门群ID
   * <p> 示例值：oc_uiy325uy23bnv48gdf
   */
  @SerializedName("chat_id")
  private String chatId;
  /**
   * 部门的排序
   * <p> 示例值：100
   */
  @SerializedName("order")
  private Integer order;
  /**
   * 部门状态
   * <p> 示例值：
   */
  @SerializedName("status")
  private DepartmentStatus status;
  /**
   * 部门负责人
   * <p> 示例值：
   */
  @SerializedName("leaders")
  private DepartmentLeader[] leaders;

  // builder 开始
  public DepartmentEvent() {
  }

  public DepartmentEvent(Builder builder) {
    /**
     * 部门名称
     * <p> 示例值：测试部门
     */
    this.name = builder.name;
    /**
     * 父部门的部门open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：jkfsd89782
     */
    this.parentDepartmentId = builder.parentDepartmentId;
    /**
     * 本部门的department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：yd7sa8yf2j
     */
    this.departmentId = builder.departmentId;
    /**
     * 部门的open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：od_j10j52hjksd9g0isdfg43
     */
    this.openDepartmentId = builder.openDepartmentId;
    /**
     * 部门主管用户open_id [用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：ou_3j1kh45jk18fgh23hf
     */
    this.leaderUserId = builder.leaderUserId;
    /**
     * 部门群ID
     * <p> 示例值：oc_uiy325uy23bnv48gdf
     */
    this.chatId = builder.chatId;
    /**
     * 部门的排序
     * <p> 示例值：100
     */
    this.order = builder.order;
    /**
     * 部门状态
     * <p> 示例值：
     */
    this.status = builder.status;
    /**
     * 部门负责人
     * <p> 示例值：
     */
    this.leaders = builder.leaders;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentDepartmentId() {
    return this.parentDepartmentId;
  }

  public void setParentDepartmentId(String parentDepartmentId) {
    this.parentDepartmentId = parentDepartmentId;
  }

  public String getDepartmentId() {
    return this.departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getOpenDepartmentId() {
    return this.openDepartmentId;
  }

  public void setOpenDepartmentId(String openDepartmentId) {
    this.openDepartmentId = openDepartmentId;
  }

  public String getLeaderUserId() {
    return this.leaderUserId;
  }

  public void setLeaderUserId(String leaderUserId) {
    this.leaderUserId = leaderUserId;
  }

  public String getChatId() {
    return this.chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public Integer getOrder() {
    return this.order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public DepartmentStatus getStatus() {
    return this.status;
  }

  public void setStatus(DepartmentStatus status) {
    this.status = status;
  }

  public DepartmentLeader[] getLeaders() {
    return this.leaders;
  }

  public void setLeaders(DepartmentLeader[] leaders) {
    this.leaders = leaders;
  }

  public static class Builder {

    /**
     * 部门名称
     * <p> 示例值：测试部门
     */
    private String name;
    /**
     * 父部门的部门open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：jkfsd89782
     */
    private String parentDepartmentId;
    /**
     * 本部门的department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：yd7sa8yf2j
     */
    private String departmentId;
    /**
     * 部门的open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：od_j10j52hjksd9g0isdfg43
     */
    private String openDepartmentId;
    /**
     * 部门主管用户open_id [用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：ou_3j1kh45jk18fgh23hf
     */
    private String leaderUserId;
    /**
     * 部门群ID
     * <p> 示例值：oc_uiy325uy23bnv48gdf
     */
    private String chatId;
    /**
     * 部门的排序
     * <p> 示例值：100
     */
    private Integer order;
    /**
     * 部门状态
     * <p> 示例值：
     */
    private DepartmentStatus status;
    /**
     * 部门负责人
     * <p> 示例值：
     */
    private DepartmentLeader[] leaders;

    /**
     * 部门名称
     * <p> 示例值：测试部门
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 父部门的部门open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：jkfsd89782
     *
     * @param parentDepartmentId
     * @return
     */
    public Builder parentDepartmentId(String parentDepartmentId) {
      this.parentDepartmentId = parentDepartmentId;
      return this;
    }


    /**
     * 本部门的department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：yd7sa8yf2j
     *
     * @param departmentId
     * @return
     */
    public Builder departmentId(String departmentId) {
      this.departmentId = departmentId;
      return this;
    }


    /**
     * 部门的open_department_id [部门相关ID概念](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/field-overview#23857fe0)
     * <p> 示例值：od_j10j52hjksd9g0isdfg43
     *
     * @param openDepartmentId
     * @return
     */
    public Builder openDepartmentId(String openDepartmentId) {
      this.openDepartmentId = openDepartmentId;
      return this;
    }


    /**
     * 部门主管用户open_id [用户相关的 ID 概念](/ssl:ttdoc/home/user-identity-introduction/introduction)
     * <p> 示例值：ou_3j1kh45jk18fgh23hf
     *
     * @param leaderUserId
     * @return
     */
    public Builder leaderUserId(String leaderUserId) {
      this.leaderUserId = leaderUserId;
      return this;
    }


    /**
     * 部门群ID
     * <p> 示例值：oc_uiy325uy23bnv48gdf
     *
     * @param chatId
     * @return
     */
    public Builder chatId(String chatId) {
      this.chatId = chatId;
      return this;
    }


    /**
     * 部门的排序
     * <p> 示例值：100
     *
     * @param order
     * @return
     */
    public Builder order(Integer order) {
      this.order = order;
      return this;
    }


    /**
     * 部门状态
     * <p> 示例值：
     *
     * @param status
     * @return
     */
    public Builder status(DepartmentStatus status) {
      this.status = status;
      return this;
    }


    /**
     * 部门负责人
     * <p> 示例值：
     *
     * @param leaders
     * @return
     */
    public Builder leaders(DepartmentLeader[] leaders) {
      this.leaders = leaders;
      return this;
    }


    public DepartmentEvent build() {
      return new DepartmentEvent(this);
    }
  }
}