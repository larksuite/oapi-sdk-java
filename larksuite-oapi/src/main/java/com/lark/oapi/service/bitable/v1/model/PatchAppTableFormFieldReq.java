// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;

public class PatchAppTableFormFieldReq {

  @Path
  @SerializedName("app_token")
  private String appToken;
  @Path
  @SerializedName("table_id")
  private String tableId;
  @Path
  @SerializedName("form_id")
  private String formId;
  @Path
  @SerializedName("field_id")
  private String fieldId;
  @Body
  private AppTableFormPatchedField body;

  // builder 开始
  public PatchAppTableFormFieldReq() {
  }

  public PatchAppTableFormFieldReq(Builder builder) {
    this.appToken = builder.appToken;
    this.tableId = builder.tableId;
    this.formId = builder.formId;
    this.fieldId = builder.fieldId;
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAppToken() {
    return this.appToken;
  }

  public void setAppToken(String appToken) {
    this.appToken = appToken;
  }

  public String getTableId() {
    return this.tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public String getFormId() {
    return this.formId;
  }

  public void setFormId(String formId) {
    this.formId = formId;
  }

  public String getFieldId() {
    return this.fieldId;
  }

  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

  public AppTableFormPatchedField getAppTableFormPatchedField() {
    return this.body;
  }

  public void setAppTableFormPatchedField(AppTableFormPatchedField body) {
    this.body = body;
  }

  public static class Builder {

    private String appToken;
    private String tableId;
    private String formId;
    private String fieldId;
    private AppTableFormPatchedField body;

    public Builder appToken(String appToken) {
      this.appToken = appToken;
      return this;
    }

    public Builder tableId(String tableId) {
      this.tableId = tableId;
      return this;
    }

    public Builder formId(String formId) {
      this.formId = formId;
      return this;
    }

    public Builder fieldId(String fieldId) {
      this.fieldId = fieldId;
      return this;
    }

    public AppTableFormPatchedField getAppTableFormPatchedField() {
      return this.body;
    }

    public Builder appTableFormPatchedField(AppTableFormPatchedField body) {
      this.body = body;
      return this;
    }

    public PatchAppTableFormFieldReq build() {
      return new PatchAppTableFormFieldReq(this);
    }
  }
}