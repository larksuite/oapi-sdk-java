// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class SearchCalendarResp extends BaseResponse {

    @SerializedName("data")
    private SearchCalendarDTO body;

    public SearchCalendarDTO getSearchCalendarDTO() {
        return this.body;
    }

    public void setSearchCalendarDTO(SearchCalendarDTO body) {
        this.body = body;
    }
}
