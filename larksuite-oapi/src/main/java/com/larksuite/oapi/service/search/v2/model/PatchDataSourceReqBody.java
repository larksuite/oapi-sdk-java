// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;

public class PatchDataSourceReqBody {
    @SerializedName("name")
    private String name;
    @SerializedName("state")
    private Integer state;
    @SerializedName("description")
    private String description;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("i18n_name")
    private ItemMetadata i18nName;
    @SerializedName("i18n_description")
    private I18nMeta i18nDescription;

    // builder 开始
    public PatchDataSourceReqBody() {
    }

    public PatchDataSourceReqBody(Builder builder) {
        this.name = builder.name;
        this.state = builder.state;
        this.description = builder.description;
        this.iconUrl = builder.iconUrl;
        this.i18nName = builder.i18nName;
        this.i18nDescription = builder.i18nDescription;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public ItemMetadata getI18nName() {
        return this.i18nName;
    }

    public void setI18nName(ItemMetadata i18nName) {
        this.i18nName = i18nName;
    }

    public I18nMeta getI18nDescription() {
        return this.i18nDescription;
    }

    public void setI18nDescription(I18nMeta i18nDescription) {
        this.i18nDescription = i18nDescription;
    }

    public static class Builder {
        private String name;
        private Integer state;
        private String description;
        private String iconUrl;
        private ItemMetadata i18nName;
        private I18nMeta i18nDescription;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder state(Integer state) {
            this.state = state;
            return this;
        }

        public Builder state(com.larksuite.oapi.service.search.v2.enums.StateEnum state) {
            this.state = state.getValue();
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder iconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public Builder i18nName(ItemMetadata i18nName) {
            this.i18nName = i18nName;
            return this;
        }

        public Builder i18nDescription(I18nMeta i18nDescription) {
            this.i18nDescription = i18nDescription;
            return this;
        }


        public PatchDataSourceReqBody build() {
            return new PatchDataSourceReqBody(this);
        }
    }
}