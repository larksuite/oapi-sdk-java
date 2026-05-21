package com.lark.oapi.channel.normalize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.channel.model.CardActionEvent;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class CardActionNormalizer {
    public CardActionEvent normalize(P2CardActionTrigger event) {
        if (event == null) {
            return null;
        }
        JsonObject payload = fallbackPayload(event);
        String messageId = event.getEvent() == null || event.getEvent().getContext() == null
                ? null : event.getEvent().getContext().getOpenMessageId();
        if (isBlank(messageId)) {
            messageId = optString(context(payload), "open_message_id");
        }
        String chatId = event.getEvent() == null || event.getEvent().getContext() == null
                ? null : event.getEvent().getContext().getOpenChatId();
        if (isBlank(chatId)) {
            chatId = optString(context(payload), "open_chat_id");
        }
        String operatorId = event.getEvent() == null || event.getEvent().getOperator() == null ? null : firstNonBlank(
                event.getEvent().getOperator().getOpenId(),
                event.getEvent().getOperator().getUserId(),
                event.getEvent().getOperator().getUnionId());
        if (isBlank(operatorId)) {
            JsonObject operator = payload == null ? null : payload.getAsJsonObject("operator");
            operatorId = operator == null ? null : firstNonBlank(
                    optString(operator, "open_id"),
                    optString(operator, "user_id"),
                    optString(operator, "union_id"));
        }
        if (isBlank(messageId) || isBlank(chatId) || isBlank(operatorId)) {
            return null;
        }
        JsonObject actionJson = payload == null ? null : payload.getAsJsonObject("action");
        String actionTag = event.getEvent() == null || event.getEvent().getAction() == null || isBlank(event.getEvent().getAction().getTag())
                ? "unknown"
                : event.getEvent().getAction().getTag();
        if ("unknown".equals(actionTag)) {
            actionTag = firstNonBlank(optString(actionJson, "tag"), "unknown", "unknown");
        }
        String actionName = event.getEvent() == null || event.getEvent().getAction() == null ? null : event.getEvent().getAction().getName();
        if (actionName == null) {
            actionName = optString(actionJson, "name");
        }
        String actionOption = event.getEvent() == null || event.getEvent().getAction() == null ? null : event.getEvent().getAction().getOption();
        if (actionOption == null) {
            actionOption = optString(actionJson, "option");
        }
        Map<String, Object> actionValue = event.getEvent() == null || event.getEvent().getAction() == null ? null : event.getEvent().getAction().getValue();
        if ((actionValue == null || actionValue.isEmpty()) && actionJson != null && actionJson.has("value")) {
            actionValue = toMap(actionJson.get("value"));
        }
        return new CardActionEvent(messageId, chatId, operatorId, actionTag, actionName, actionOption, actionValue, event);
    }

    private JsonObject fallbackPayload(P2CardActionTrigger event) {
        EventReq req = event.getEventReq();
        if (req == null) {
            return null;
        }
        String plain = req.getPlain();
        if ((plain == null || plain.isEmpty()) && req.getBody() != null) {
            plain = new String(req.getBody(), StandardCharsets.UTF_8);
        }
        if (plain == null || plain.trim().isEmpty()) {
            return null;
        }
        try {
            JsonObject root = JsonParser.parseString(plain).getAsJsonObject();
            if (root.has("event") && root.get("event").isJsonObject()) {
                return root.getAsJsonObject("event");
            }
            return root;
        } catch (Exception ignored) {
            return null;
        }
    }

    private JsonObject context(JsonObject payload) {
        if (payload == null) {
            return null;
        }
        if (payload.has("context") && payload.get("context").isJsonObject()) {
            return payload.getAsJsonObject("context");
        }
        return payload;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> toMap(JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return null;
        }
        if (element.isJsonObject()) {
            return Jsons.DEFAULT.fromJson(element, Map.class);
        }
        return Collections.singletonMap("value", Jsons.DEFAULT.fromJson(element, Object.class));
    }

    private String optString(JsonObject object, String key) {
        if (object == null || key == null || !object.has(key) || object.get(key).isJsonNull()) {
            return null;
        }
        return object.get(key).getAsString();
    }

    private String firstNonBlank(String first, String second, String third) {
        if (!isBlank(first)) {
            return first;
        }
        if (!isBlank(second)) {
            return second;
        }
        return third;
    }

    private boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }
}
