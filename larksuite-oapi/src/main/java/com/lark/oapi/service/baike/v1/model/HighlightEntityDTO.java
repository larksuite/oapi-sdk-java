// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;

public class HighlightEntityDTO {

  @SerializedName("phrases")
  private Phrase[] phrases;

  public Phrase[] getPhrases() {
    return this.phrases;
  }

  public void setPhrases(Phrase[] phrases) {
    this.phrases = phrases;
  }

}