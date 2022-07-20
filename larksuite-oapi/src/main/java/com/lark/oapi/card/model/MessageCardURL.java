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

public class MessageCardURL {

  @SerializedName("url")
  private String url;
  @SerializedName("android_url")
  private String androidUrl;
  @SerializedName("ios_url")
  private String iosUrl;
  @SerializedName("pc_url")
  private String pcUrl;

  public MessageCardURL(Builder builder) {
    this.url = builder.url;
    this.androidUrl = builder.androidUrl;
    this.iosUrl = builder.iosUrl;
    this.pcUrl = builder.pcUrl;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String url;
    private String androidUrl;
    private String iosUrl;
    private String pcUrl;

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder androidUrl(String androidUrl) {
      this.androidUrl = androidUrl;
      return this;
    }

    public Builder iosUrl(String iosUrl) {
      this.iosUrl = iosUrl;
      return this;
    }

    public Builder pcUrl(String pcUrl) {
      this.pcUrl = pcUrl;
      return this;
    }

    public MessageCardURL build() {
      return new MessageCardURL(this);
    }
  }
}
