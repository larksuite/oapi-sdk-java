// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.hire.v1.model;

import com.google.gson.annotations.SerializedName;

public class InterviewAppointmentConfigContent {
    /**
     * 面试类型
     * <p> 示例值：1
     */
    @SerializedName("interview_type")
    private Integer interviewType;
    /**
     * 时区
     * <p> 示例值：Asia/Shanghai
     */
    @SerializedName("talent_timezone_code")
    private String talentTimezoneCode;
    /**
     * 联系人id
     * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
     */
    @SerializedName("contact_user_id")
    private String contactUserId;
    /**
     * 联系人电话
     * <p> 示例值：151********
     */
    @SerializedName("contact_mobile")
    private String contactMobile;
    /**
     * 联系人邮箱
     * <p> 示例值：test@email
     */
    @SerializedName("contact_email")
    private String contactEmail;
    /**
     * 地址id
     * <p> 示例值：6960663240925956576
     */
    @SerializedName("address_id")
    private String addressId;
    /**
     * 地址id
     * <p> 示例值：1
     */
    @SerializedName("video_type")
    private Integer videoType;
    /**
     * 抄送人id lsit
     * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
     */
    @SerializedName("cc")
    private String[] cc;
    /**
     * 备注
     * <p> 示例值：备注
     */
    @SerializedName("remark")
    private String remark;
    /**
     * 面试通知模板
     * <p> 示例值：6960663240925956573
     */
    @SerializedName("interview_notification_template_id")
    private String interviewNotificationTemplateId;
    /**
     * 预约通知模板
     * <p> 示例值：6960663240925956573
     */
    @SerializedName("appointment_notification_template_id")
    private String appointmentNotificationTemplateId;
    /**
     * 取消面试通知
     * <p> 示例值：6960663240925956573
     */
    @SerializedName("cancel_interview_notification_template_id")
    private String cancelInterviewNotificationTemplateId;

    // builder 开始
    public InterviewAppointmentConfigContent() {
    }

    public InterviewAppointmentConfigContent(Builder builder) {
        /**
         * 面试类型
         * <p> 示例值：1
         */
        this.interviewType = builder.interviewType;
        /**
         * 时区
         * <p> 示例值：Asia/Shanghai
         */
        this.talentTimezoneCode = builder.talentTimezoneCode;
        /**
         * 联系人id
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         */
        this.contactUserId = builder.contactUserId;
        /**
         * 联系人电话
         * <p> 示例值：151********
         */
        this.contactMobile = builder.contactMobile;
        /**
         * 联系人邮箱
         * <p> 示例值：test@email
         */
        this.contactEmail = builder.contactEmail;
        /**
         * 地址id
         * <p> 示例值：6960663240925956576
         */
        this.addressId = builder.addressId;
        /**
         * 地址id
         * <p> 示例值：1
         */
        this.videoType = builder.videoType;
        /**
         * 抄送人id lsit
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         */
        this.cc = builder.cc;
        /**
         * 备注
         * <p> 示例值：备注
         */
        this.remark = builder.remark;
        /**
         * 面试通知模板
         * <p> 示例值：6960663240925956573
         */
        this.interviewNotificationTemplateId = builder.interviewNotificationTemplateId;
        /**
         * 预约通知模板
         * <p> 示例值：6960663240925956573
         */
        this.appointmentNotificationTemplateId = builder.appointmentNotificationTemplateId;
        /**
         * 取消面试通知
         * <p> 示例值：6960663240925956573
         */
        this.cancelInterviewNotificationTemplateId = builder.cancelInterviewNotificationTemplateId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getInterviewType() {
        return this.interviewType;
    }

    public void setInterviewType(Integer interviewType) {
        this.interviewType = interviewType;
    }

    public String getTalentTimezoneCode() {
        return this.talentTimezoneCode;
    }

    public void setTalentTimezoneCode(String talentTimezoneCode) {
        this.talentTimezoneCode = talentTimezoneCode;
    }

    public String getContactUserId() {
        return this.contactUserId;
    }

    public void setContactUserId(String contactUserId) {
        this.contactUserId = contactUserId;
    }

    public String getContactMobile() {
        return this.contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getVideoType() {
        return this.videoType;
    }

    public void setVideoType(Integer videoType) {
        this.videoType = videoType;
    }

    public String[] getCc() {
        return this.cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInterviewNotificationTemplateId() {
        return this.interviewNotificationTemplateId;
    }

    public void setInterviewNotificationTemplateId(String interviewNotificationTemplateId) {
        this.interviewNotificationTemplateId = interviewNotificationTemplateId;
    }

    public String getAppointmentNotificationTemplateId() {
        return this.appointmentNotificationTemplateId;
    }

    public void setAppointmentNotificationTemplateId(String appointmentNotificationTemplateId) {
        this.appointmentNotificationTemplateId = appointmentNotificationTemplateId;
    }

    public String getCancelInterviewNotificationTemplateId() {
        return this.cancelInterviewNotificationTemplateId;
    }

    public void setCancelInterviewNotificationTemplateId(String cancelInterviewNotificationTemplateId) {
        this.cancelInterviewNotificationTemplateId = cancelInterviewNotificationTemplateId;
    }

    public static class Builder {
        /**
         * 面试类型
         * <p> 示例值：1
         */
        private Integer interviewType;
        /**
         * 时区
         * <p> 示例值：Asia/Shanghai
         */
        private String talentTimezoneCode;
        /**
         * 联系人id
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         */
        private String contactUserId;
        /**
         * 联系人电话
         * <p> 示例值：151********
         */
        private String contactMobile;
        /**
         * 联系人邮箱
         * <p> 示例值：test@email
         */
        private String contactEmail;
        /**
         * 地址id
         * <p> 示例值：6960663240925956576
         */
        private String addressId;
        /**
         * 地址id
         * <p> 示例值：1
         */
        private Integer videoType;
        /**
         * 抄送人id lsit
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         */
        private String[] cc;
        /**
         * 备注
         * <p> 示例值：备注
         */
        private String remark;
        /**
         * 面试通知模板
         * <p> 示例值：6960663240925956573
         */
        private String interviewNotificationTemplateId;
        /**
         * 预约通知模板
         * <p> 示例值：6960663240925956573
         */
        private String appointmentNotificationTemplateId;
        /**
         * 取消面试通知
         * <p> 示例值：6960663240925956573
         */
        private String cancelInterviewNotificationTemplateId;

        /**
         * 面试类型
         * <p> 示例值：1
         *
         * @param interviewType
         * @return
         */
        public Builder interviewType(Integer interviewType) {
            this.interviewType = interviewType;
            return this;
        }


        /**
         * 时区
         * <p> 示例值：Asia/Shanghai
         *
         * @param talentTimezoneCode
         * @return
         */
        public Builder talentTimezoneCode(String talentTimezoneCode) {
            this.talentTimezoneCode = talentTimezoneCode;
            return this;
        }


        /**
         * 联系人id
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         *
         * @param contactUserId
         * @return
         */
        public Builder contactUserId(String contactUserId) {
            this.contactUserId = contactUserId;
            return this;
        }


        /**
         * 联系人电话
         * <p> 示例值：151********
         *
         * @param contactMobile
         * @return
         */
        public Builder contactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
            return this;
        }


        /**
         * 联系人邮箱
         * <p> 示例值：test@email
         *
         * @param contactEmail
         * @return
         */
        public Builder contactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }


        /**
         * 地址id
         * <p> 示例值：6960663240925956576
         *
         * @param addressId
         * @return
         */
        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }


        /**
         * 地址id
         * <p> 示例值：1
         *
         * @param videoType
         * @return
         */
        public Builder videoType(Integer videoType) {
            this.videoType = videoType;
            return this;
        }


        /**
         * 抄送人id lsit
         * <p> 示例值：ou_c99c5f35d542efc7ee492afe11af19ef
         *
         * @param cc
         * @return
         */
        public Builder cc(String[] cc) {
            this.cc = cc;
            return this;
        }


        /**
         * 备注
         * <p> 示例值：备注
         *
         * @param remark
         * @return
         */
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }


        /**
         * 面试通知模板
         * <p> 示例值：6960663240925956573
         *
         * @param interviewNotificationTemplateId
         * @return
         */
        public Builder interviewNotificationTemplateId(String interviewNotificationTemplateId) {
            this.interviewNotificationTemplateId = interviewNotificationTemplateId;
            return this;
        }


        /**
         * 预约通知模板
         * <p> 示例值：6960663240925956573
         *
         * @param appointmentNotificationTemplateId
         * @return
         */
        public Builder appointmentNotificationTemplateId(String appointmentNotificationTemplateId) {
            this.appointmentNotificationTemplateId = appointmentNotificationTemplateId;
            return this;
        }


        /**
         * 取消面试通知
         * <p> 示例值：6960663240925956573
         *
         * @param cancelInterviewNotificationTemplateId
         * @return
         */
        public Builder cancelInterviewNotificationTemplateId(String cancelInterviewNotificationTemplateId) {
            this.cancelInterviewNotificationTemplateId = cancelInterviewNotificationTemplateId;
            return this;
        }


        public InterviewAppointmentConfigContent build() {
            return new InterviewAppointmentConfigContent(this);
        }
    }
}