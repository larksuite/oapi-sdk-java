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
import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedButton extends MessageCardElement implements IMessageCardActionElement,
    IMessageCardExtraElement {

  @SerializedName("text")
  private IMessageCardTextElement text;
  @SerializedName("url")
  private String url;
  @SerializedName("multi_url")
  private MessageCardURL multiUrl;
  @SerializedName("type")
  private String buttonType;
  @SerializedName("value")
  private Map<String, Object> value = new HashMap<>();
  @SerializedName("confirm")
  private MessageCardActionConfirm confirm;

  public MessageCardEmbedButton() {
    this.tag = "button";
  }

  private MessageCardEmbedButton(Builder builder) {
    text = builder.text;
    url = builder.url;
    multiUrl = builder.multiUrl;
    if (builder.buttonType != null) {
      buttonType = builder.buttonType.getValue();
    }
    value = builder.value;
    confirm = builder.confirm;
    tag = "button";
  }

  public static Builder newBuilder() {
    return new Builder();
  }


  public static final class Builder {

    private String tag;
    private IMessageCardTextElement text;
    private String url;
    private MessageCardURL multiUrl;
    private MessageCardButtonTypeEnum buttonType;
    private Map<String, Object> value;
    private MessageCardActionConfirm confirm;

    private Builder() {
    }

    public Builder tag(String tag) {
      this.tag = tag;
      return this;
    }

    public Builder text(IMessageCardTextElement text) {
      this.text = text;
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

    public Builder value(Map<String, Object> value) {
      this.value = value;
      return this;
    }

    public Builder confirm(MessageCardActionConfirm confirm) {
      this.confirm = confirm;
      return this;
    }

    public MessageCardEmbedButton build() {
      return new MessageCardEmbedButton(this);
    }
  }
}
