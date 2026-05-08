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
        this.current = initial == null ? new LinkedHashMap<String, Object>() : new LinkedHashMap<String, Object>(initial);
        this.throttle = new Throttle(sender.getStreamThrottleMs(), sender.getStreamThrottleChars(), new Throttle.FireAction() {
            @Override
            public void fire() throws Exception {
                patch();
            }
        });
    }

    @Override
    public void update(Map<String, Object> next) {
        try {
            current = next == null ? new LinkedHashMap<String, Object>() : new LinkedHashMap<String, Object>(next);
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
        final Map<String, Object> snapshot = new LinkedHashMap<String, Object>(current);
        queue.enqueue(new UpdateQueue.QueueTask() {
            @Override
            public void run() throws Exception {
                sender.patchCard(messageId, snapshot);
            }
        });
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
        Map<String, Object> copy = new LinkedHashMap<String, Object>(card == null ? new LinkedHashMap<String, Object>() : card);
        List<Object> elements = new ArrayList<Object>();
        Object bodyObject = copy.get("elements");
        if (bodyObject instanceof List) {
            elements.addAll((List<?>) bodyObject);
        } else if (copy.get("body") instanceof Map && ((Map<?, ?>) copy.get("body")).get("elements") instanceof List) {
            elements.addAll((List<?>) ((Map<?, ?>) copy.get("body")).get("elements"));
            Map<String, Object> body = new LinkedHashMap<String, Object>((Map<String, Object>) copy.get("body"));
            body.put("elements", appendWarning(elements));
            copy.put("body", body);
            return copy;
        }
        copy.put("elements", appendWarning(elements));
        return copy;
    }

    private List<Object> appendWarning(List<Object> elements) {
        List<Object> output = new ArrayList<Object>(elements);
        Map<String, Object> note = new LinkedHashMap<String, Object>();
        note.put("tag", "note");
        note.put("elements", java.util.Collections.singletonList(java.util.Collections.singletonMap("tag", "plain_text")));
        output.add(note);
        return output;
    }
}
