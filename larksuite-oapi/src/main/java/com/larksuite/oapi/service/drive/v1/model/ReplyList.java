// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;
import com.google.gson.annotations.SerializedName;

public class ReplyList {
    @SerializedName("replies")
    private FileCommentReply[] replies;

    public FileCommentReply[] getReplies() {
        return this.replies;
    }

    public void setReplies(FileCommentReply[] replies) {
        this.replies = replies;
    }

}
