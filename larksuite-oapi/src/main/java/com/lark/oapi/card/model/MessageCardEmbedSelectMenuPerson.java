package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedSelectMenuPerson extends MessageCardElement implements
    IMessageCardActionElement, IMessageCardExtraElement {

  @SerializedName("placeholder")
  protected MessageCardPlainText placeholder;
  @SerializedName("initial_option")
  protected String initialOption;
  @SerializedName("options")
  protected MessageCardEmbedSelectOption[] options;
  @SerializedName("value")
  protected Map<String, Object> value = new HashMap<>();
  @SerializedName("confirm")
  protected MessageCardActionConfirm confirm;

  private MessageCardEmbedSelectMenuPerson(Builder builder) {
    placeholder = builder.placeholder;
    initialOption = builder.initialOption;
    options = builder.options;
    value = builder.value;
    confirm = builder.confirm;
    tag = "select_person";
  }

  public MessageCardEmbedSelectMenuPerson() {
    tag = "select_person";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private MessageCardPlainText placeholder;
    private String initialOption;
    private MessageCardEmbedSelectOption[] options;
    private Map<String, Object> value;
    private MessageCardActionConfirm confirm;

    private Builder() {
    }

    public Builder placeholder(MessageCardPlainText placeholder) {
      this.placeholder = placeholder;
      return this;
    }

    public Builder initialOption(String initialOption) {
      this.initialOption = initialOption;
      return this;
    }

    public Builder options(MessageCardEmbedSelectOption[] options) {
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

    public MessageCardEmbedSelectMenuPerson build() {
      return new MessageCardEmbedSelectMenuPerson(this);
    }
  }
}
