package com.larksuite.oapi.core.response.error;

import com.google.gson.annotations.SerializedName;

public class ErrorHelp {
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorHelp{" +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
