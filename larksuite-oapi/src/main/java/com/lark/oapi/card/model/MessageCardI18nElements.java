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

public class MessageCardI18nElements {

  @SerializedName("zh_cn")
  private MessageCardElement[] zhCn;
  @SerializedName("en_us")
  private MessageCardElement[] enUs;
  @SerializedName("ja_jp")
  private MessageCardElement[] jaJp;

  public MessageCardI18nElements(Builder builder) {
    this.zhCn = builder.zhCn;
    this.enUs = builder.enUs;
    this.jaJp = builder.jaJp;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static void main(String[] ar) {
    MessageCardI18nElements.newBuilder()
        .zhCn(new MessageCardElement[]{new MessageCardEmbedButton()})
        .build();
  }

  public static class Builder {

    private MessageCardElement[] zhCn;
    private MessageCardElement[] enUs;
    private MessageCardElement[] jaJp;

    public Builder zhCn(MessageCardElement[] zhCn) {
      this.zhCn = zhCn;
      return this;
    }

    public Builder enUs(MessageCardElement[] enUs) {
      this.enUs = enUs;
      return this;
    }

    public Builder jaJp(MessageCardElement[] jaJp) {
      this.jaJp = jaJp;
      return this;
    }

    public MessageCardI18nElements build() {
      return new MessageCardI18nElements(this);
    }
  }

}
