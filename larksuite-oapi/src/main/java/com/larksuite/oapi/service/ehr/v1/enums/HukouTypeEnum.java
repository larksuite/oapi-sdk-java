// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.ehr.v1.enums;

// 生成枚举值
public enum HukouTypeEnum {
    LOCAL_URBAN_RESIDENCE(1),
    NON_LOCAL_URBAN_RESIDENCE(2),
    LOCAL_RURAL_RESIDENCE(3),
    NON_LOCAL_RURAL_RESIDENCE(4),
    ;
    private Integer value;

    HukouTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}