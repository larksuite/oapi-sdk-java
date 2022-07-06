package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public abstract class MessagePostElement {
    @SerializedName("tag")
    protected String tag;

    abstract String getTag();
}
