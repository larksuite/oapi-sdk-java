package com.lark.oapi.channel.normalize;

import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.CommentEvent;
import com.lark.oapi.core.utils.Jsons;
import java.util.Map;

public class CommentNormalizer {
    public CommentEvent normalize(Map<String, Object> payload) {
        if (payload == null) {
            return null;
        }
        return normalize(Jsons.DEFAULT.fromJson(Jsons.DEFAULT.toJson(payload), JsonObject.class), payload);
    }

    public CommentEvent normalize(JsonObject payload) {
        return normalize(payload, payload);
    }

    public CommentEvent normalize(JsonObject payload, Object raw) {
        if (payload == null) {
            return null;
        }
        JsonObject noticeMeta = payload.has("notice_meta") && payload.get("notice_meta").isJsonObject()
                ? payload.getAsJsonObject("notice_meta")
                : null;
        String fileToken = NormalizeJsons.optString(payload, "file_token");
        if (isBlank(fileToken) && noticeMeta != null) {
            fileToken = NormalizeJsons.optString(noticeMeta, "file_token");
        }
        String fileType = NormalizeJsons.optString(payload, "file_type");
        if (isBlank(fileType) && noticeMeta != null) {
            fileType = NormalizeJsons.optString(noticeMeta, "file_type");
        }
        String commentId = NormalizeJsons.optString(payload, "comment_id");
        String replyId = NormalizeJsons.optString(payload, "reply_id");
        JsonObject operator = noticeMeta != null && noticeMeta.has("from_user_id") && noticeMeta.get("from_user_id").isJsonObject()
                ? noticeMeta.getAsJsonObject("from_user_id")
                : payload.has("user_id") && payload.get("user_id").isJsonObject() ? payload.getAsJsonObject("user_id") : null;
        String operatorId = operator == null ? null
                : NormalizeTexts.firstNonBlank(
                        NormalizeJsons.optString(operator, "open_id"),
                        NormalizeJsons.optString(operator, "user_id"),
                        NormalizeJsons.optString(operator, "union_id"));
        boolean mentionedBot = parseBoolean(payload, "is_mentioned") || parseBoolean(payload, "is_mention")
                || (noticeMeta != null && parseBoolean(noticeMeta, "is_mentioned"));
        String timestampValue = NormalizeJsons.optString(payload, "create_time");
        if (isBlank(timestampValue) && noticeMeta != null) {
            timestampValue = NormalizeJsons.optString(noticeMeta, "timestamp");
        }
        if (isBlank(timestampValue)) {
            timestampValue = NormalizeJsons.optString(payload, "action_time");
        }
        if (isBlank(fileToken) || isBlank(commentId) || isBlank(operatorId)) {
            return null;
        }
        return new CommentEvent(fileToken, fileType, commentId, replyId, operatorId, mentionedBot,
                NormalizeTexts.parseLong(timestampValue), raw);
    }

    private boolean parseBoolean(JsonObject object, String key) {
        if (object == null || !object.has(key) || object.get(key).isJsonNull()) {
            return false;
        }
        try {
            return object.get(key).getAsBoolean();
        } catch (Exception ignored) {
            return false;
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }
}
