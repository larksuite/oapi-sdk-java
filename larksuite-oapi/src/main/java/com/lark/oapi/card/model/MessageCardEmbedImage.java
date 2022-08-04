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
import com.lark.oapi.card.enums.MessageCardImageModelEnum;

public class MessageCardEmbedImage extends MessageCardElement implements IMessageCardNoteElement,
    IMessageCardExtraElement {

  @SerializedName("alt")
  private MessageCardPlainText alt;
  @SerializedName("img_key")
  private String imgKey;
  @SerializedName("mode")
  private String mode;
  @SerializedName("preview")
  private Boolean preview;

  public MessageCardEmbedImage() {
    this.tag = "img";
  }

  public MessageCardEmbedImage(Builder builder) {
    this.tag = "img";
    this.alt = builder.alt;
    this.imgKey = builder.imgKey;
    if (builder.mode != null) {
      this.mode = builder.mode.getValue();
    }
    this.preview = builder.preview;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private MessageCardPlainText alt;
    private String imgKey;
    private MessageCardImageModelEnum mode;
    private Boolean preview;

    public Builder alt(MessageCardPlainText alt) {
      this.alt = alt;
      return this;
    }

    public Builder imgKey(String imgKey) {
      this.imgKey = imgKey;
      return this;
    }


    public Builder mode(MessageCardImageModelEnum mode) {
      this.mode = mode;
      return this;
    }

    public Builder preview(Boolean preview) {
      this.preview = preview;
      return this;
    }

    public MessageCardEmbedImage build() {
      return new MessageCardEmbedImage(this);
    }
  }
}
