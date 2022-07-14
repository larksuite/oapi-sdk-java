package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedOverflow extends MessageCardElement implements
    IMessageCardActionElement, IMessageCardExtraElement {

  @SerializedName("options")
  private MessageCardEmbedSelectOption options;
  @SerializedName("value")
  private Map<String, Object> value = new HashMap<>();
  @SerializedName("confirm")
  private MessageCardActionConfirm confirm;

  private MessageCardEmbedOverflow(Builder builder) {
    options = builder.options;
    value = builder.value;
    confirm = builder.confirm;
    this.tag = "overflow";
  }

  public MessageCardEmbedOverflow() {
    this.tag = "overflow";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private MessageCardEmbedSelectOption options;
    private Map<String, Object> value;
    private MessageCardActionConfirm confirm;

    private Builder() {
    }

    public Builder options(MessageCardEmbedSelectOption options) {
      this.options = options;
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

    public MessageCardEmbedOverflow build() {
      return new MessageCardEmbedOverflow(this);
    }
  }
}
