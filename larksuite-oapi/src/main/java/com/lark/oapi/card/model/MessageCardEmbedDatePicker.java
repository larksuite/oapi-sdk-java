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
import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedDatePicker extends MessageCardElement implements
    IMessageCardActionElement, IMessageCardExtraElement {

  @SerializedName("initial_date")
  protected String initialDate;
  @SerializedName("initial_time")
  protected String initialTime;
  @SerializedName("initial_datetime")
  protected String initialDatetime;
  @SerializedName("placeholder")
  protected MessageCardPlainText placeholder;
  @SerializedName("value")
  protected Map<String, Object> value = new HashMap<>();
  @SerializedName("confirm")
  protected MessageCardActionConfirm confirm;

  private MessageCardEmbedDatePicker(Builder builder) {
    initialDate = builder.initialDate;
    initialTime = builder.initialTime;
    initialDatetime = builder.initialDatetime;
    placeholder = builder.placeholder;
    value = builder.value;
    confirm = builder.confirm;
    tag = "date_picker";
  }

  public MessageCardEmbedDatePicker() {
    tag = "date_picker";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private String initialDate;
    private String initialTime;
    private String initialDatetime;
    private MessageCardPlainText placeholder;
    private Map<String, Object> value;
    private MessageCardActionConfirm confirm;

    private Builder() {
    }

    public Builder initialDate(String initialDate) {
      this.initialDate = initialDate;
      return this;
    }

    public Builder initialTime(String initialTime) {
      this.initialTime = initialTime;
      return this;
    }

    public Builder initialDatetime(String initialDatetime) {
      this.initialDatetime = initialDatetime;
      return this;
    }

    public Builder placeholder(MessageCardPlainText placeholder) {
      this.placeholder = placeholder;
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

    public MessageCardEmbedDatePicker build() {
      return new MessageCardEmbedDatePicker(this);
    }
  }
}


