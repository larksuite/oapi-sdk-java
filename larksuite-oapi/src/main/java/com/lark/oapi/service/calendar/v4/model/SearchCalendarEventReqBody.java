// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class SearchCalendarEventReqBody {

  @SerializedName("query")
  private String query;
  @SerializedName("filter")
  private EventSearchFilter filter;

  // builder 开始
  public SearchCalendarEventReqBody() {
  }

  public SearchCalendarEventReqBody(Builder builder) {
    this.query = builder.query;
    this.filter = builder.filter;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getQuery() {
    return this.query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public EventSearchFilter getFilter() {
    return this.filter;
  }

  public void setFilter(EventSearchFilter filter) {
    this.filter = filter;
  }

  public static class Builder {

    private String query;
    private EventSearchFilter filter;

    public Builder query(String query) {
      this.query = query;
      return this;
    }

    public Builder filter(EventSearchFilter filter) {
      this.filter = filter;
      return this;
    }


    public SearchCalendarEventReqBody build() {
      return new SearchCalendarEventReqBody(this);
    }
  }
}