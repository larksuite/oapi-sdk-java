package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.utils.Jsons;

public class MessageShareUser {

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    @SerializedName("user_id")
    private String userId;

    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    public String build() {
      return Jsons.LONG_TO_STR.toJson(this);
    }
  }
}
