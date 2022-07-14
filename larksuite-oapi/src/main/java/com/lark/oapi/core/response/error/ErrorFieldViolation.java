package com.lark.oapi.core.response.error;

import com.google.gson.annotations.SerializedName;

public class ErrorFieldViolation {

  @SerializedName("field")
  private String field;
  @SerializedName("value")
  private String value;
  @SerializedName("description")
  private String description;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "ErrorFieldViolation{" +
        "field='" + field + '\'' +
        ", value='" + value + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
