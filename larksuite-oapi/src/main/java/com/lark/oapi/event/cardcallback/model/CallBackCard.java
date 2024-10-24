package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class CallBackCard {
    @SerializedName("type")
    private String type;

    @SerializedName("data")
    private Object data;

    public String getType() {return this.type;}

    public void setType(String type) {this.type = type;}

    public Object getData() {return this.data;}

    public void setData(Object data) {this.data = data;}
}
