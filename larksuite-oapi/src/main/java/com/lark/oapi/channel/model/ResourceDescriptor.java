package com.lark.oapi.channel.model;

/**
 * Resource reference extracted from an inbound message.
 */
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

    /**
     * Resource type such as {@code image}, {@code file}, {@code audio} or {@code video}.
     */
    public String getType() {
        return type;
    }

    /**
     * Feishu file key used by download APIs.
     */
    public String getFileKey() {
        return fileKey;
    }

    /**
     * Original file name when Feishu provides it.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Audio/video duration in milliseconds when present.
     */
    public Long getDurationMs() {
        return durationMs;
    }

    /**
     * Video cover image key when present.
     */
    public String getCoverImageKey() {
        return coverImageKey;
    }
}
