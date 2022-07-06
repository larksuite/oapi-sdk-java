package com.larksuite.oapi.core.response;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.error.Error;

import java.util.Map;

public class Body {

    public static final int ErrCodeOk = 0;
    public static final int ErrCodeAppTicketInvalid = 10012;
    public static final int ErrCodeAccessTokenInvalid = 99991671;
    public static final int ErrCodeAppAccessTokenInvalid = 99991664;
    public static final int ErrCodeTenantAccessTokenInvalid = 99991663;
    public static final int ErrCodeUserAccessTokenInvalid = 99991668;
    public static final int ErrCodeUserRefreshTokenInvalid = 99991669;

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("error")
    private Error error;
    @SerializedName("data")
    private Map<String, Object> data;

    public Body() {
    }

    public Body(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                ", data='... Omit ...'" +
                '}';
    }

    public boolean retry() {
        switch (this.code) {
            case ErrCodeAccessTokenInvalid:
            case ErrCodeAppAccessTokenInvalid:
            case ErrCodeTenantAccessTokenInvalid:
                return true;
            default:
                return false;
        }
    }


}
