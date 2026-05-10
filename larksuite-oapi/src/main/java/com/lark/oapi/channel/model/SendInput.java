package com.lark.oapi.channel.model;

import java.util.Map;

/**
 * Message payload accepted by {@code LarkChannel.send(...)}.
 *
 * <p>The {@link Kind} enum records the selected shape so the outbound sender
 * can convert it to the correct Feishu message type.
 */
public class SendInput {
    /**
     * Supported outbound message kinds.
     */
    public enum Kind {
        MARKDOWN, TEXT, POST, IMAGE, FILE, AUDIO, VIDEO, CARD, SHARE_CHAT, SHARE_USER, STICKER
    }

    private final Kind kind;
    private final String text;
    private final Map<String, Object> object;

    private SendInput(Kind kind, String text, Map<String, Object> object) {
        this.kind = kind;
        this.text = text;
        this.object = object;
    }

    /**
     * Send Markdown. The channel converts it to Feishu post content and falls
     * back to plain text if Feishu rejects the post format.
     */
    public static SendInput markdown(String markdown) { return new SendInput(Kind.MARKDOWN, markdown, null); }

    /**
     * Send plain text.
     */
    public static SendInput text(String text) { return new SendInput(Kind.TEXT, text, null); }

    /**
     * Send a raw Feishu post object.
     */
    public static SendInput post(Map<String, Object> post) { return new SendInput(Kind.POST, null, post); }

    /**
     * Send an image from a public URL or local path.
     */
    public static SendInput image(String source) { return image((Object) source); }

    /**
     * Send an image from in-memory bytes.
     */
    public static SendInput image(byte[] source) { return image((Object) source); }

    /**
     * Send an image from a supported source: URL, local path, byte array or
     * input stream. URL sources are checked by the SSRF guard before download.
     */
    public static SendInput image(Object source) {
        return new SendInput(Kind.IMAGE, null, mapOf("source", source));
    }

    /**
     * Send a file from a public URL or local path.
     */
    public static SendInput file(String source, String fileName) { return file((Object) source, fileName); }

    /**
     * Send a file from in-memory bytes.
     */
    public static SendInput file(byte[] source, String fileName) { return file((Object) source, fileName); }

    /**
     * Send a file from a supported source. The supplied file name is used for
     * Feishu upload type inference and the visible attachment name.
     */
    public static SendInput file(Object source, String fileName) {
        return new SendInput(Kind.FILE, null, mapOf("source", source, "fileName", fileName));
    }

    /**
     * Send an opus audio message from a URL or local path.
     */
    public static SendInput audio(String source, Integer duration) { return audio((Object) source, duration); }

    /**
     * Send an opus audio message from bytes.
     */
    public static SendInput audio(byte[] source, Integer duration) { return audio((Object) source, duration); }

    /**
     * Send an opus audio message. Duration is passed through to Feishu in
     * milliseconds when provided.
     */
    public static SendInput audio(Object source, Integer duration) {
        return new SendInput(Kind.AUDIO, null, mapOf("source", source, "duration", duration));
    }

    /**
     * Send a video/media message from a URL or local path.
     */
    public static SendInput video(String source, Integer duration, String coverImageKey) { return video((Object) source, duration, coverImageKey); }

    /**
     * Send a video/media message from bytes.
     */
    public static SendInput video(byte[] source, Integer duration, String coverImageKey) { return video((Object) source, duration, coverImageKey); }

    /**
     * Send a video/media message. Feishu expects uploaded videos as media files
     * and optionally accepts a cover image key.
     */
    public static SendInput video(Object source, Integer duration, String coverImageKey) {
        return new SendInput(Kind.VIDEO, null, mapOf("source", source, "duration", duration, "coverImageKey", coverImageKey));
    }

    /**
     * Send an interactive card JSON object.
     */
    public static SendInput card(Map<String, Object> card) { return new SendInput(Kind.CARD, null, card); }

    /**
     * Send a group chat share card.
     */
    public static SendInput shareChat(String chatId) { return new SendInput(Kind.SHARE_CHAT, null, java.util.Collections.<String, Object>singletonMap("chat_id", chatId)); }

    /**
     * Send a user share card.
     */
    public static SendInput shareUser(String userId) { return new SendInput(Kind.SHARE_USER, null, java.util.Collections.<String, Object>singletonMap("user_id", userId)); }

    /**
     * Send a sticker by file key.
     */
    public static SendInput sticker(String fileKey) { return new SendInput(Kind.STICKER, null, java.util.Collections.<String, Object>singletonMap("file_key", fileKey)); }

    public Kind getKind() { return kind; }
    public String getText() { return text; }
    public Map<String, Object> getObject() { return object; }

    private static Map<String, Object> mapOf(Object... pairs) {
        java.util.LinkedHashMap<String, Object> values = new java.util.LinkedHashMap<String, Object>();
        for (int i = 0; i + 1 < pairs.length; i += 2) {
            if (pairs[i + 1] != null) {
                values.put(String.valueOf(pairs[i]), pairs[i + 1]);
            }
        }
        return values;
    }
}
