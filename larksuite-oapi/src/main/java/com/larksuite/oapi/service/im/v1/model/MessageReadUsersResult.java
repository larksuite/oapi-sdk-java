// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class MessageReadUsersResult {
    @SerializedName("items")
    private ReadUser[] items;
    @SerializedName("has_more")
    private Boolean hasMore;
    @SerializedName("page_token")
    private String pageToken;

    public ReadUser[] getItems() {
        return this.items;
    }

    public void setItems(ReadUser[] items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

}
