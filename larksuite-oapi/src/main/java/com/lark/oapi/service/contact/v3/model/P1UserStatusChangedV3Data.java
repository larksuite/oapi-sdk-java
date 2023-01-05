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

package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class P1UserStatusChangedV3Data {

    @SerializedName("type")
    private String type;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("employee_id")
    private String employeeId;
    @SerializedName("union_id")
    private String unionId;
    @SerializedName("before_status")
    private P1UserStatusV3 beforeStatus;
    @SerializedName("current_status")
    private P1UserStatusV3 currentStatus;
    @SerializedName("change_time")
    private String changeTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public P1UserStatusV3 getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(
            P1UserStatusV3 beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public P1UserStatusV3 getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(
            P1UserStatusV3 currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public static class P1UserStatusV3 {


        @SerializedName("is_frozen")
        private boolean isFrozen;
        @SerializedName("is_resigned")
        private boolean isResigned;
        @SerializedName("is_active")
        private boolean isActive;

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public boolean isFrozen() {
            return isFrozen;
        }

        public void setFrozen(boolean frozen) {
            isFrozen = frozen;
        }

        public boolean isResigned() {
            return isResigned;
        }

        public void setResigned(boolean resigned) {
            isResigned = resigned;
        }
    }
}
