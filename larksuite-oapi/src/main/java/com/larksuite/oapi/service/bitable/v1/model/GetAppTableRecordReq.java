// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class GetAppTableRecordReq {
    @Query
    @SerializedName("text_field_as_array")
    private Boolean textFieldAsArray;
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Query
    @SerializedName("display_formula_ref")
    private Boolean displayFormulaRef;
    @Query
    @SerializedName("automatic_fields")
    private Boolean automaticFields;
    @Path
    @SerializedName("app_token")
    private String appToken;
    @Path
    @SerializedName("table_id")
    private String tableId;
    @Path
    @SerializedName("record_id")
    private String recordId;

    // builder 开始
    public GetAppTableRecordReq() {
    }

    public GetAppTableRecordReq(Builder builder) {
        this.textFieldAsArray = builder.textFieldAsArray;
        this.userIdType = builder.userIdType;
        this.displayFormulaRef = builder.displayFormulaRef;
        this.automaticFields = builder.automaticFields;
        this.appToken = builder.appToken;
        this.tableId = builder.tableId;
        this.recordId = builder.recordId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getTextFieldAsArray() {
        return this.textFieldAsArray;
    }

    public void setTextFieldAsArray(Boolean textFieldAsArray) {
        this.textFieldAsArray = textFieldAsArray;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public Boolean getDisplayFormulaRef() {
        return this.displayFormulaRef;
    }

    public void setDisplayFormulaRef(Boolean displayFormulaRef) {
        this.displayFormulaRef = displayFormulaRef;
    }

    public Boolean getAutomaticFields() {
        return this.automaticFields;
    }

    public void setAutomaticFields(Boolean automaticFields) {
        this.automaticFields = automaticFields;
    }

    public String getAppToken() {
        return this.appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public static class Builder {
        private Boolean textFieldAsArray;
        private String userIdType;
        private Boolean displayFormulaRef;
        private Boolean automaticFields;
        private String appToken;
        private String tableId;
        private String recordId;

        public Builder textFieldAsArray(Boolean textFieldAsArray) {
            this.textFieldAsArray = textFieldAsArray;
            return this;
        }

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.bitable.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder displayFormulaRef(Boolean displayFormulaRef) {
            this.displayFormulaRef = displayFormulaRef;
            return this;
        }

        public Builder automaticFields(Boolean automaticFields) {
            this.automaticFields = automaticFields;
            return this;
        }

        public Builder appToken(String appToken) {
            this.appToken = appToken;
            return this;
        }

        public Builder tableId(String tableId) {
            this.tableId = tableId;
            return this;
        }

        public Builder recordId(String recordId) {
            this.recordId = recordId;
            return this;
        }

        public GetAppTableRecordReq build() {
            return new GetAppTableRecordReq(this);
        }
    }
}
