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

public class MessageText {

  private String text;

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public static final class Builder {

    private StringBuilder sb = new StringBuilder();

    public Builder() {
      sb.append("{\"text\":\"");
    }

    public Builder text(String text) {
      sb.append(text);
      return this;
    }

    public Builder textLine(String text) {
      sb.append(text).append("\\n");
      return this;
    }

    public Builder newLine() {
      sb.append("\\n");
      return this;
    }

    public Builder atUser(String userId, String name) {
      sb.append("<at user_id=\\\"")
          .append(userId)
          .append("\\\">")
          .append(name)
          .append("</at>");
      return this;
    }

    public Builder atAll() {
      sb.append("<at user_id=\\\"all\\\">")
          .append("</at>");
      return this;
    }

    public String build() {
      sb.append("\"}");
      return sb.toString();
    }
  }
}
