// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.ehr.v1.model;
import com.google.gson.annotations.SerializedName;

public class Job {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
