package com.larksuite.oapi.core.event.model;

import com.google.gson.annotations.SerializedName;

public class BaseEventV2 {
    @SerializedName("schema")
    private String schema;
    @SerializedName("header")
    private Header header;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
