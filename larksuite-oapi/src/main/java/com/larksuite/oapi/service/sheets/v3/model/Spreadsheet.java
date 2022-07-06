// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class Spreadsheet {
    @SerializedName("title")
    private String title;
    @SerializedName("folder_token")
    private String folderToken;
    @SerializedName("url")
    private String url;
    @SerializedName("spreadsheet_token")
    private String spreadsheetToken;

    // builder 开始
    public Spreadsheet() {
    }

    public Spreadsheet(Builder builder) {
        this.title = builder.title;
        this.folderToken = builder.folderToken;
        this.url = builder.url;
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
        private String title;
        private String folderToken;
        private String url;
        private String spreadsheetToken;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder folderToken(String folderToken) {
            this.folderToken = folderToken;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder spreadsheetToken(String spreadsheetToken) {
            this.spreadsheetToken = spreadsheetToken;
            return this;
        }


        public Spreadsheet build() {
            return new Spreadsheet(this);
        }
    }
}