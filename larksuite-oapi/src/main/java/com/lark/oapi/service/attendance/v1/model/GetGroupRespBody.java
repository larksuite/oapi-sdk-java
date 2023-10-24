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

package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class GetGroupRespBody {
    /**
     * 考勤组的Id， 需要从获取用户打卡结果信息的接口中获取groupId，修改考勤组时必填
     * <p> 示例值：6919358128597097404
     */
    @SerializedName("group_id")
    private String groupId;
    /**
     * 考勤组名称
     * <p> 示例值：开心考勤
     */
    @SerializedName("group_name")
    private String groupName;
    /**
     * 考勤组时区
     * <p> 示例值：Asia/Shanghai
     */
    @SerializedName("time_zone")
    private String timeZone;
    /**
     * 参加考勤的部门id列表
     * <p> 示例值：
     */
    @SerializedName("bind_dept_ids")
    private String[] bindDeptIds;
    /**
     * 无需考勤的部门id列表
     * <p> 示例值：
     */
    @SerializedName("except_dept_ids")
    private String[] exceptDeptIds;
    /**
     * 参加考勤的人员id列表
     * <p> 示例值：
     */
    @SerializedName("bind_user_ids")
    private String[] bindUserIds;
    /**
     * 参加考勤的人员id列表
     * <p> 示例值：
     */
    @SerializedName("except_user_ids")
    private String[] exceptUserIds;
    /**
     * 考勤组主负责人id列表
     * <p> 示例值：
     */
    @SerializedName("group_leader_ids")
    private String[] groupLeaderIds;
    /**
     * 考勤组子负责人id列表
     * <p> 示例值：
     */
    @SerializedName("sub_group_leader_ids")
    private String[] subGroupLeaderIds;
    /**
     * 是否允许外勤打卡
     * <p> 示例值：true
     */
    @SerializedName("allow_out_punch")
    private Boolean allowOutPunch;
    /**
     * 外勤打卡需审批（需要允许外勤打卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("out_punch_need_approval")
    private Boolean outPunchNeedApproval;
    /**
     * 外勤打卡需填写备注（需要允许外勤打卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("out_punch_need_remark")
    private Boolean outPunchNeedRemark;
    /**
     * 外勤打卡需拍照（需要允许外勤打卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("out_punch_need_photo")
    private Boolean outPunchNeedPhoto;
    /**
     * 外勤打卡允许员工隐藏详细地址（需要允许外勤打卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("out_punch_allowed_hide_addr")
    private Boolean outPunchAllowedHideAddr;
    /**
     * 是否允许pc打卡
     * <p> 示例值：true
     */
    @SerializedName("allow_pc_punch")
    private Boolean allowPcPunch;
    /**
     * 是否允许补卡
     * <p> 示例值：true
     */
    @SerializedName("allow_remedy")
    private Boolean allowRemedy;
    /**
     * 补卡次数是否限制（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("remedy_limit")
    private Boolean remedyLimit;
    /**
     * 补卡次数（需要允许补卡才能设置生效）
     * <p> 示例值：3
     */
    @SerializedName("remedy_limit_count")
    private Integer remedyLimitCount;
    /**
     * 补卡时间是否限制（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("remedy_date_limit")
    private Boolean remedyDateLimit;
    /**
     * 补卡时间,几天内可以发起补卡（需要允许补卡才能设置生效）
     * <p> 示例值：3
     */
    @SerializedName("remedy_date_num")
    private Integer remedyDateNum;
    /**
     * 允许缺卡补卡（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("allow_remedy_type_lack")
    private Boolean allowRemedyTypeLack;
    /**
     * 允许迟到补卡（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("allow_remedy_type_late")
    private Boolean allowRemedyTypeLate;
    /**
     * 允许早退补卡（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("allow_remedy_type_early")
    private Boolean allowRemedyTypeEarly;
    /**
     * 允许正常补卡（需要允许补卡才能设置生效）
     * <p> 示例值：true
     */
    @SerializedName("allow_remedy_type_normal")
    private Boolean allowRemedyTypeNormal;
    /**
     * 是否展示累计时长
     * <p> 示例值：true
     */
    @SerializedName("show_cumulative_time")
    private Boolean showCumulativeTime;
    /**
     * 是否展示加班时长
     * <p> 示例值：true
     */
    @SerializedName("show_over_time")
    private Boolean showOverTime;
    /**
     * 是否隐藏员工打卡详情
     * <p> 示例值：true
     */
    @SerializedName("hide_staff_punch_time")
    private Boolean hideStaffPunchTime;
    /**
     * 是否开启人脸打卡
     * <p> 示例值：true
     */
    @SerializedName("face_punch")
    private Boolean facePunch;
    /**
     * 人脸打卡规则， 1：每次打卡均需人脸识别 2：疑似需要
     * <p> 示例值：1
     */
    @SerializedName("face_punch_cfg")
    private Integer facePunchCfg;
    /**
     * 人脸打卡规则， false：开启活体验证 true：0动作验证，仅在 face_punch_cfg = 1 时有效
     * <p> 示例值：false
     */
    @SerializedName("face_live_need_action")
    private Boolean faceLiveNeedAction;
    /**
     * 脸识别失败时允许普通拍照打卡
     * <p> 示例值：true
     */
    @SerializedName("face_downgrade")
    private Boolean faceDowngrade;
    /**
     * 是否允许替换基准图片
     * <p> 示例值：true
     */
    @SerializedName("replace_basic_pic")
    private Boolean replaceBasicPic;
    /**
     * 考勤机信息
     * <p> 示例值：
     */
    @SerializedName("machines")
    private Machine[] machines;
    /**
     * GPS打卡的地址范围
     * <p> 示例值：300
     */
    @SerializedName("gps_range")
    private Integer gpsRange;
    /**
     * GPS打卡的地址信息
     * <p> 示例值：
     */
    @SerializedName("locations")
    private Location[] locations;
    /**
     * 考勤类型 0：固定考勤  2：排班考勤， 3：自由班次
     * <p> 示例值：0
     */
    @SerializedName("group_type")
    private Integer groupType;
    /**
     * 固定班次必需填
     * <p> 示例值：
     */
    @SerializedName("punch_day_shift_ids")
    private String[] punchDayShiftIds;
    /**
     * <p> 示例值：
     */
    @SerializedName("free_punch_cfg")
    private FreePunchCfg freePunchCfg;
    /**
     * 国家日历 id，（0：不根据国家日历休息, 1：中国，2：美国，3：日本，4：印度，5：新加坡），默认 1
     * <p> 示例值：1
     */
    @SerializedName("calendar_id")
    private Integer calendarId;
    /**
     * 强制需要打卡的日期
     * <p> 示例值：
     */
    @SerializedName("need_punch_special_days")
    private PunchSpecialDateShift[] needPunchSpecialDays;
    /**
     * 强制不需要打卡的日期
     * <p> 示例值：
     */
    @SerializedName("no_need_punch_special_days")
    private PunchSpecialDateShift[] noNeedPunchSpecialDays;
    /**
     * 自由班次下工作日不打卡是否记为缺卡
     * <p> 示例值：false
     */
    @SerializedName("work_day_no_punch_as_lack")
    private Boolean workDayNoPunchAsLack;
    /**
     * 补卡周期类型
     * <p> 示例值：0
     */
    @SerializedName("remedy_period_type")
    private Integer remedyPeriodType;
    /**
     * 补卡自定义周期起始日期
     * <p> 示例值：1
     */
    @SerializedName("remedy_period_custom_date")
    private Integer remedyPeriodCustomDate;
    /**
     * 打卡类型，位运算。1:GPS打卡；2:wifi打卡；4:考勤机打卡；8:IP打卡
     * <p> 示例值：1
     */
    @SerializedName("punch_type")
    private Integer punchType;
    /**
     * 生效时间，精确到秒的时间戳
     * <p> 示例值：1611476284
     */
    @SerializedName("effect_time")
    private String effectTime;
    /**
     * 固定班次生效时间，精确到秒的时间戳
     * <p> 示例值：1611476284
     */
    @SerializedName("fixshift_effect_time")
    private String fixshiftEffectTime;
    /**
     * 参加考勤的人员、部门变动生效时间，精确到秒的时间戳
     * <p> 示例值：1611476284
     */
    @SerializedName("member_effect_time")
    private String memberEffectTime;
    /**
     * 休息日打卡需审批
     * <p> 示例值：true
     */
    @SerializedName("rest_clockIn_need_approval")
    private Boolean restClockInNeedApproval;
    /**
     * 每次打卡均需拍照
     * <p> 示例值：true
     */
    @SerializedName("clockIn_need_photo")
    private Boolean clockInNeedPhoto;
    /**
     * 人员异动打卡设置
     * <p> 示例值：
     */
    @SerializedName("member_status_change")
    private MemberStatusChange memberStatusChange;
    /**
     * 请假离岗或返岗是否需打卡
     * <p> 示例值：false
     */
    @SerializedName("leave_need_punch")
    private Boolean leaveNeedPunch;
    /**
     * 请假离岗或返岗打卡规则
     * <p> 示例值：
     */
    @SerializedName("leave_need_punch_cfg")
    private LeaveNeedPunchCfg leaveNeedPunchCfg;
    /**
     * 外出期间是否需打卡
     * <p> 示例值：0
     */
    @SerializedName("go_out_need_punch")
    private Integer goOutNeedPunch;
    /**
     * 外出期间打卡规则
     * <p> 示例值：
     */
    @SerializedName("go_out_need_punch_cfg")
    private LeaveNeedPunchCfg goOutNeedPunchCfg;
    /**
     * 出差期间是否需打卡
     * <p> 示例值：0
     */
    @SerializedName("travel_need_punch")
    private Integer travelNeedPunch;
    /**
     * 出差期间打卡规则
     * <p> 示例值：
     */
    @SerializedName("travel_need_punch_cfg")
    private LeaveNeedPunchCfg travelNeedPunchCfg;
    /**
     * 需要打卡的人员配置（新）
     * <p> 示例值：
     */
    @SerializedName("need_punch_members")
    private PunchMember[] needPunchMembers;
    /**
     * 无需打卡的人员配置（新）
     * <p> 示例值：
     */
    @SerializedName("no_need_punch_members")
    private PunchMember[] noNeedPunchMembers;
    /**
     * 是否直接保存可以自动变更的冲突规则
     * <p> 示例值：false
     */
    @SerializedName("save_auto_changes")
    private Boolean saveAutoChanges;
    /**
     * 人员异动开关（人员组织架构变更后是否允许自动调整到该考勤组）
     * <p> 示例值：false
     */
    @SerializedName("org_change_auto_adjust")
    private Boolean orgChangeAutoAdjust;
    /**
     * 默认出勤的部门id列表
     * <p> 示例值：
     */
    @SerializedName("bind_default_dept_ids")
    private String[] bindDefaultDeptIds;
    /**
     * 默认出勤的用户ID列表
     * <p> 示例值：
     */
    @SerializedName("bind_default_user_ids")
    private String[] bindDefaultUserIds;
    /**
     * 加班打卡规则
     * <p> 示例值：
     */
    @SerializedName("overtime_clock_cfg")
    private OvertimeClockCfg overtimeClockCfg;

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

    public String[] getSubGroupLeaderIds() {
        return this.subGroupLeaderIds;
    }

    public void setSubGroupLeaderIds(String[] subGroupLeaderIds) {
        this.subGroupLeaderIds = subGroupLeaderIds;
    }

    public Boolean getAllowOutPunch() {
        return this.allowOutPunch;
    }

    public void setAllowOutPunch(Boolean allowOutPunch) {
        this.allowOutPunch = allowOutPunch;
    }

    public Boolean getOutPunchNeedApproval() {
        return this.outPunchNeedApproval;
    }

    public void setOutPunchNeedApproval(Boolean outPunchNeedApproval) {
        this.outPunchNeedApproval = outPunchNeedApproval;
    }

    public Boolean getOutPunchNeedRemark() {
        return this.outPunchNeedRemark;
    }

    public void setOutPunchNeedRemark(Boolean outPunchNeedRemark) {
        this.outPunchNeedRemark = outPunchNeedRemark;
    }

    public Boolean getOutPunchNeedPhoto() {
        return this.outPunchNeedPhoto;
    }

    public void setOutPunchNeedPhoto(Boolean outPunchNeedPhoto) {
        this.outPunchNeedPhoto = outPunchNeedPhoto;
    }

    public Boolean getOutPunchAllowedHideAddr() {
        return this.outPunchAllowedHideAddr;
    }

    public void setOutPunchAllowedHideAddr(Boolean outPunchAllowedHideAddr) {
        this.outPunchAllowedHideAddr = outPunchAllowedHideAddr;
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

    public Boolean getAllowRemedyTypeLack() {
        return this.allowRemedyTypeLack;
    }

    public void setAllowRemedyTypeLack(Boolean allowRemedyTypeLack) {
        this.allowRemedyTypeLack = allowRemedyTypeLack;
    }

    public Boolean getAllowRemedyTypeLate() {
        return this.allowRemedyTypeLate;
    }

    public void setAllowRemedyTypeLate(Boolean allowRemedyTypeLate) {
        this.allowRemedyTypeLate = allowRemedyTypeLate;
    }

    public Boolean getAllowRemedyTypeEarly() {
        return this.allowRemedyTypeEarly;
    }

    public void setAllowRemedyTypeEarly(Boolean allowRemedyTypeEarly) {
        this.allowRemedyTypeEarly = allowRemedyTypeEarly;
    }

    public Boolean getAllowRemedyTypeNormal() {
        return this.allowRemedyTypeNormal;
    }

    public void setAllowRemedyTypeNormal(Boolean allowRemedyTypeNormal) {
        this.allowRemedyTypeNormal = allowRemedyTypeNormal;
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

    public Boolean getFaceLiveNeedAction() {
        return this.faceLiveNeedAction;
    }

    public void setFaceLiveNeedAction(Boolean faceLiveNeedAction) {
        this.faceLiveNeedAction = faceLiveNeedAction;
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

    public String getEffectTime() {
        return this.effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public String getFixshiftEffectTime() {
        return this.fixshiftEffectTime;
    }

    public void setFixshiftEffectTime(String fixshiftEffectTime) {
        this.fixshiftEffectTime = fixshiftEffectTime;
    }

    public String getMemberEffectTime() {
        return this.memberEffectTime;
    }

    public void setMemberEffectTime(String memberEffectTime) {
        this.memberEffectTime = memberEffectTime;
    }

    public Boolean getRestClockInNeedApproval() {
        return this.restClockInNeedApproval;
    }

    public void setRestClockInNeedApproval(Boolean restClockInNeedApproval) {
        this.restClockInNeedApproval = restClockInNeedApproval;
    }

    public Boolean getClockInNeedPhoto() {
        return this.clockInNeedPhoto;
    }

    public void setClockInNeedPhoto(Boolean clockInNeedPhoto) {
        this.clockInNeedPhoto = clockInNeedPhoto;
    }

    public MemberStatusChange getMemberStatusChange() {
        return this.memberStatusChange;
    }

    public void setMemberStatusChange(MemberStatusChange memberStatusChange) {
        this.memberStatusChange = memberStatusChange;
    }

    public Boolean getLeaveNeedPunch() {
        return this.leaveNeedPunch;
    }

    public void setLeaveNeedPunch(Boolean leaveNeedPunch) {
        this.leaveNeedPunch = leaveNeedPunch;
    }

    public LeaveNeedPunchCfg getLeaveNeedPunchCfg() {
        return this.leaveNeedPunchCfg;
    }

    public void setLeaveNeedPunchCfg(LeaveNeedPunchCfg leaveNeedPunchCfg) {
        this.leaveNeedPunchCfg = leaveNeedPunchCfg;
    }

    public Integer getGoOutNeedPunch() {
        return this.goOutNeedPunch;
    }

    public void setGoOutNeedPunch(Integer goOutNeedPunch) {
        this.goOutNeedPunch = goOutNeedPunch;
    }

    public LeaveNeedPunchCfg getGoOutNeedPunchCfg() {
        return this.goOutNeedPunchCfg;
    }

    public void setGoOutNeedPunchCfg(LeaveNeedPunchCfg goOutNeedPunchCfg) {
        this.goOutNeedPunchCfg = goOutNeedPunchCfg;
    }

    public Integer getTravelNeedPunch() {
        return this.travelNeedPunch;
    }

    public void setTravelNeedPunch(Integer travelNeedPunch) {
        this.travelNeedPunch = travelNeedPunch;
    }

    public LeaveNeedPunchCfg getTravelNeedPunchCfg() {
        return this.travelNeedPunchCfg;
    }

    public void setTravelNeedPunchCfg(LeaveNeedPunchCfg travelNeedPunchCfg) {
        this.travelNeedPunchCfg = travelNeedPunchCfg;
    }

    public PunchMember[] getNeedPunchMembers() {
        return this.needPunchMembers;
    }

    public void setNeedPunchMembers(PunchMember[] needPunchMembers) {
        this.needPunchMembers = needPunchMembers;
    }

    public PunchMember[] getNoNeedPunchMembers() {
        return this.noNeedPunchMembers;
    }

    public void setNoNeedPunchMembers(PunchMember[] noNeedPunchMembers) {
        this.noNeedPunchMembers = noNeedPunchMembers;
    }

    public Boolean getSaveAutoChanges() {
        return this.saveAutoChanges;
    }

    public void setSaveAutoChanges(Boolean saveAutoChanges) {
        this.saveAutoChanges = saveAutoChanges;
    }

    public Boolean getOrgChangeAutoAdjust() {
        return this.orgChangeAutoAdjust;
    }

    public void setOrgChangeAutoAdjust(Boolean orgChangeAutoAdjust) {
        this.orgChangeAutoAdjust = orgChangeAutoAdjust;
    }

    public String[] getBindDefaultDeptIds() {
        return this.bindDefaultDeptIds;
    }

    public void setBindDefaultDeptIds(String[] bindDefaultDeptIds) {
        this.bindDefaultDeptIds = bindDefaultDeptIds;
    }

    public String[] getBindDefaultUserIds() {
        return this.bindDefaultUserIds;
    }

    public void setBindDefaultUserIds(String[] bindDefaultUserIds) {
        this.bindDefaultUserIds = bindDefaultUserIds;
    }

    public OvertimeClockCfg getOvertimeClockCfg() {
        return this.overtimeClockCfg;
    }

    public void setOvertimeClockCfg(OvertimeClockCfg overtimeClockCfg) {
        this.overtimeClockCfg = overtimeClockCfg;
    }

}
