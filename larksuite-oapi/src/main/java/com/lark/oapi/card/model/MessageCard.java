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
import com.lark.oapi.core.utils.Jsons;

public class MessageCard {

  @SerializedName("config")
  private MessageCardConfig config;
  @SerializedName("header")
  private MessageCardHeader header;
  @SerializedName("elements")
  private MessageCardElement[] elements;
  @SerializedName("i18n_elements")
  private MessageCardI18nElements i18nElements;
  @SerializedName("card_link")
  private MessageCardURL cardLink;

  public MessageCard(Builder builder) {
    this.config = builder.config;
    this.header = builder.header;
    this.elements = builder.elements;
    this.i18nElements = builder.i18nElements;
    this.cardLink = builder.cardLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String String() {
    return Jsons.LONG_TO_STR.toJson(this);
  }

  public static class Builder {

    private MessageCardConfig config;
    private MessageCardHeader header;
    private MessageCardElement[] elements;
    private MessageCardI18nElements i18nElements;
    private MessageCardURL cardLink;

    public Builder config(MessageCardConfig config) {
      this.config = config;
      return this;
    }

    public Builder header(MessageCardHeader header) {
      this.header = header;
      return this;
    }

    public Builder elements(MessageCardElement[] elements) {
      this.elements = elements;
      return this;
    }

    public Builder i18nElements(MessageCardI18nElements i18nElements) {
      this.i18nElements = i18nElements;
      return this;
    }

    public Builder cardLink(MessageCardURL cardLink) {
      this.cardLink = cardLink;
      return this;
    }

    public MessageCard build() {
      return new MessageCard(this);
    }
  }
}
