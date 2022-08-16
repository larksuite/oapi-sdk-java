// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;
import com.google.gson.annotations.SerializedName;

public class App {
    @SerializedName("app_token")
    private String appToken;
    @SerializedName("name")
    private String name;
    @SerializedName("revision")
    private Integer revision;
    @SerializedName("folder_token")
    private String folderToken;
    @SerializedName("url")
    private String url;

    public String getAppToken() {
        return this.appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
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

}