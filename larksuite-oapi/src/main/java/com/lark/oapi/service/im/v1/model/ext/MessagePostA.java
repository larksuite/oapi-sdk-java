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

package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostA extends MessagePostElement {

  @SerializedName("text")
  private String text;
  @SerializedName("href")
  private String href;

  public MessagePostA() {
    tag = "a";
  }

  public MessagePostA(Builder builder) {
    tag = "a";
    this.href = builder.href;
    this.text = builder.text;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  @Override
  String getTag() {
    return this.tag;
  }

  public static class Builder {

    private String text;
    private String href;

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder href(String href) {
      this.href = href;
      return this;
    }

    public MessagePostA build() {
      return new MessagePostA(this);
    }
  }
}
