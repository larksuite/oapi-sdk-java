// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.optical_char_recognition.v1.model;

import com.google.gson.annotations.SerializedName;

public class BasicRecognizeImage {

  @SerializedName("text_list")
  private String[] textList;

  public String[] getTextList() {
    return this.textList;
  }

  public void setTextList(String[] textList) {
    this.textList = textList;
  }

}
