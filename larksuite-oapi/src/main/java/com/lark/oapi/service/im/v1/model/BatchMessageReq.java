package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.model.MessageCard;

public class BatchMessageReq {

    /**
     * 消息类型 text post card image等等
     * <p> 示例值：text
     */
    @SerializedName("msg_type")
    private String messageType;

    /**
     * 消息内容
     * <p> 示例值：{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}
     */
    @SerializedName("content")
    private String content;

    /**
     * 卡片消息内容 注意：card和content字段必须二选一
     * <p> 示例值：
     */
    @SerializedName("card")
    private MessageCard card;

    /**
     * 支持[自定义部门ID](https://open.feishu.cn/document/ukTMukTMukTM/uYTM5UjL2ETO14iNxkTN/terminology#3c3e6267)和open_department_id，列表长度小于等于 200
     * <p> 示例值：["3dceba33a33226","d502aaa9514059", "od-5b91c9affb665451a16b90b4be367efa"]
     */
    @SerializedName("department_ids")
    private String[] departmentIds;

    /**
     * 用户 open_id 列表，长度小于等于 200
     * <p> 示例值：["ou_18eac85d35a26f989317ad4f02e8bbbb","ou_461cf042d9eedaa60d445f26dc747d5e"]
     */
    @SerializedName("open_ids")
    private String[] openIds;

    /**
     * 用户 user_id 列表，长度小于等于 200
     * <p> 示例值：["7cdcc7c2","ca51d83b"]
     */
    @SerializedName("user_ids")
    private String[] userIds;

    /**
     * 用户 union_ids 列表，长度小于等于 200
     * <p> 示例值：["on_cad4860e7af114fb4ff6c5d496d1dd76","on_gdcq860e7af114fb4ff6c5d496dabcet"]
     */
    @SerializedName("union_ids")
    private String[] unionIds;

    /**
     * 由开发者生成的唯一字符串序列，用于发送消息请求去重；持有相同uuid的请求1小时内至多成功执行一次
     * <p> 示例值：a0d69e20-1dd1-458b-k525-dfeca4015204
     */
    @SerializedName("uuid")
    private String uuid;

    public BatchMessageReq() {
    }

    public BatchMessageReq(BatchMessageReq.Builder builder) {
        this.messageType = builder.messageType;
        this.content = builder.content;
        this.card = builder.card;
        this.departmentIds = builder.departmentIds;
        this.openIds = builder.openIds;
        this.userIds = builder.userIds;
        this.unionIds = builder.unionIds;
        this.uuid = builder.uuid;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String messageType;
        private String content;
        private MessageCard card;
        private String[] departmentIds;
        private String[] openIds;
        private String[] userIds;
        private String[] unionIds;
        private String uuid;

        public Builder messageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder card(MessageCard card) {
            this.card = card;
            return this;
        }

        public Builder departmentIds(String[] departmentIds) {
            this.departmentIds = departmentIds;
            return this;
        }

        public Builder openIds(String[] openIds) {
            this.openIds = openIds;
            return this;
        }

        public Builder userIds(String[] userIds) {
            this.userIds = userIds;
            return this;
        }

        public Builder unionIds(String[] unionIds) {
            this.unionIds = unionIds;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public BatchMessageReq build() {
            return new BatchMessageReq(this);
        }
    }

}
