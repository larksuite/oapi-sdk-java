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

package com.lark.oapi.service.docx.v1.enums;

// 生成枚举值
public enum BlockTypeEnum {
    PAGE(1),
    TEXT(2),
    HEADING1(3),
    HEADING2(4),
    HEADING3(5),
    HEADING4(6),
    HEADING5(7),
    HEADING6(8),
    HEADING7(9),
    HEADING8(10),
    HEADING9(11),
    BULLET(12),
    ORDERED(13),
    CODE(14),
    QUOTE(15),
    EQUATION(16),
    TODO(17),
    BITABLE(18),
    CALLOUT(19),
    CHATCARD(20),
    DIAGRAM(21),
    DIVIDER(22),
    FILE(23),
    GRID(24),
    GRIDCOLUMN(25),
    IFRAME(26),
    IMAGE(27),
    ISV(28),
    MINDNOTE(29),
    SHEET(30),
    TABLE(31),
    TABLECELL(32),
    VIEW(33),
    QUOTECONTAINER(34),
    UNDEFINED(999),
    ;
    private Integer value;

    BlockTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}