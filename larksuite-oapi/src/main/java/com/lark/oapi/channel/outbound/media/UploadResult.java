package com.lark.oapi.channel.outbound.media;

public class UploadResult {
    private final String kind;
    private final String fileKey;
    private final Integer durationMs;

    public UploadResult(String kind, String fileKey, Integer durationMs) {
        this.kind = kind;
        this.fileKey = fileKey;
        this.durationMs = durationMs;
    }

    public String getKind() {
        return kind;
    }

    public String getFileKey() {
        return fileKey;
    }

    public Integer getDurationMs() {
        return durationMs;
    }
}
