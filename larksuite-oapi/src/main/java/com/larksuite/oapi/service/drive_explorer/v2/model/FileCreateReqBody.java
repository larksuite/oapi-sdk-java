// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive_explorer.v2.model;
import com.google.gson.annotations.SerializedName;

public class FileCreateReqBody {
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
