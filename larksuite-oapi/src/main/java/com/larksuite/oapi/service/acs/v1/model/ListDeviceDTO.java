// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.acs.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListDeviceDTO {
    @SerializedName("items")
    private Device[] items;

    public Device[] getItems() {
        return this.items;
    }

    public void setItems(Device[] items) {
        this.items = items;
    }

}