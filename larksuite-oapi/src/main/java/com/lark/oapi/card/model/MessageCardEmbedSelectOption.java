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
import com.lark.oapi.card.enums.MessageCardButtonTypeEnum;

public class MessageCardEmbedSelectOption {

  @SerializedName("text")
  private MessageCardPlainText text;
  @SerializedName("value")
  private String value;
  @SerializedName("url")
  private String url;
  @SerializedName("multi_url")
  private MessageCardURL multiUrl;
  @SerializedName("type")
  private String buttonType;

  private MessageCardEmbedSelectOption(Builder builder) {
    text = builder.text;
    value = builder.value;
    url = builder.url;
    multiUrl = builder.multiUrl;
    if (builder.buttonType != null) {
      buttonType = builder.buttonType.getValue();
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private MessageCardPlainText text;
    private String value;
    private String url;
    private MessageCardURL multiUrl;
    private MessageCardButtonTypeEnum buttonType;

    private Builder() {
    }

    public Builder text(MessageCardPlainText text) {
      this.text = text;
      return this;
    }

    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder multiUrl(MessageCardURL multiUrl) {
      this.multiUrl = multiUrl;
      return this;
    }

    public Builder buttonType(MessageCardButtonTypeEnum buttonType) {
      this.buttonType = buttonType;
      return this;
    }

    public MessageCardEmbedSelectOption build() {
      return new MessageCardEmbedSelectOption(this);
    }
  }
}
