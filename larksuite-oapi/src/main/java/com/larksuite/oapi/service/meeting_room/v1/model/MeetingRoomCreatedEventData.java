// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.meeting_room.v1.model;

import com.google.gson.annotations.SerializedName;

public class MeetingRoomCreatedEventData {
    @SerializedName("room_name")
    private String roomName;
    @SerializedName("room_id")
    private String roomId;

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

}
