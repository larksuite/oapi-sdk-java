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

package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class Spreadsheet {

  /**
   * 表格标题
   * <p> 示例值：title
   */
  @SerializedName("title")
  private String title;
  /**
   * 文件夹token，获取方式见[概述](/ssl:ttdoc/ukTMukTMukTM/uUDN04SN0QjL1QDN/files/guide/introduction)
   * <p> 示例值：fldcnMsNb*****hIW9IjG1LVswg
   */
  @SerializedName("folder_token")
  private String folderToken;
  /**
   * 文档url
   * <p> 示例值：https://bytedance.feishu.cn/sheets/shtcnmBA*****yGehy8
   */
  @SerializedName("url")
  private String url;
  /**
   * 表格token
   * <p> 示例值：shtcnmBA*****yGehy8
   */
  @SerializedName("spreadsheet_token")
  private String spreadsheetToken;

  // builder 开始
  public Spreadsheet() {
  }

  public Spreadsheet(Builder builder) {
    /**
     * 表格标题
     * <p> 示例值：title
     */
    this.title = builder.title;
    /**
     * 文件夹token，获取方式见[概述](/ssl:ttdoc/ukTMukTMukTM/uUDN04SN0QjL1QDN/files/guide/introduction)
     * <p> 示例值：fldcnMsNb*****hIW9IjG1LVswg
     */
    this.folderToken = builder.folderToken;
    /**
     * 文档url
     * <p> 示例值：https://bytedance.feishu.cn/sheets/shtcnmBA*****yGehy8
     */
    this.url = builder.url;
    /**
     * 表格token
     * <p> 示例值：shtcnmBA*****yGehy8
     */
    this.spreadsheetToken = builder.spreadsheetToken;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFolderToken() {
    return this.folderToken;
  }

  public void setFolderToken(String folderToken) {
    this.folderToken = folderToken;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSpreadsheetToken() {
    return this.spreadsheetToken;
  }

  public void setSpreadsheetToken(String spreadsheetToken) {
    this.spreadsheetToken = spreadsheetToken;
  }

  public static class Builder {

    /**
     * 表格标题
     * <p> 示例值：title
     */
    private String title;
    /**
     * 文件夹token，获取方式见[概述](/ssl:ttdoc/ukTMukTMukTM/uUDN04SN0QjL1QDN/files/guide/introduction)
     * <p> 示例值：fldcnMsNb*****hIW9IjG1LVswg
     */
    private String folderToken;
    /**
     * 文档url
     * <p> 示例值：https://bytedance.feishu.cn/sheets/shtcnmBA*****yGehy8
     */
    private String url;
    /**
     * 表格token
     * <p> 示例值：shtcnmBA*****yGehy8
     */
    private String spreadsheetToken;

    /**
     * 表格标题
     * <p> 示例值：title
     *
     * @param title
     * @return
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }


    /**
     * 文件夹token，获取方式见[概述](/ssl:ttdoc/ukTMukTMukTM/uUDN04SN0QjL1QDN/files/guide/introduction)
     * <p> 示例值：fldcnMsNb*****hIW9IjG1LVswg
     *
     * @param folderToken
     * @return
     */
    public Builder folderToken(String folderToken) {
      this.folderToken = folderToken;
      return this;
    }


    /**
     * 文档url
     * <p> 示例值：https://bytedance.feishu.cn/sheets/shtcnmBA*****yGehy8
     *
     * @param url
     * @return
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }


    /**
     * 表格token
     * <p> 示例值：shtcnmBA*****yGehy8
     *
     * @param spreadsheetToken
     * @return
     */
    public Builder spreadsheetToken(String spreadsheetToken) {
      this.spreadsheetToken = spreadsheetToken;
      return this;
    }


    public Spreadsheet build() {
      return new Spreadsheet(this);
    }
  }
}