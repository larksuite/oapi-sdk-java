// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class Person {

  @SerializedName("id")
  private String id;
  @SerializedName("name")
  private String name;
  @SerializedName("en_name")
  private String enName;
  @SerializedName("email")
  private String email;

  // builder 开始
  public Person() {
  }

  public Person(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.enName = builder.enName;
    this.email = builder.email;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEnName() {
    return this.enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static class Builder {

    private String id;
    private String name;
    private String enName;
    private String email;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder enName(String enName) {
      this.enName = enName;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }


    public Person build() {
      return new Person(this);
    }
  }
}