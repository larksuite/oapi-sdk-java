// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.ehr.v1.model;
import com.google.gson.annotations.SerializedName;

public class CustomFields {
    @SerializedName("key")
    private String key;
    @SerializedName("label")
    private String label;
    @SerializedName("type")
    private String type;
    @SerializedName("value")
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}