// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class AnnouncementPatchReqBody {
    @SerializedName("revision")
    private String revision;
    @SerializedName("requests")
    private String[] requests;

    public String getRevision() {
        return this.revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String[] getRequests() {
        return this.requests;
    }

    public void setRequests(String[] requests) {
        this.requests = requests;
    }

}
