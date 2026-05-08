package com.lark.oapi.channel.model;

public class ResourceDescriptor {
    private final String type;
    private final String fileKey;
    private final String fileName;
    private final Long durationMs;
    private final String coverImageKey;

    public ResourceDescriptor(String type, String fileKey, String fileName, Long durationMs) {
        this(type, fileKey, fileName, durationMs, null);
    }

    public ResourceDescriptor(String type, String fileKey, String fileName, Long durationMs, String coverImageKey) {
        this.type = type;
        this.fileKey = fileKey;
        this.fileName = fileName;
        this.durationMs = durationMs;
        this.coverImageKey = coverImageKey;
    }

    public String getType() {
        return type;
    }

    public String getFileKey() {
        return fileKey;
    }

    public String getFileName() {
        return fileName;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public String getCoverImageKey() {
        return coverImageKey;
    }
}
