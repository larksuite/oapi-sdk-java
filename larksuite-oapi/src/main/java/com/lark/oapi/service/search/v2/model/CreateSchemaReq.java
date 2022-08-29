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

package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class CreateSchemaReq {

  /**
   * 是否只用来校验合法性
   * <p> 示例值：true
   */
  @Query
  @SerializedName("validate_only")
  private Boolean validateOnly;
  @Body
  private Schema body;

  // builder 开始
  public CreateSchemaReq() {
  }

  public CreateSchemaReq(Builder builder) {
    /**
     * 是否只用来校验合法性
     * <p> 示例值：true
     */
    this.validateOnly = builder.validateOnly;
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Boolean getValidateOnly() {
    return this.validateOnly;
  }

  public void setValidateOnly(Boolean validateOnly) {
    this.validateOnly = validateOnly;
  }

  public Schema getSchema() {
    return this.body;
  }

  public void setSchema(Schema body) {
    this.body = body;
  }

  public static class Builder {

    private Boolean validateOnly; // 是否只用来校验合法性
    private Schema body;

    /**
     * 是否只用来校验合法性
     * <p> 示例值：true
     *
     * @param validateOnly
     * @return
     */
    public Builder validateOnly(Boolean validateOnly) {
      this.validateOnly = validateOnly;
      return this;
    }

    public Schema getSchema() {
      return this.body;
    }

    /**
     * body
     *
     * @param body
     * @return
     */
    public Builder schema(Schema body) {
      this.body = body;
      return this;
    }

    public CreateSchemaReq build() {
      return new CreateSchemaReq(this);
    }
  }
}