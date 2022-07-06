// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Query;

public class QueryRoomConfigReq {
    @Query
    @SerializedName("scope")
    private Integer scope;
    @Query
    @SerializedName("country_id")
    private String countryId;
    @Query
    @SerializedName("district_id")
    private String districtId;
    @Query
    @SerializedName("building_id")
    private String buildingId;
    @Query
    @SerializedName("floor_name")
    private String floorName;
    @Query
    @SerializedName("room_id")
    private String roomId;
    @Query
    @SerializedName("user_id_type")
    private String userIdType;

    // builder 开始
    public QueryRoomConfigReq() {
    }

    public QueryRoomConfigReq(Builder builder) {
        this.scope = builder.scope;
        this.countryId = builder.countryId;
        this.districtId = builder.districtId;
        this.buildingId = builder.buildingId;
        this.floorName = builder.floorName;
        this.roomId = builder.roomId;
        this.userIdType = builder.userIdType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getScope() {
        return this.scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getDistrictId() {
        return this.districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public static class Builder {
        private Integer scope;
        private String countryId;
        private String districtId;
        private String buildingId;
        private String floorName;
        private String roomId;
        private String userIdType;

        public Builder scope(Integer scope) {
            this.scope = scope;
            return this;
        }

        public Builder scope(com.larksuite.oapi.service.vc.v1.enums.NodeScopeEnum scope) {
            this.scope = scope.getValue();
            return this;
        }

        public Builder countryId(String countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder districtId(String districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder buildingId(String buildingId) {
            this.buildingId = buildingId;
            return this;
        }

        public Builder floorName(String floorName) {
            this.floorName = floorName;
            return this;
        }

        public Builder roomId(String roomId) {
            this.roomId = roomId;
            return this;
        }

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.vc.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public QueryRoomConfigReq build() {
            return new QueryRoomConfigReq(this);
        }
    }
}