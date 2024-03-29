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

package com.lark.oapi.service.document_ai.v1.enums;

/**
 * 识别的字段种类
 */
public enum VehicleEntityVehicleEntityTypeEnum {
    PLATENUMBER("plate_number"), // 号牌号码
    VEHICLETYPE("vehicle_type"), // 车辆类型
    OWNER("owner"), // 所有人
    ADDRESS("address"), // 住址
    USECHARACTER("use_character"), // 使用性质
    MODEL("model"), // 品牌型号
    VIN("vin"), // 车辆识别代号
    ENGINENUMBER("engine_number"), // 发动机号码
    REGISTERDATE("register_date"), // 注册日期
    ISSUEDATE("issue_date"), // 发证日期
    LICENSEISSUINGAUTHORITY("license_issuing_authority"), // 发证机关
    DOCUMENTID("document_id"), // 档案编号
    APPROVEDPASSENGERSCAPACITY("approved_passengers_capacity"), // 核定载人数
    TOTALMASS("total_mass"), // 总质量
    CURBWEIGHT("curb_weight"), // 整备质量
    RATIFIEDLOADCAPACITY("ratified_load_capacity"), // 核定载质量
    GABARITE("gabarite"), // 外廓尺寸
    TRACTIONMASS("traction_mass"), // 准牵引总质量
    REMARKS("remarks"), // 备注
    INSPECTIONRECORD("inspection_record"), // 检验记录
    ;
    private String value;

    VehicleEntityVehicleEntityTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}