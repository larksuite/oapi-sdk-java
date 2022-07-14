package com.lark.oapi.service.im.v1.model.ext;

public class MessageText {

  public static Builder newBuilder() {
    return new Builder();
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
