// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;

public class Abbreviation {
    @SerializedName("id")
    private String id;

    // builder 开始
    public Abbreviation() {
    }

    public Abbreviation(Builder builder) {
        this.id = builder.id;
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

    public static class Builder {
        private String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }


        public Abbreviation build() {
            return new Abbreviation(this);
        }
    }
}