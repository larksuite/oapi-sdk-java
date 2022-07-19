// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class GetGroup {

  @SerializedName("group_id")
  private String groupId;
  @SerializedName("group_name")
  private String groupName;
  @SerializedName("time_zone")
  private String timeZone;
  @SerializedName("bind_dept_ids")
  private String[] bindDeptIds;
  @SerializedName("except_dept_ids")
  private String[] exceptDeptIds;
  @SerializedName("bind_user_ids")
  private String[] bindUserIds;
  @SerializedName("except_user_ids")
  private String[] exceptUserIds;
  @SerializedName("group_leader_ids")
  private String[] groupLeaderIds;
  @SerializedName("allow_out_punch")
  private Boolean allowOutPunch;
  @SerializedName("allow_pc_punch")
  private Boolean allowPcPunch;
  @SerializedName("allow_remedy")
  private Boolean allowRemedy;
  @SerializedName("remedy_limit")
  private Boolean remedyLimit;
  @SerializedName("remedy_limit_count")
  private Integer remedyLimitCount;
  @SerializedName("remedy_date_limit")
  private Boolean remedyDateLimit;
  @SerializedName("remedy_date_num")
  private Integer remedyDateNum;
  @SerializedName("show_cumulative_time")
  private Boolean showCumulativeTime;
  @SerializedName("show_over_time")
  private Boolean showOverTime;
  @SerializedName("hide_staff_punch_time")
  private Boolean hideStaffPunchTime;
  @SerializedName("face_punch")
  private Boolean facePunch;
  @SerializedName("face_punch_cfg")
  private Integer facePunchCfg;
  @SerializedName("face_downgrade")
  private Boolean faceDowngrade;
  @SerializedName("replace_basic_pic")
  private Boolean replaceBasicPic;
  @SerializedName("machines")
  private Machine[] machines;
  @SerializedName("gps_range")
  private Integer gpsRange;
  @SerializedName("locations")
  private Location[] locations;
  @SerializedName("group_type")
  private Integer groupType;
  @SerializedName("punch_day_shift_ids")
  private String[] punchDayShiftIds;
  @SerializedName("free_punch_cfg")
  private FreePunchCfg freePunchCfg;
  @SerializedName("calendar_id")
  private Integer calendarId;
  @SerializedName("need_punch_special_days")
  private PunchSpecialDateShift[] needPunchSpecialDays;
  @SerializedName("no_need_punch_special_days")
  private PunchSpecialDateShift[] noNeedPunchSpecialDays;
  @SerializedName("work_day_no_punch_as_lack")
  private Boolean workDayNoPunchAsLack;
  @SerializedName("effect_now")
  private Boolean effectNow;
  @SerializedName("remedy_period_type")
  private Integer remedyPeriodType;
  @SerializedName("remedy_period_custom_date")
  private Integer remedyPeriodCustomDate;
  @SerializedName("punch_type")
  private Integer punchType;

  public String getGroupId() {
    return this.groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return this.groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getTimeZone() {
    return this.timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public String[] getBindDeptIds() {
    return this.bindDeptIds;
  }

  public void setBindDeptIds(String[] bindDeptIds) {
    this.bindDeptIds = bindDeptIds;
  }

  public String[] getExceptDeptIds() {
    return this.exceptDeptIds;
  }

  public void setExceptDeptIds(String[] exceptDeptIds) {
    this.exceptDeptIds = exceptDeptIds;
  }

  public String[] getBindUserIds() {
    return this.bindUserIds;
  }

  public void setBindUserIds(String[] bindUserIds) {
    this.bindUserIds = bindUserIds;
  }

  public String[] getExceptUserIds() {
    return this.exceptUserIds;
  }

  public void setExceptUserIds(String[] exceptUserIds) {
    this.exceptUserIds = exceptUserIds;
  }

  public String[] getGroupLeaderIds() {
    return this.groupLeaderIds;
  }

  public void setGroupLeaderIds(String[] groupLeaderIds) {
    this.groupLeaderIds = groupLeaderIds;
  }

  public Boolean getAllowOutPunch() {
    return this.allowOutPunch;
  }

  public void setAllowOutPunch(Boolean allowOutPunch) {
    this.allowOutPunch = allowOutPunch;
  }

  public Boolean getAllowPcPunch() {
    return this.allowPcPunch;
  }

  public void setAllowPcPunch(Boolean allowPcPunch) {
    this.allowPcPunch = allowPcPunch;
  }

  public Boolean getAllowRemedy() {
    return this.allowRemedy;
  }

  public void setAllowRemedy(Boolean allowRemedy) {
    this.allowRemedy = allowRemedy;
  }

  public Boolean getRemedyLimit() {
    return this.remedyLimit;
  }

  public void setRemedyLimit(Boolean remedyLimit) {
    this.remedyLimit = remedyLimit;
  }

  public Integer getRemedyLimitCount() {
    return this.remedyLimitCount;
  }

  public void setRemedyLimitCount(Integer remedyLimitCount) {
    this.remedyLimitCount = remedyLimitCount;
  }

  public Boolean getRemedyDateLimit() {
    return this.remedyDateLimit;
  }

  public void setRemedyDateLimit(Boolean remedyDateLimit) {
    this.remedyDateLimit = remedyDateLimit;
  }

  public Integer getRemedyDateNum() {
    return this.remedyDateNum;
  }

  public void setRemedyDateNum(Integer remedyDateNum) {
    this.remedyDateNum = remedyDateNum;
  }

  public Boolean getShowCumulativeTime() {
    return this.showCumulativeTime;
  }

  public void setShowCumulativeTime(Boolean showCumulativeTime) {
    this.showCumulativeTime = showCumulativeTime;
  }

  public Boolean getShowOverTime() {
    return this.showOverTime;
  }

  public void setShowOverTime(Boolean showOverTime) {
    this.showOverTime = showOverTime;
  }

  public Boolean getHideStaffPunchTime() {
    return this.hideStaffPunchTime;
  }

  public void setHideStaffPunchTime(Boolean hideStaffPunchTime) {
    this.hideStaffPunchTime = hideStaffPunchTime;
  }

  public Boolean getFacePunch() {
    return this.facePunch;
  }

  public void setFacePunch(Boolean facePunch) {
    this.facePunch = facePunch;
  }

  public Integer getFacePunchCfg() {
    return this.facePunchCfg;
  }

  public void setFacePunchCfg(Integer facePunchCfg) {
    this.facePunchCfg = facePunchCfg;
  }

  public Boolean getFaceDowngrade() {
    return this.faceDowngrade;
  }

  public void setFaceDowngrade(Boolean faceDowngrade) {
    this.faceDowngrade = faceDowngrade;
  }

  public Boolean getReplaceBasicPic() {
    return this.replaceBasicPic;
  }

  public void setReplaceBasicPic(Boolean replaceBasicPic) {
    this.replaceBasicPic = replaceBasicPic;
  }

  public Machine[] getMachines() {
    return this.machines;
  }

  public void setMachines(Machine[] machines) {
    this.machines = machines;
  }

  public Integer getGpsRange() {
    return this.gpsRange;
  }

  public void setGpsRange(Integer gpsRange) {
    this.gpsRange = gpsRange;
  }

  public Location[] getLocations() {
    return this.locations;
  }

  public void setLocations(Location[] locations) {
    this.locations = locations;
  }

  public Integer getGroupType() {
    return this.groupType;
  }

  public void setGroupType(Integer groupType) {
    this.groupType = groupType;
  }

  public String[] getPunchDayShiftIds() {
    return this.punchDayShiftIds;
  }

  public void setPunchDayShiftIds(String[] punchDayShiftIds) {
    this.punchDayShiftIds = punchDayShiftIds;
  }

  public FreePunchCfg getFreePunchCfg() {
    return this.freePunchCfg;
  }

  public void setFreePunchCfg(FreePunchCfg freePunchCfg) {
    this.freePunchCfg = freePunchCfg;
  }

  public Integer getCalendarId() {
    return this.calendarId;
  }

  public void setCalendarId(Integer calendarId) {
    this.calendarId = calendarId;
  }

  public PunchSpecialDateShift[] getNeedPunchSpecialDays() {
    return this.needPunchSpecialDays;
  }

  public void setNeedPunchSpecialDays(PunchSpecialDateShift[] needPunchSpecialDays) {
    this.needPunchSpecialDays = needPunchSpecialDays;
  }

  public PunchSpecialDateShift[] getNoNeedPunchSpecialDays() {
    return this.noNeedPunchSpecialDays;
  }

  public void setNoNeedPunchSpecialDays(PunchSpecialDateShift[] noNeedPunchSpecialDays) {
    this.noNeedPunchSpecialDays = noNeedPunchSpecialDays;
  }

  public Boolean getWorkDayNoPunchAsLack() {
    return this.workDayNoPunchAsLack;
  }

  public void setWorkDayNoPunchAsLack(Boolean workDayNoPunchAsLack) {
    this.workDayNoPunchAsLack = workDayNoPunchAsLack;
  }

  public Boolean getEffectNow() {
    return this.effectNow;
  }

  public void setEffectNow(Boolean effectNow) {
    this.effectNow = effectNow;
  }

  public Integer getRemedyPeriodType() {
    return this.remedyPeriodType;
  }

  public void setRemedyPeriodType(Integer remedyPeriodType) {
    this.remedyPeriodType = remedyPeriodType;
  }

  public Integer getRemedyPeriodCustomDate() {
    return this.remedyPeriodCustomDate;
  }

  public void setRemedyPeriodCustomDate(Integer remedyPeriodCustomDate) {
    this.remedyPeriodCustomDate = remedyPeriodCustomDate;
  }

  public Integer getPunchType() {
    return this.punchType;
  }

  public void setPunchType(Integer punchType) {
    this.punchType = punchType;
  }

}
