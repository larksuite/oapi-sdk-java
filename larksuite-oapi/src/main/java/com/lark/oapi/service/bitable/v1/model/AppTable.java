// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class AppTable {

  @SerializedName("table_id")
  private String tableId;
  @SerializedName("revision")
  private Integer revision;
  @SerializedName("name")
  private String name;

  // builder 开始
  public AppTable() {
  }

  public AppTable(Builder builder) {
    this.tableId = builder.tableId;
    this.revision = builder.revision;
    this.name = builder.name;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTableId() {
    return this.tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public Integer getRevision() {
    return this.revision;
  }

  public void setRevision(Integer revision) {
    this.revision = revision;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static class Builder {

    private String tableId;
    private Integer revision;
    private String name;

    public Builder tableId(String tableId) {
      this.tableId = tableId;
      return this;
    }

    public Builder revision(Integer revision) {
      this.revision = revision;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }


    public AppTable build() {
      return new AppTable(this);
    }
  }
}