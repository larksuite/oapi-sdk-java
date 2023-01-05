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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class P1AppOpenV6Data {

    @SerializedName("type")
    private String type;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("applicants")
    private P1AppOpenApplicantV6[] applicants;
    @SerializedName("installer")
    private P1AppOpenInstallerV6 installer;
    @SerializedName("installer_employee")
    private P1AppOpenInstallerEmployeeV6 installerEmployee;

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

    public P1AppOpenApplicantV6[] getApplicants() {
        return applicants;
    }

    public void setApplicants(
            P1AppOpenApplicantV6[] applicants) {
        this.applicants = applicants;
    }

    public P1AppOpenInstallerV6 getInstaller() {
        return installer;
    }

    public void setInstaller(
            P1AppOpenInstallerV6 installer) {
        this.installer = installer;
    }

    public P1AppOpenInstallerEmployeeV6 getInstallerEmployee() {
        return installerEmployee;
    }

    public void setInstallerEmployee(
            P1AppOpenInstallerEmployeeV6 installerEmployee) {
        this.installerEmployee = installerEmployee;
    }

    public static class P1AppOpenApplicantV6 {

        @SerializedName("open_id")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    public static class P1AppOpenInstallerV6 {

        @SerializedName("open_id")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    public static class P1AppOpenInstallerEmployeeV6 {

        @SerializedName("open_id")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

}
