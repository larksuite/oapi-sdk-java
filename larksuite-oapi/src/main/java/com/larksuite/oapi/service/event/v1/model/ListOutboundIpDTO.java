// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.event.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListOutboundIpDTO {
    @SerializedName("ip_list")
    private String[] ipList;
    @SerializedName("page_token")
    private String pageToken;
    @SerializedName("has_more")
    private Boolean hasMore;

    public String[] getIpList() {
        return this.ipList;
    }

    public void setIpList(String[] ipList) {
        this.ipList = ipList;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

}
