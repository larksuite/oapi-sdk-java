// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.docx.v1.model;
import com.google.gson.annotations.SerializedName;

public class MentionDoc {
    @SerializedName("token")
    private String token;
    @SerializedName("obj_type")
    private Integer objType;
    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getObjType() {
        return this.objType;
    }

    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}