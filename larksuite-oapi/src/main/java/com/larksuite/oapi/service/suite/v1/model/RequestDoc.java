// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.suite.v1.model;
import com.google.gson.annotations.SerializedName;

public class RequestDoc {
    @SerializedName("docs_token")
    private String docsToken;
    @SerializedName("docs_type")
    private String docsType;

    public String getDocsToken() {
        return this.docsToken;
    }

    public void setDocsToken(String docsToken) {
        this.docsToken = docsToken;
    }

    public String getDocsType() {
        return this.docsType;
    }

    public void setDocsType(String docsType) {
        this.docsType = docsType;
    }

}
