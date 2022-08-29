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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class GetApplicationReq {

  /**
   * 指定获取应用在该语言下的信息
   * <p> 示例值：zh_cn
   */
  @Query
  @SerializedName("lang")
  private String lang;
  /**
   * 此次调用中使用的用户ID的类型
   * <p> 示例值：
   */
  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  /**
   * 应用的 app_id，需要查询其他应用信息时，必须申请[获取应用信息](/ssl:ttdoc/ukTMukTMukTM/uQjN3QjL0YzN04CN2cDN)权限，仅查询本应用信息时，可填入
   * "me" 或者应用自身 app_id
   * <p> 示例值：cli_9b445f5258795107
   */
  @Path
  @SerializedName("app_id")
  private String appId;

  // builder 开始
  public GetApplicationReq() {
  }

  public GetApplicationReq(Builder builder) {
    /**
     * 指定获取应用在该语言下的信息
     * <p> 示例值：zh_cn
     */
    this.lang = builder.lang;
    /**
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：
     */
    this.userIdType = builder.userIdType;
    /**
     * 应用的 app_id，需要查询其他应用信息时，必须申请[获取应用信息](/ssl:ttdoc/ukTMukTMukTM/uQjN3QjL0YzN04CN2cDN)权限，仅查询本应用信息时，可填入 "me" 或者应用自身 app_id
     * <p> 示例值：cli_9b445f5258795107
     */
    this.appId = builder.appId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getLang() {
    return this.lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public String getAppId() {
    return this.appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public static class Builder {

    private String lang; // 指定获取应用在该语言下的信息
    private String userIdType; // 此次调用中使用的用户ID的类型
    private String appId; // 应用的 app_id，需要查询其他应用信息时，必须申请[获取应用信息](/ssl:ttdoc/ukTMukTMukTM/uQjN3QjL0YzN04CN2cDN)权限，仅查询本应用信息时，可填入 "me" 或者应用自身 app_id

    /**
     * 指定获取应用在该语言下的信息
     * <p> 示例值：zh_cn
     *
     * @param lang
     * @return
     */
    public Builder lang(String lang) {
      this.lang = lang;
      return this;
    }

    /**
     * 指定获取应用在该语言下的信息
     * <p> 示例值：zh_cn
     *
     * @param lang {@link com.lark.oapi.service.application.v6.enums.GetApplicationI18nKeyEnum}
     * @return
     */
    public Builder lang(com.lark.oapi.service.application.v6.enums.GetApplicationI18nKeyEnum lang) {
      this.lang = lang.getValue();
      return this;
    }

    /**
     * 此次调用中使用的用户ID的类型
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
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：
     *
     * @param userIdType {@link com.lark.oapi.service.application.v6.enums.GetApplicationUserIdTypeEnum}
     * @return
     */
    public Builder userIdType(
        com.lark.oapi.service.application.v6.enums.GetApplicationUserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    /**
     * 应用的 app_id，需要查询其他应用信息时，必须申请[获取应用信息](/ssl:ttdoc/ukTMukTMukTM/uQjN3QjL0YzN04CN2cDN)权限，仅查询本应用信息时，可填入
     * "me" 或者应用自身 app_id
     * <p> 示例值：cli_9b445f5258795107
     *
     * @param appId
     * @return
     */
    public Builder appId(String appId) {
      this.appId = appId;
      return this;
    }

    public GetApplicationReq build() {
      return new GetApplicationReq(this);
    }
  }
}