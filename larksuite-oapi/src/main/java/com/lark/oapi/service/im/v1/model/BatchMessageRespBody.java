package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class BatchMessageRespBody {

    /**
     * 批量消息 ID
     * <p> 示例值：om_dc13264520392913993dd051dba21dcf
     */
    @SerializedName("message_id")
    private String messageId;

    /**
     * 不合法的部门 ID 列表
     * <p> 示例值：["3dceba33a33226","d502aaa9514059", "od-5b91c9affb665451a16b90b4be367efa"]
     */
    @SerializedName("invalid_department_ids")
    private String[] invalidDepartmentIds;

    /**
     * 不合法的 open_id 列表
     * <p> 示例值：["ou_18eac85d35a26f989317ad4f02e8bbbb","ou_461cf042d9eedaa60d445f26dc747d5e"]
     */
    @SerializedName("invalid_open_ids")
    private String[] invalidOpenIds;

    /**
     * 不合法的 user_id 列表（对应V3接口的invalid_employee_ids）
     * <p> 示例值：["7cdcc7c2","ca51d83b"]
     */
    @SerializedName("invalid_user_ids")
    private String[] invalidUserIds;

    /**
     * 不合法的 union_id 列表
     * <p> 示例值：["on_cad4860e7af114fb4ff6c5d496d1dd76","on_gdcq860e7af114fb4ff6c5d496dabcet"]
     */
    @SerializedName("invalid_union_ids")
    private String[] invalidUnionIds;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String[] getInvalidDepartmentIds() {
        return invalidDepartmentIds;
    }

    public void setInvalidDepartmentIds(String[] invalidDepartmentIds) {
        this.invalidDepartmentIds = invalidDepartmentIds;
    }

    public String[] getInvalidOpenIds() {
        return invalidOpenIds;
    }

    public void setInvalidOpenIds(String[] invalidOpenIds) {
        this.invalidOpenIds = invalidOpenIds;
    }

    public String[] getInvalidUserIds() {
        return invalidUserIds;
    }

    public void setInvalidUserIds(String[] invalidUserIds) {
        this.invalidUserIds = invalidUserIds;
    }

    public String[] getInvalidUnionIds() {
        return invalidUnionIds;
    }

    public void setInvalidUnionIds(String[] invalidUnionIds) {
        this.invalidUnionIds = invalidUnionIds;
    }
}
