// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class SetPermissionMeetingRecordingReqBody {
    @SerializedName("permission_objects")
    private RecordingPermissionObject[] permissionObjects;

    // builder 开始
    public SetPermissionMeetingRecordingReqBody() {
    }

    public SetPermissionMeetingRecordingReqBody(Builder builder) {
        this.permissionObjects = builder.permissionObjects;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public RecordingPermissionObject[] getPermissionObjects() {
        return this.permissionObjects;
    }

    public void setPermissionObjects(RecordingPermissionObject[] permissionObjects) {
        this.permissionObjects = permissionObjects;
    }

    public static class Builder {
        private RecordingPermissionObject[] permissionObjects;

        public Builder permissionObjects(RecordingPermissionObject[] permissionObjects) {
            this.permissionObjects = permissionObjects;
            return this;
        }


        public SetPermissionMeetingRecordingReqBody build() {
            return new SetPermissionMeetingRecordingReqBody(this);
        }
    }
}
