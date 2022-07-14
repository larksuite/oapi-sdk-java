package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.utils.Jsons;

public class MessageFile {

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    @SerializedName("file_key")
    private String fileKey;

    public Builder fileKey(String fileKey) {
      this.fileKey = fileKey;
      return this;
    }


    public String build() {
      return Jsons.LONG_TO_STR.toJson(this);
    }
  }
}
