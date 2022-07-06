// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("total_meeting_count")
    private Long totalMeetingCount;
    @SerializedName("total_meeting_duration")
    private Long totalMeetingDuration;
    @SerializedName("total_participant_count")
    private Long totalParticipantCount;
    @SerializedName("daily_report")
    private ReportMeetingDaily[] dailyReport;

    // builder 开始
    public Report() {
    }

    public Report(Builder builder) {
        this.totalMeetingCount = builder.totalMeetingCount;
        this.totalMeetingDuration = builder.totalMeetingDuration;
        this.totalParticipantCount = builder.totalParticipantCount;
        this.dailyReport = builder.dailyReport;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getTotalMeetingCount() {
        return this.totalMeetingCount;
    }

    public void setTotalMeetingCount(Long totalMeetingCount) {
        this.totalMeetingCount = totalMeetingCount;
    }

    public Long getTotalMeetingDuration() {
        return this.totalMeetingDuration;
    }

    public void setTotalMeetingDuration(Long totalMeetingDuration) {
        this.totalMeetingDuration = totalMeetingDuration;
    }

    public Long getTotalParticipantCount() {
        return this.totalParticipantCount;
    }

    public void setTotalParticipantCount(Long totalParticipantCount) {
        this.totalParticipantCount = totalParticipantCount;
    }

    public ReportMeetingDaily[] getDailyReport() {
        return this.dailyReport;
    }

    public void setDailyReport(ReportMeetingDaily[] dailyReport) {
        this.dailyReport = dailyReport;
    }

    public static class Builder {
        private Long totalMeetingCount;
        private Long totalMeetingDuration;
        private Long totalParticipantCount;
        private ReportMeetingDaily[] dailyReport;

        public Builder totalMeetingCount(Long totalMeetingCount) {
            this.totalMeetingCount = totalMeetingCount;
            return this;
        }

        public Builder totalMeetingDuration(Long totalMeetingDuration) {
            this.totalMeetingDuration = totalMeetingDuration;
            return this;
        }

        public Builder totalParticipantCount(Long totalParticipantCount) {
            this.totalParticipantCount = totalParticipantCount;
            return this;
        }

        public Builder dailyReport(ReportMeetingDaily[] dailyReport) {
            this.dailyReport = dailyReport;
            return this;
        }


        public Report build() {
            return new Report(this);
        }
    }
}
