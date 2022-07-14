package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class MessageCardMarkdown extends MessageCardElement implements IMessageCardElement {

  @SerializedName("content")
  private String content;
  @SerializedName("href")
  private Map<String, MessageCardURL> href = new HashMap<>();

  public MessageCardMarkdown() {
    this.tag = "markdown";
  }

  public MessageCardMarkdown(Builder builder) {
    this.tag = "markdown";
    this.content = builder.content;
    this.href = builder.href;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String content;
    private Map<String, MessageCardURL> href = new HashMap<>();

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder href(Map<String, MessageCardURL> href) {
      this.href = href;
      return this;
    }

    public MessageCardMarkdown build() {
      return new MessageCardMarkdown(this);
    }
  }
}
