// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.lark.oapi.core.annotation.Body;

public class CreateDataSourceReq {

  @Body
  private DataSource body;

  // builder 开始
  public CreateDataSourceReq() {
  }

  public CreateDataSourceReq(Builder builder) {
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public DataSource getDataSource() {
    return this.body;
  }

  public void setDataSource(DataSource body) {
    this.body = body;
  }

  public static class Builder {

    private DataSource body;

    public DataSource getDataSource() {
      return this.body;
    }

    public Builder dataSource(DataSource body) {
      this.body = body;
      return this;
    }

    public CreateDataSourceReq build() {
      return new CreateDataSourceReq(this);
    }
  }
}