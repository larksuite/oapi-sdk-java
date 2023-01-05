/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.response;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.error.Error;

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
