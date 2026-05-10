package com.lark.oapi.channel.outbound.streaming;

import com.lark.oapi.channel.model.CardStreamController;
import com.lark.oapi.channel.model.CardStreamProducer;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.outbound.OutboundRouting;
import com.lark.oapi.channel.outbound.OutboundSender;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CardStreamControllerImpl implements CardStreamController {
    private final OutboundSender sender;
    private final String to;
    private final OutboundRouting.ReceiveIdType idType;
    private final SendOptions options;
    private final Throttle throttle;
    private final UpdateQueue queue = new UpdateQueue();
    private Map<String, Object> current;
    private String messageId = "";

    public CardStreamControllerImpl(OutboundSender sender, String to, OutboundRouting.ReceiveIdType idType,
                                    SendOptions options, Map<String, Object> initial) {
        this.sender = sender;
        this.to = to;
        this.idType = idType;
        this.options = options;
        this.current = initial == null ? new LinkedHashMap<>() : new LinkedHashMap<>(initial);
        this.throttle = new Throttle(sender.getStreamThrottleMs(), sender.getStreamThrottleChars(), this::patch);
    }

    @Override
    public void update(Map<String, Object> next) {
        try {
            current = next == null ? new LinkedHashMap<>() : new LinkedHashMap<>(next);
            throttle.note(sender.toJson(current).length());
        } catch (Exception e) {
            throw sender.wrapStreamingException("card stream update failed", e);
        }
    }

    @Override
    public Map<String, Object> getCurrent() {
        return current;
    }

    @Override
    public String getMessageId() {
        return messageId;
    }

    public SendResult run(CardStreamProducer producer) {
        try {
            sendInitial();
            producer.produce(this);
            completeTerminal();
            return new SendResult(messageId);
        } catch (Exception e) {
            failTerminal();
            throw sender.wrapStreamingException("card stream failed", e);
        }
    }

    private void sendInitial() throws Exception {
        messageId = sender.sendOneWithFallback(to, idType, "interactive", current, options);
    }

    private void patch() throws Exception {
        final Map<String, Object> snapshot = new LinkedHashMap<>(current);
        queue.enqueue(() -> sender.patchCard(messageId, snapshot));
    }

    private void completeTerminal() throws Exception {
        throttle.flushNow();
        queue.drain();
    }

    private void failTerminal() {
        try {
            throttle.dispose();
            sender.patchCard(messageId, appendErrorFooter(current));
        } catch (Exception ignored) {
        }
    }

    private Map<String, Object> appendErrorFooter(Map<String, Object> card) {
        Map<String, Object> copy = new LinkedHashMap<>();
        if (card != null) {
            copy.putAll(card);
        }
        List<Object> elements = new ArrayList<>();
        Object bodyObject = copy.get("elements");
        if (bodyObject instanceof List) {
            elements.addAll((List<?>) bodyObject);
        } else if (copy.get("body") instanceof Map) {
            Map<?, ?> originalBody = (Map<?, ?>) copy.get("body");
            Object bodyElements = originalBody.get("elements");
            if (bodyElements instanceof List) {
                elements.addAll((List<?>) bodyElements);
                Map<String, Object> body = copyObjectMap(originalBody);
                body.put("elements", appendWarning(elements));
                copy.put("body", body);
                return copy;
            }
        }
        copy.put("elements", appendWarning(elements));
        return copy;
    }

    private Map<String, Object> copyObjectMap(Map<?, ?> source) {
        Map<String, Object> copy = new LinkedHashMap<>();
        for (Map.Entry<?, ?> entry : source.entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                copy.put((String) key, entry.getValue());
            }
        }
        return copy;
    }

    private List<Object> appendWarning(List<Object> elements) {
        List<Object> output = new ArrayList<>(elements);
        Map<String, Object> note = new LinkedHashMap<>();
        note.put("tag", "note");
        Map<String, Object> text = new LinkedHashMap<>();
        text.put("tag", "plain_text");
        text.put("content", "Generation interrupted");
        note.put("elements", java.util.Collections.singletonList(text));
        output.add(note);
        return output;
    }
}
