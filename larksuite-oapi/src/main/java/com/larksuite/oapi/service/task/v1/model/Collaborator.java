// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;

public class Collaborator {
    @SerializedName("id")
    private String id;

    // builder 开始
    public Collaborator() {
    }

    public Collaborator(Builder builder) {
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


        public Collaborator build() {
            return new Collaborator(this);
        }
    }
}
