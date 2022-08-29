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

package com.lark.oapi.service.task.v1.enums;

/**
 * 任务创建的来源
 */
public enum TaskSourceEnum {
  UNKNOWN_SOURCE_TYPE(0), // 未知类型
  TODO(1), // 来源任务中心创建
  MESSENGER(2), // 来源消息转任务
  DOC(3), // 来源云文档
  DOC_PRODUCT(4), // 来源文档单品
  PANO(5), // 来源PANO
  OAPI(6), // 来源tenant_access_token创建的任务
  OAPI_USER(7), // 来源user_access_token创建的任务
  DOCX(8), // 来源新版云文档
  ;
  private Integer value;

  TaskSourceEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}