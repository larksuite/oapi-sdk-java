// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class P2CustomAttrEventUpdatedV3Data {

  @SerializedName("object")
  private CustomAttrEvent object;
  @SerializedName("old_object")
  private CustomAttrEvent oldObject;

  public CustomAttrEvent getObject() {
    return this.object;
  }

  public void setObject(CustomAttrEvent object) {
    this.object = object;
  }

  public CustomAttrEvent getOldObject() {
    return this.oldObject;
  }

  public void setOldObject(CustomAttrEvent oldObject) {
    this.oldObject = oldObject;
  }

}