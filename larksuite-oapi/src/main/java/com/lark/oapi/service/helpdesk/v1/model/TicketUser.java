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

public class TicketUser {

  /**
   * 用户ID
   * <p> 示例值：ou_37019b7c830210acd88fdce886e25c71
   */
  @SerializedName("id")
  private String id;
  /**
   * 用户头像url
   * <p> 示例值：https://xxxx
   */
  @SerializedName("avatar_url")
  private String avatarUrl;
  /**
   * 用户名
   * <p> 示例值：abc
   */
  @SerializedName("name")
  private String name;
  /**
   * 用户邮箱
   * <p> 示例值：xxxx@abc.com
   */
  @SerializedName("email")
  private String email;
  /**
   * 所在部门名称
   * <p> 示例值：用户部门名称(有权限才展示)
   */
  @SerializedName("department")
  private String department;
  /**
   * 城市
   * <p> 示例值：城市
   */
  @SerializedName("city")
  private String city;
  /**
   * 国家代号(CountryCode)，参考：http://www.mamicode.com/info-detail-2186501.html
   * <p> 示例值：国家
   */
  @SerializedName("country")
  private String country;

  // builder 开始
  public TicketUser() {
  }

  public TicketUser(Builder builder) {
    /**
     * 用户ID
     * <p> 示例值：ou_37019b7c830210acd88fdce886e25c71
     */
    this.id = builder.id;
    /**
     * 用户头像url
     * <p> 示例值：https://xxxx
     */
    this.avatarUrl = builder.avatarUrl;
    /**
     * 用户名
     * <p> 示例值：abc
     */
    this.name = builder.name;
    /**
     * 用户邮箱
     * <p> 示例值：xxxx@abc.com
     */
    this.email = builder.email;
    /**
     * 所在部门名称
     * <p> 示例值：用户部门名称(有权限才展示)
     */
    this.department = builder.department;
    /**
     * 城市
     * <p> 示例值：城市
     */
    this.city = builder.city;
    /**
     * 国家代号(CountryCode)，参考：http://www.mamicode.com/info-detail-2186501.html
     * <p> 示例值：国家
     */
    this.country = builder.country;
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

  public String getAvatarUrl() {
    return this.avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public static class Builder {

    /**
     * 用户ID
     * <p> 示例值：ou_37019b7c830210acd88fdce886e25c71
     */
    private String id;
    /**
     * 用户头像url
     * <p> 示例值：https://xxxx
     */
    private String avatarUrl;
    /**
     * 用户名
     * <p> 示例值：abc
     */
    private String name;
    /**
     * 用户邮箱
     * <p> 示例值：xxxx@abc.com
     */
    private String email;
    /**
     * 所在部门名称
     * <p> 示例值：用户部门名称(有权限才展示)
     */
    private String department;
    /**
     * 城市
     * <p> 示例值：城市
     */
    private String city;
    /**
     * 国家代号(CountryCode)，参考：http://www.mamicode.com/info-detail-2186501.html
     * <p> 示例值：国家
     */
    private String country;

    /**
     * 用户ID
     * <p> 示例值：ou_37019b7c830210acd88fdce886e25c71
     *
     * @param id
     * @return
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }


    /**
     * 用户头像url
     * <p> 示例值：https://xxxx
     *
     * @param avatarUrl
     * @return
     */
    public Builder avatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
      return this;
    }


    /**
     * 用户名
     * <p> 示例值：abc
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 用户邮箱
     * <p> 示例值：xxxx@abc.com
     *
     * @param email
     * @return
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }


    /**
     * 所在部门名称
     * <p> 示例值：用户部门名称(有权限才展示)
     *
     * @param department
     * @return
     */
    public Builder department(String department) {
      this.department = department;
      return this;
    }


    /**
     * 城市
     * <p> 示例值：城市
     *
     * @param city
     * @return
     */
    public Builder city(String city) {
      this.city = city;
      return this;
    }


    /**
     * 国家代号(CountryCode)，参考：http://www.mamicode.com/info-detail-2186501.html
     * <p> 示例值：国家
     *
     * @param country
     * @return
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }


    public TicketUser build() {
      return new TicketUser(this);
    }
  }
}