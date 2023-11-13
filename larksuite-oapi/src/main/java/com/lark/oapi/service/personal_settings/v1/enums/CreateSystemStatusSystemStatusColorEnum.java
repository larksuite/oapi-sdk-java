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

package com.lark.oapi.service.personal_settings.v1.enums;

/**
 * 颜色
 */
public enum CreateSystemStatusSystemStatusColorEnum {
    BLUE("BLUE"), // 蓝色
    GRAY("GRAY"), // 灰色
    INDIGO("INDIGO"), // 靛青色
    WATHET("WATHET"), // 浅蓝色
    GREEN("GREEN"), // 绿色
    TURQUOISE("TURQUOISE"), // 绿松石色
    YELLOW("YELLOW"), // 黄色
    LIME("LIME"), // 酸橙色
    RED("RED"), // 红色
    ORANGE("ORANGE"), // 橙色
    PURPLE("PURPLE"), // 紫色
    VIOLET("VIOLET"), // 紫罗兰色
    CARMINE("CARMINE"), // 胭脂红色
    ;
    private String value;

    CreateSystemStatusSystemStatusColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}