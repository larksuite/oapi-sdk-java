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

public class Shift {
    /**
     * 班次 ID
     * <p> 示例值：6919358778597097404
     */
    @SerializedName("shift_id")
    private String shiftId;
    /**
     * 班次名称
     * <p> 示例值：早班
     */
    @SerializedName("shift_name")
    private String shiftName;
    /**
     * 打卡次数
     * <p> 示例值：1
     */
    @SerializedName("punch_times")
    private Integer punchTimes;
    /**
     * 排班组子负责人id列表
     * <p> 示例值：
     */
    @SerializedName("sub_shift_leader_ids")
    private String[] subShiftLeaderIds;
    /**
     * 是否弹性打卡
     * <p> 示例值：false
     */
    @SerializedName("is_flexible")
    private Boolean isFlexible;
    /**
     * 弹性打卡时间，设置【上班最多可晚到】与【下班最多可早走】时间，如果不设置flexible_rule则生效
     * <p> 示例值：60
     */
    @SerializedName("flexible_minutes")
    private Integer flexibleMinutes;
    /**
     * 弹性打卡时间设置
     * <p> 示例值：
     */
    @SerializedName("flexible_rule")
    private FlexibleRule[] flexibleRule;
    /**
     * 不需要打下班卡
     * <p> 示例值：true
     */
    @SerializedName("no_need_off")
    private Boolean noNeedOff;
    /**
     * 打卡规则
     * <p> 示例值：
     */
    @SerializedName("punch_time_rule")
    private PunchTimeRule[] punchTimeRule;
    /**
     * 晚走晚到规则
     * <p> 示例值：
     */
    @SerializedName("late_off_late_on_rule")
    private LateOffLateOnRule[] lateOffLateOnRule;
    /**
     * 休息规则
     * <p> 示例值：
     */
    @SerializedName("rest_time_rule")
    private RestRule[] restTimeRule;
    /**
     * 打卡规则
     * <p> 示例值：
     */
    @SerializedName("overtime_rule")
    private OvertimeRule[] overtimeRule;
    /**
     * 日期类型，【是否弹性打卡 = ture】时，不可设置为“休息日”  可选值：1：工作日 2：休息日     示例值：（默认值）1
     * <p> 示例值：60
     */
    @SerializedName("day_type")
    private Integer dayType;
    /**
     * 班外休息规则
     * <p> 示例值：
     */
    @SerializedName("overtime_rest_time_rule")
    private RestRule[] overtimeRestTimeRule;

    // builder 开始
    public Shift() {
    }

    public Shift(Builder builder) {
        /**
         * 班次 ID
         * <p> 示例值：6919358778597097404
         */
        this.shiftId = builder.shiftId;
        /**
         * 班次名称
         * <p> 示例值：早班
         */
        this.shiftName = builder.shiftName;
        /**
         * 打卡次数
         * <p> 示例值：1
         */
        this.punchTimes = builder.punchTimes;
        /**
         * 排班组子负责人id列表
         * <p> 示例值：
         */
        this.subShiftLeaderIds = builder.subShiftLeaderIds;
        /**
         * 是否弹性打卡
         * <p> 示例值：false
         */
        this.isFlexible = builder.isFlexible;
        /**
         * 弹性打卡时间，设置【上班最多可晚到】与【下班最多可早走】时间，如果不设置flexible_rule则生效
         * <p> 示例值：60
         */
        this.flexibleMinutes = builder.flexibleMinutes;
        /**
         * 弹性打卡时间设置
         * <p> 示例值：
         */
        this.flexibleRule = builder.flexibleRule;
        /**
         * 不需要打下班卡
         * <p> 示例值：true
         */
        this.noNeedOff = builder.noNeedOff;
        /**
         * 打卡规则
         * <p> 示例值：
         */
        this.punchTimeRule = builder.punchTimeRule;
        /**
         * 晚走晚到规则
         * <p> 示例值：
         */
        this.lateOffLateOnRule = builder.lateOffLateOnRule;
        /**
         * 休息规则
         * <p> 示例值：
         */
        this.restTimeRule = builder.restTimeRule;
        /**
         * 打卡规则
         * <p> 示例值：
         */
        this.overtimeRule = builder.overtimeRule;
        /**
         * 日期类型，【是否弹性打卡 = ture】时，不可设置为“休息日”  可选值：1：工作日 2：休息日     示例值：（默认值）1
         * <p> 示例值：60
         */
        this.dayType = builder.dayType;
        /**
         * 班外休息规则
         * <p> 示例值：
         */
        this.overtimeRestTimeRule = builder.overtimeRestTimeRule;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getShiftId() {
        return this.shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return this.shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public Integer getPunchTimes() {
        return this.punchTimes;
    }

    public void setPunchTimes(Integer punchTimes) {
        this.punchTimes = punchTimes;
    }

    public String[] getSubShiftLeaderIds() {
        return this.subShiftLeaderIds;
    }

    public void setSubShiftLeaderIds(String[] subShiftLeaderIds) {
        this.subShiftLeaderIds = subShiftLeaderIds;
    }

    public Boolean getIsFlexible() {
        return this.isFlexible;
    }

    public void setIsFlexible(Boolean isFlexible) {
        this.isFlexible = isFlexible;
    }

    public Integer getFlexibleMinutes() {
        return this.flexibleMinutes;
    }

    public void setFlexibleMinutes(Integer flexibleMinutes) {
        this.flexibleMinutes = flexibleMinutes;
    }

    public FlexibleRule[] getFlexibleRule() {
        return this.flexibleRule;
    }

    public void setFlexibleRule(FlexibleRule[] flexibleRule) {
        this.flexibleRule = flexibleRule;
    }

    public Boolean getNoNeedOff() {
        return this.noNeedOff;
    }

    public void setNoNeedOff(Boolean noNeedOff) {
        this.noNeedOff = noNeedOff;
    }

    public PunchTimeRule[] getPunchTimeRule() {
        return this.punchTimeRule;
    }

    public void setPunchTimeRule(PunchTimeRule[] punchTimeRule) {
        this.punchTimeRule = punchTimeRule;
    }

    public LateOffLateOnRule[] getLateOffLateOnRule() {
        return this.lateOffLateOnRule;
    }

    public void setLateOffLateOnRule(LateOffLateOnRule[] lateOffLateOnRule) {
        this.lateOffLateOnRule = lateOffLateOnRule;
    }

    public RestRule[] getRestTimeRule() {
        return this.restTimeRule;
    }

    public void setRestTimeRule(RestRule[] restTimeRule) {
        this.restTimeRule = restTimeRule;
    }

    public OvertimeRule[] getOvertimeRule() {
        return this.overtimeRule;
    }

    public void setOvertimeRule(OvertimeRule[] overtimeRule) {
        this.overtimeRule = overtimeRule;
    }

    public Integer getDayType() {
        return this.dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public RestRule[] getOvertimeRestTimeRule() {
        return this.overtimeRestTimeRule;
    }

    public void setOvertimeRestTimeRule(RestRule[] overtimeRestTimeRule) {
        this.overtimeRestTimeRule = overtimeRestTimeRule;
    }

    public static class Builder {
        /**
         * 班次 ID
         * <p> 示例值：6919358778597097404
         */
        private String shiftId;
        /**
         * 班次名称
         * <p> 示例值：早班
         */
        private String shiftName;
        /**
         * 打卡次数
         * <p> 示例值：1
         */
        private Integer punchTimes;
        /**
         * 排班组子负责人id列表
         * <p> 示例值：
         */
        private String[] subShiftLeaderIds;
        /**
         * 是否弹性打卡
         * <p> 示例值：false
         */
        private Boolean isFlexible;
        /**
         * 弹性打卡时间，设置【上班最多可晚到】与【下班最多可早走】时间，如果不设置flexible_rule则生效
         * <p> 示例值：60
         */
        private Integer flexibleMinutes;
        /**
         * 弹性打卡时间设置
         * <p> 示例值：
         */
        private FlexibleRule[] flexibleRule;
        /**
         * 不需要打下班卡
         * <p> 示例值：true
         */
        private Boolean noNeedOff;
        /**
         * 打卡规则
         * <p> 示例值：
         */
        private PunchTimeRule[] punchTimeRule;
        /**
         * 晚走晚到规则
         * <p> 示例值：
         */
        private LateOffLateOnRule[] lateOffLateOnRule;
        /**
         * 休息规则
         * <p> 示例值：
         */
        private RestRule[] restTimeRule;
        /**
         * 打卡规则
         * <p> 示例值：
         */
        private OvertimeRule[] overtimeRule;
        /**
         * 日期类型，【是否弹性打卡 = ture】时，不可设置为“休息日”  可选值：1：工作日 2：休息日     示例值：（默认值）1
         * <p> 示例值：60
         */
        private Integer dayType;
        /**
         * 班外休息规则
         * <p> 示例值：
         */
        private RestRule[] overtimeRestTimeRule;

        /**
         * 班次 ID
         * <p> 示例值：6919358778597097404
         *
         * @param shiftId
         * @return
         */
        public Builder shiftId(String shiftId) {
            this.shiftId = shiftId;
            return this;
        }


        /**
         * 班次名称
         * <p> 示例值：早班
         *
         * @param shiftName
         * @return
         */
        public Builder shiftName(String shiftName) {
            this.shiftName = shiftName;
            return this;
        }


        /**
         * 打卡次数
         * <p> 示例值：1
         *
         * @param punchTimes
         * @return
         */
        public Builder punchTimes(Integer punchTimes) {
            this.punchTimes = punchTimes;
            return this;
        }


        /**
         * 排班组子负责人id列表
         * <p> 示例值：
         *
         * @param subShiftLeaderIds
         * @return
         */
        public Builder subShiftLeaderIds(String[] subShiftLeaderIds) {
            this.subShiftLeaderIds = subShiftLeaderIds;
            return this;
        }


        /**
         * 是否弹性打卡
         * <p> 示例值：false
         *
         * @param isFlexible
         * @return
         */
        public Builder isFlexible(Boolean isFlexible) {
            this.isFlexible = isFlexible;
            return this;
        }


        /**
         * 弹性打卡时间，设置【上班最多可晚到】与【下班最多可早走】时间，如果不设置flexible_rule则生效
         * <p> 示例值：60
         *
         * @param flexibleMinutes
         * @return
         */
        public Builder flexibleMinutes(Integer flexibleMinutes) {
            this.flexibleMinutes = flexibleMinutes;
            return this;
        }


        /**
         * 弹性打卡时间设置
         * <p> 示例值：
         *
         * @param flexibleRule
         * @return
         */
        public Builder flexibleRule(FlexibleRule[] flexibleRule) {
            this.flexibleRule = flexibleRule;
            return this;
        }


        /**
         * 不需要打下班卡
         * <p> 示例值：true
         *
         * @param noNeedOff
         * @return
         */
        public Builder noNeedOff(Boolean noNeedOff) {
            this.noNeedOff = noNeedOff;
            return this;
        }


        /**
         * 打卡规则
         * <p> 示例值：
         *
         * @param punchTimeRule
         * @return
         */
        public Builder punchTimeRule(PunchTimeRule[] punchTimeRule) {
            this.punchTimeRule = punchTimeRule;
            return this;
        }


        /**
         * 晚走晚到规则
         * <p> 示例值：
         *
         * @param lateOffLateOnRule
         * @return
         */
        public Builder lateOffLateOnRule(LateOffLateOnRule[] lateOffLateOnRule) {
            this.lateOffLateOnRule = lateOffLateOnRule;
            return this;
        }


        /**
         * 休息规则
         * <p> 示例值：
         *
         * @param restTimeRule
         * @return
         */
        public Builder restTimeRule(RestRule[] restTimeRule) {
            this.restTimeRule = restTimeRule;
            return this;
        }


        /**
         * 打卡规则
         * <p> 示例值：
         *
         * @param overtimeRule
         * @return
         */
        public Builder overtimeRule(OvertimeRule[] overtimeRule) {
            this.overtimeRule = overtimeRule;
            return this;
        }


        /**
         * 日期类型，【是否弹性打卡 = ture】时，不可设置为“休息日”  可选值：1：工作日 2：休息日     示例值：（默认值）1
         * <p> 示例值：60
         *
         * @param dayType
         * @return
         */
        public Builder dayType(Integer dayType) {
            this.dayType = dayType;
            return this;
        }


        /**
         * 班外休息规则
         * <p> 示例值：
         *
         * @param overtimeRestTimeRule
         * @return
         */
        public Builder overtimeRestTimeRule(RestRule[] overtimeRestTimeRule) {
            this.overtimeRestTimeRule = overtimeRestTimeRule;
            return this;
        }


        public Shift build() {
            return new Shift(this);
        }
    }
}
