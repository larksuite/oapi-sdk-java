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
