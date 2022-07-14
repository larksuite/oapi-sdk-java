package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedDatePicker extends MessageCardElement implements
    IMessageCardActionElement, IMessageCardExtraElement {

  @SerializedName("initial_date")
  protected String initialDate;
  @SerializedName("initial_time")
  protected String initialTime;
  @SerializedName("initial_datetime")
  protected String initialDatetime;
  @SerializedName("placeholder")
  protected MessageCardPlainText placeholder;
  @SerializedName("value")
  protected Map<String, Object> value = new HashMap<>();
  @SerializedName("confirm")
  protected MessageCardActionConfirm confirm;

  private MessageCardEmbedDatePicker(Builder builder) {
    initialDate = builder.initialDate;
    initialTime = builder.initialTime;
    initialDatetime = builder.initialDatetime;
    placeholder = builder.placeholder;
    value = builder.value;
    confirm = builder.confirm;
    tag = "date_picker";
  }

  public MessageCardEmbedDatePicker() {
    tag = "date_picker";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private String initialDate;
    private String initialTime;
    private String initialDatetime;
    private MessageCardPlainText placeholder;
    private Map<String, Object> value;
    private MessageCardActionConfirm confirm;

    private Builder() {
    }

    public Builder initialDate(String initialDate) {
      this.initialDate = initialDate;
      return this;
    }

    public Builder initialTime(String initialTime) {
      this.initialTime = initialTime;
      return this;
    }

    public Builder initialDatetime(String initialDatetime) {
      this.initialDatetime = initialDatetime;
      return this;
    }

    public Builder placeholder(MessageCardPlainText placeholder) {
      this.placeholder = placeholder;
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

    public MessageCardEmbedDatePicker build() {
      return new MessageCardEmbedDatePicker(this);
    }
  }
}


