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

package com.lark.oapi.service.admin.v1.model;

import com.google.gson.annotations.SerializedName;

public class AuditPcContext {

  /**
   * UDID
   * <p> 示例值：
   */
  @SerializedName("udid")
  private String udid;
  /**
   * 设备ID
   * <p> 示例值：
   */
  @SerializedName("did")
  private String did;
  /**
   * app的版本
   * <p> 示例值：
   */
  @SerializedName("app_ver")
  private String appVer;
  /**
   * SecSDK版本
   * <p> 示例值：
   */
  @SerializedName("ver")
  private String ver;
  /**
   * 客户端类型
   * <p> 示例值：
   */
  @SerializedName("os")
  private String os;
  /**
   * wifi ip
   * <p> 示例值：
   */
  @SerializedName("wifip")
  private String wifip;
  /**
   * 设备区域
   * <p> 示例值：
   */
  @SerializedName("region")
  private String region;
  /**
   * 公网ip
   * <p> 示例值：
   */
  @SerializedName("IP")
  private String iP;

  // builder 开始
  public AuditPcContext() {
  }

  public AuditPcContext(Builder builder) {
    /**
     * UDID
     * <p> 示例值：
     */
    this.udid = builder.udid;
    /**
     * 设备ID
     * <p> 示例值：
     */
    this.did = builder.did;
    /**
     * app的版本
     * <p> 示例值：
     */
    this.appVer = builder.appVer;
    /**
     * SecSDK版本
     * <p> 示例值：
     */
    this.ver = builder.ver;
    /**
     * 客户端类型
     * <p> 示例值：
     */
    this.os = builder.os;
    /**
     * wifi ip
     * <p> 示例值：
     */
    this.wifip = builder.wifip;
    /**
     * 设备区域
     * <p> 示例值：
     */
    this.region = builder.region;
    /**
     * 公网ip
     * <p> 示例值：
     */
    this.iP = builder.iP;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUdid() {
    return this.udid;
  }

  public void setUdid(String udid) {
    this.udid = udid;
  }

  public String getDid() {
    return this.did;
  }

  public void setDid(String did) {
    this.did = did;
  }

  public String getAppVer() {
    return this.appVer;
  }

  public void setAppVer(String appVer) {
    this.appVer = appVer;
  }

  public String getVer() {
    return this.ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public String getOs() {
    return this.os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getWifip() {
    return this.wifip;
  }

  public void setWifip(String wifip) {
    this.wifip = wifip;
  }

  public String getRegion() {
    return this.region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getIP() {
    return this.iP;
  }

  public void setIP(String iP) {
    this.iP = iP;
  }

  public static class Builder {

    /**
     * UDID
     * <p> 示例值：
     */
    private String udid;
    /**
     * 设备ID
     * <p> 示例值：
     */
    private String did;
    /**
     * app的版本
     * <p> 示例值：
     */
    private String appVer;
    /**
     * SecSDK版本
     * <p> 示例值：
     */
    private String ver;
    /**
     * 客户端类型
     * <p> 示例值：
     */
    private String os;
    /**
     * wifi ip
     * <p> 示例值：
     */
    private String wifip;
    /**
     * 设备区域
     * <p> 示例值：
     */
    private String region;
    /**
     * 公网ip
     * <p> 示例值：
     */
    private String iP;

    /**
     * UDID
     * <p> 示例值：
     *
     * @param udid
     * @return
     */
    public Builder udid(String udid) {
      this.udid = udid;
      return this;
    }


    /**
     * 设备ID
     * <p> 示例值：
     *
     * @param did
     * @return
     */
    public Builder did(String did) {
      this.did = did;
      return this;
    }


    /**
     * app的版本
     * <p> 示例值：
     *
     * @param appVer
     * @return
     */
    public Builder appVer(String appVer) {
      this.appVer = appVer;
      return this;
    }


    /**
     * SecSDK版本
     * <p> 示例值：
     *
     * @param ver
     * @return
     */
    public Builder ver(String ver) {
      this.ver = ver;
      return this;
    }


    /**
     * 客户端类型
     * <p> 示例值：
     *
     * @param os
     * @return
     */
    public Builder os(String os) {
      this.os = os;
      return this;
    }


    /**
     * wifi ip
     * <p> 示例值：
     *
     * @param wifip
     * @return
     */
    public Builder wifip(String wifip) {
      this.wifip = wifip;
      return this;
    }


    /**
     * 设备区域
     * <p> 示例值：
     *
     * @param region
     * @return
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }


    /**
     * 公网ip
     * <p> 示例值：
     *
     * @param iP
     * @return
     */
    public Builder iP(String iP) {
      this.iP = iP;
      return this;
    }


    public AuditPcContext build() {
      return new AuditPcContext(this);
    }
  }
}