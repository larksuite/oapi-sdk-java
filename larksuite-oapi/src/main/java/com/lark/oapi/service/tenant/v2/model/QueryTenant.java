// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.tenant.v2.model;

import com.google.gson.annotations.SerializedName;

public class QueryTenant {

  @SerializedName("tenant")
  private Tenant tenant;

  public Tenant getTenant() {
    return this.tenant;
  }

  public void setTenant(Tenant tenant) {
    this.tenant = tenant;
  }

}
