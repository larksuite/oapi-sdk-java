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

public class MessageCardImage extends MessageCardElement implements IMessageCardElement {

  @SerializedName("alt")
  private MessageCardPlainText alt;
  @SerializedName("title")
  private IMessageCardTextElement title;
  @SerializedName("img_key")
  private String imgKey;
  @SerializedName("custom_width")
  private Integer customWidth;
  @SerializedName("compact_width")
  private Boolean compactWidth;
  @SerializedName("mode")
  private MessageCardImageModelEnum mode;
  @SerializedName("preview")
  private Boolean preview;

  public MessageCardImage() {
    this.tag = "img";
  }

  public MessageCardImage(Builder builder) {
    this.tag = "img";
    this.alt = builder.alt;
    this.compactWidth = builder.compactWidth;
    this.title = builder.title;
    this.imgKey = builder.imgKey;
    this.customWidth = builder.customWidth;
    this.mode = builder.mode;
    this.preview = builder.preview;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private MessageCardPlainText alt;
    private IMessageCardTextElement title;
    private String imgKey;
    private Integer customWidth;
    private Boolean compactWidth;
    private MessageCardImageModelEnum mode;
    private Boolean preview;

    public Builder alt(MessageCardPlainText alt) {
      this.alt = alt;
      return this;
    }

    public Builder title(IMessageCardTextElement title) {
      this.title = title;
      return this;
    }

    public Builder imgKey(String imgKey) {
      this.imgKey = imgKey;
      return this;
    }

    public Builder customWidth(Integer customWidth) {
      this.customWidth = customWidth;
      return this;
    }

    public Builder compactWidth(Boolean compactWidth) {
      this.compactWidth = compactWidth;
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

    public MessageCardImage build() {
      return new MessageCardImage(this);
    }
  }
}
