// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.meeting_room.v1.model;
import com.google.gson.annotations.SerializedName;

public class RoomBatchGetIdResult {
    @SerializedName("rooms")
    private RoomId[] rooms;

    public RoomId[] getRooms() {
        return this.rooms;
    }

    public void setRooms(RoomId[] rooms) {
        this.rooms = rooms;
    }

}
