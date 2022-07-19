// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.tenant.v2.model;

import com.google.gson.annotations.SerializedName;

public class Avatar {

  @SerializedName("avatar_origin")
  private String avatarOrigin;
  @SerializedName("avatar_72")
  private String avatar72;
  @SerializedName("avatar_240")
  private String avatar240;
  @SerializedName("avatar_640")
  private String avatar640;

  // builder 开始
  public Avatar() {
  }

  public Avatar(Builder builder) {
    this.avatarOrigin = builder.avatarOrigin;
    this.avatar72 = builder.avatar72;
    this.avatar240 = builder.avatar240;
    this.avatar640 = builder.avatar640;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAvatarOrigin() {
    return this.avatarOrigin;
  }

  public void setAvatarOrigin(String avatarOrigin) {
    this.avatarOrigin = avatarOrigin;
  }

  public String getAvatar72() {
    return this.avatar72;
  }

  public void setAvatar72(String avatar72) {
    this.avatar72 = avatar72;
  }

  public String getAvatar240() {
    return this.avatar240;
  }

  public void setAvatar240(String avatar240) {
    this.avatar240 = avatar240;
  }

  public String getAvatar640() {
    return this.avatar640;
  }

  public void setAvatar640(String avatar640) {
    this.avatar640 = avatar640;
  }

  public static class Builder {

    private String avatarOrigin;
    private String avatar72;
    private String avatar240;
    private String avatar640;

    public Builder avatarOrigin(String avatarOrigin) {
      this.avatarOrigin = avatarOrigin;
      return this;
    }

    public Builder avatar72(String avatar72) {
      this.avatar72 = avatar72;
      return this;
    }

    public Builder avatar240(String avatar240) {
      this.avatar240 = avatar240;
      return this;
    }

    public Builder avatar640(String avatar640) {
      this.avatar640 = avatar640;
      return this;
    }


    public Avatar build() {
      return new Avatar(this);
    }
  }
}