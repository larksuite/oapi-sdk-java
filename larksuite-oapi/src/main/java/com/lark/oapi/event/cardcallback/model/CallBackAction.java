package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class CallBackAction {

    @SerializedName("value")
    private Map<String, Object> value;

    @SerializedName("tag")
    private String tag;

    @SerializedName("option")
    private String option;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("name")
    private String name;

    @SerializedName("form_value")
    private Map<String, Object> formValue;

    @SerializedName("input_value")
    private String inputValue;

    @SerializedName("options")
    private List<String> options;

    @SerializedName("checked")
    private Boolean checked;

    public Map<String, Object> getValue() {return this.value;}

    public void setValue(Map<String, Object> value) {this.value=value;}

    public String getTag() {return this.tag;}

    public void setTag(String tag) {this.tag=tag;}

    public String getOption() {return this.option;}

    public void setOption(String option) {this.option=option;}

    public String getTimezone() {return this.timezone;}

    public void setTimezone(String timezone) {this.timezone=timezone;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public Map<String, Object> getFormValue() {return this.formValue;}

    public void setFormValue(Map<String, Object> formValue) {this.formValue=formValue;}

    public String getInputValue() {return this.inputValue;}

    public void setInputValue(String inputValue) {this.inputValue=inputValue;}

    public List<String> getOptions() {return this.options;}

    public void setOptions(List<String> options) {this.options=options;}

    public Boolean getChecked() {return this.checked;}

    public void setChecked(Boolean checked) {this.checked=checked;}
}
