package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.service.search.v2.model.CallbackAction;


public class P2CardActionTriggerData {
    @SerializedName("operator")
    private CallBackOperator operator;

    @SerializedName("token")
    private String token;

    @SerializedName("action")
    private CallbackAction action;

    @SerializedName("host")
    private String host;

    @SerializedName("delivery_type")
    private String deliveryType;

    @SerializedName("context")
    private CallBackContext context;

    public CallBackOperator getOperator() {return this.operator;}

    public void setOperator(CallBackOperator operator) {this.operator = operator;}

    public String getToken() {return this.token;}

    public void setToken(String token) {this.token = token;}

    public CallbackAction getAction() {return this.action;}

    public void setAction(CallbackAction action) {this.action = action;}

    public String getHost() {return this.host;}

    public void setHost(String host) {this.host = host;}

    public String getDeliveryType() {return this.deliveryType;}

    public void setDeliveryType(String deliveryType) {this.deliveryType = deliveryType;}

    public CallBackContext getContext() {return this.context;}

    public void setContext(CallBackContext context) {this.context = context;}
}
