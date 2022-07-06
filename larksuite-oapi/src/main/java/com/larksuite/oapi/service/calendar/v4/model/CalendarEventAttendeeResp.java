// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class CalendarEventAttendeeResp {
    @SerializedName("type")
    private String type;
    @SerializedName("attendee_id")
    private String attendeeId;
    @SerializedName("rsvp_status")
    private String rsvpStatus;
    @SerializedName("is_optional")
    private Boolean isOptional;
    @SerializedName("is_organizer")
    private Boolean isOrganizer;
    @SerializedName("is_external")
    private Boolean isExternal;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("chat_members")
    private AttendeeChatMember[] chatMembers;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("chat_id")
    private String chatId;
    @SerializedName("room_id")
    private String roomId;
    @SerializedName("third_party_email")
    private String thirdPartyEmail;
    @SerializedName("operate_id")
    private String operateId;
    @SerializedName("resource_customization")
    private CalendarAttendeeResourceCustomization[] resourceCustomization;

    // builder 开始
    public CalendarEventAttendeeResp() {
    }

    public CalendarEventAttendeeResp(Builder builder) {
        this.type = builder.type;
        this.attendeeId = builder.attendeeId;
        this.rsvpStatus = builder.rsvpStatus;
        this.isOptional = builder.isOptional;
        this.isOrganizer = builder.isOrganizer;
        this.isExternal = builder.isExternal;
        this.displayName = builder.displayName;
        this.chatMembers = builder.chatMembers;
        this.userId = builder.userId;
        this.chatId = builder.chatId;
        this.roomId = builder.roomId;
        this.thirdPartyEmail = builder.thirdPartyEmail;
        this.operateId = builder.operateId;
        this.resourceCustomization = builder.resourceCustomization;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttendeeId() {
        return this.attendeeId;
    }

    public void setAttendeeId(String attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getRsvpStatus() {
        return this.rsvpStatus;
    }

    public void setRsvpStatus(String rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }

    public Boolean getIsOptional() {
        return this.isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public Boolean getIsOrganizer() {
        return this.isOrganizer;
    }

    public void setIsOrganizer(Boolean isOrganizer) {
        this.isOrganizer = isOrganizer;
    }

    public Boolean getIsExternal() {
        return this.isExternal;
    }

    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AttendeeChatMember[] getChatMembers() {
        return this.chatMembers;
    }

    public void setChatMembers(AttendeeChatMember[] chatMembers) {
        this.chatMembers = chatMembers;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getThirdPartyEmail() {
        return this.thirdPartyEmail;
    }

    public void setThirdPartyEmail(String thirdPartyEmail) {
        this.thirdPartyEmail = thirdPartyEmail;
    }

    public String getOperateId() {
        return this.operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    public CalendarAttendeeResourceCustomization[] getResourceCustomization() {
        return this.resourceCustomization;
    }

    public void setResourceCustomization(CalendarAttendeeResourceCustomization[] resourceCustomization) {
        this.resourceCustomization = resourceCustomization;
    }

    public static class Builder {
        private String type;
        private String attendeeId;
        private String rsvpStatus;
        private Boolean isOptional;
        private Boolean isOrganizer;
        private Boolean isExternal;
        private String displayName;
        private AttendeeChatMember[] chatMembers;
        private String userId;
        private String chatId;
        private String roomId;
        private String thirdPartyEmail;
        private String operateId;
        private CalendarAttendeeResourceCustomization[] resourceCustomization;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder type(com.larksuite.oapi.service.calendar.v4.enums.EventAttendeeTypeEnum type) {
            this.type = type.getValue();
            return this;
        }

        public Builder attendeeId(String attendeeId) {
            this.attendeeId = attendeeId;
            return this;
        }

        public Builder rsvpStatus(String rsvpStatus) {
            this.rsvpStatus = rsvpStatus;
            return this;
        }

        public Builder rsvpStatus(com.larksuite.oapi.service.calendar.v4.enums.RsvpStatusEnum rsvpStatus) {
            this.rsvpStatus = rsvpStatus.getValue();
            return this;
        }

        public Builder isOptional(Boolean isOptional) {
            this.isOptional = isOptional;
            return this;
        }

        public Builder isOrganizer(Boolean isOrganizer) {
            this.isOrganizer = isOrganizer;
            return this;
        }

        public Builder isExternal(Boolean isExternal) {
            this.isExternal = isExternal;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder chatMembers(AttendeeChatMember[] chatMembers) {
            this.chatMembers = chatMembers;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public Builder roomId(String roomId) {
            this.roomId = roomId;
            return this;
        }

        public Builder thirdPartyEmail(String thirdPartyEmail) {
            this.thirdPartyEmail = thirdPartyEmail;
            return this;
        }

        public Builder operateId(String operateId) {
            this.operateId = operateId;
            return this;
        }

        public Builder resourceCustomization(CalendarAttendeeResourceCustomization[] resourceCustomization) {
            this.resourceCustomization = resourceCustomization;
            return this;
        }


        public CalendarEventAttendeeResp build() {
            return new CalendarEventAttendeeResp(this);
        }
    }
}
