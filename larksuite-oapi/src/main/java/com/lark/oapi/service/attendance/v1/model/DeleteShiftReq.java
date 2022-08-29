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
import com.lark.oapi.core.annotation.Path;

public class DeleteShiftReq {

  /**
   * 班次 ID，获取方式：1）[按名称查询班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/query)
   * 2）[创建班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/create)
   * <p> 示例值：6919358778597097404
   */
  @Path
  @SerializedName("shift_id")
  private String shiftId;

  // builder 开始
  public DeleteShiftReq() {
  }

  public DeleteShiftReq(Builder builder) {
    /**
     * 班次 ID，获取方式：1）[按名称查询班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/query) 2）[创建班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/create)
     * <p> 示例值：6919358778597097404
     */
    this.shiftId = builder.shiftId;
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

  public static class Builder {

    private String shiftId; // 班次 ID，获取方式：1）[按名称查询班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/query) 2）[创建班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/create)

    /**
     * 班次 ID，获取方式：1）[按名称查询班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/query)
     * 2）[创建班次](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/shift/create)
     * <p> 示例值：6919358778597097404
     *
     * @param shiftId
     * @return
     */
    public Builder shiftId(String shiftId) {
      this.shiftId = shiftId;
      return this;
    }

    public DeleteShiftReq build() {
      return new DeleteShiftReq(this);
    }
  }
}