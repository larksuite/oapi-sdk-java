package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class P2URLPreviewGetData {
    @SerializedName("operator")
    private CallBackOperator operator;
    @SerializedName("host")
    private String host;
    @SerializedName("context")
    private CallBackContext context;

    public CallBackOperator getOperator() {return this.operator;}

    public void setOperator(CallBackOperator operator) {this.operator = operator;}

    public String getHost() {return this.host;}

    public void setHost(String host) {this.host = host;}

    public CallBackContext getContext() {return this.context;}

    public void setContext(CallBackContext context) {this.context = context;}
}
