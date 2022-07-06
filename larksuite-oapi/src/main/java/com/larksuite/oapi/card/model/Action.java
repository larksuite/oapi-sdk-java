package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Action {
    @SerializedName("value")
    private Map<String, Object> value;
    @SerializedName("tag")
    private String tag;
    @SerializedName("option")
    private String option;
    @SerializedName("timezone")
    private String timezone;

    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Action{" +
                "value=" + value +
                ", tag='" + tag + '\'' +
                ", option='" + option + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
