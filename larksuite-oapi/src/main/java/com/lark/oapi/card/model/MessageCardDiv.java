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

package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardDiv extends MessageCardElement implements IMessageCardElement {

  @SerializedName("text")
  private IMessageCardTextElement text;
  @SerializedName("fields")
  private MessageCardField[] fields;
  @SerializedName("extra")
  private IMessageCardExtraElement extra;

  public MessageCardDiv(Builder builder) {
    this.text = builder.text;
    this.fields = builder.fields;
    this.extra = builder.extra;
    this.tag = "div";
  }

  public MessageCardDiv() {
    this.tag = "div";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private IMessageCardTextElement text;
    private MessageCardField[] fields;
    private IMessageCardExtraElement extra;

    public Builder text(IMessageCardTextElement text) {
      this.text = text;
      return this;
    }

    public Builder fields(MessageCardField[] fields) {
      this.fields = fields;
      return this;
    }

    public Builder extra(IMessageCardExtraElement extra) {
      this.extra = extra;
      return this;
    }

    public MessageCardDiv build() {
      return new MessageCardDiv(this);
    }
  }
}
