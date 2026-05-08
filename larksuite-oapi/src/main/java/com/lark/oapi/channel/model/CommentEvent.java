package com.lark.oapi.channel.model;

public class CommentEvent {
    private final String fileToken;
    private final String fileType;
    private final String commentId;
    private final String replyId;
    private final String operatorId;
    private final boolean mentionedBot;
    private final long timestamp;
    private final Object raw;

    public CommentEvent(String fileToken, String fileType, String commentId, String replyId,
                        String operatorId, boolean mentionedBot, long timestamp, Object raw) {
        this.fileToken = fileToken;
        this.fileType = fileType;
        this.commentId = commentId;
        this.replyId = replyId;
        this.operatorId = operatorId;
        this.mentionedBot = mentionedBot;
        this.timestamp = timestamp;
        this.raw = raw;
    }

    public String getFileToken() { return fileToken; }
    public String getFileType() { return fileType; }
    public String getCommentId() { return commentId; }
    public String getReplyId() { return replyId; }
    public String getOperatorId() { return operatorId; }
    public boolean isMentionedBot() { return mentionedBot; }
    public long getTimestamp() { return timestamp; }
    public Object getRaw() { return raw; }
}
