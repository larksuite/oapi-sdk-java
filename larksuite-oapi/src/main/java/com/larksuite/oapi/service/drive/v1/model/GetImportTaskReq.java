// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class GetImportTaskReq {
    @Path
    @SerializedName("ticket")
    private String ticket;

    // builder 开始
    public GetImportTaskReq() {
    }

    public GetImportTaskReq(Builder builder) {
        this.ticket = builder.ticket;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public static class Builder {

        private String ticket;

        public Builder ticket(String ticket) {
            this.ticket = ticket;
            return this;
        }

        public GetImportTaskReq build() {
            return new GetImportTaskReq(this);
        }
    }
}