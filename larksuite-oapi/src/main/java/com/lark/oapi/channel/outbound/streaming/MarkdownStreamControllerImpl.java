package com.lark.oapi.channel.outbound.streaming;

import com.lark.oapi.channel.model.MarkdownStreamController;
import com.lark.oapi.channel.model.MarkdownStreamProducer;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.outbound.OutboundRouting;
import com.lark.oapi.channel.outbound.OutboundSender;
import java.util.LinkedHashMap;
import java.util.Map;

public class MarkdownStreamControllerImpl implements MarkdownStreamController {
    private static final String ELEMENT_ID = "stream_md";

    private final OutboundSender sender;
    private final String to;
    private final OutboundRouting.ReceiveIdType idType;
    private final SendOptions options;
    private final Throttle throttle;
    private final UpdateQueue queue = new UpdateQueue();
    private String content = "";
    private String cardId = "";
    private String messageId = "";
    private int sequence;
    private boolean started;

    public MarkdownStreamControllerImpl(OutboundSender sender, String to, OutboundRouting.ReceiveIdType idType,
                                        SendOptions options) {
        this.sender = sender;
        this.to = to;
        this.idType = idType;
        this.options = options;
        this.throttle = new Throttle(sender.getStreamThrottleMs(), sender.getStreamThrottleChars(), this::pushContent);
    }

    @Override
    public void append(String chunk) {
        try {
            if (chunk == null || chunk.isEmpty()) {
                return;
            }
            ensureStarted();
            content = MergeStreamingText.merge(content, chunk);
            throttle.note(chunk.length());
        } catch (Exception e) {
            throw sender.wrapStreamingException("stream append failed", e);
        }
    }

    @Override
    public void setContent(String full) {
        try {
            ensureStarted();
            content = full == null ? "" : full;
            throttle.note(Integer.MAX_VALUE);
        } catch (Exception e) {
            throw sender.wrapStreamingException("stream setContent failed", e);
        }
    }

    @Override
    public String getMessageId() {
        return messageId;
    }

    public SendResult run(MarkdownStreamProducer producer) {
        try {
            ensureStarted();
            producer.produce(this);
            completeTerminal();
            return new SendResult(messageId);
        } catch (Exception e) {
            failTerminal();
            throw sender.wrapStreamingException("markdown stream failed", e);
        }
    }

    private void ensureStarted() throws Exception {
        if (started) {
            return;
        }
        started = true;
        Map<String, Object> card = buildStreamingCard(sender.getStreamInitialText());
        cardId = sender.createCardInstance(card);
        messageId = sender.sendCardByReference(to, idType, cardId, options);
    }

    private void pushContent() throws Exception {
        if (cardId == null || cardId.isEmpty()) {
            return;
        }
        final String snapshot = content == null || content.isEmpty() ? "..." : content;
        final int nextSequence = ++sequence;
        queue.enqueue(() -> sender.updateCardElementContent(cardId, ELEMENT_ID, snapshot, nextSequence));
    }

    private void completeTerminal() throws Exception {
        throttle.flushNow();
        queue.drain();
        String finalContent = content == null || content.isEmpty() ? "(no content)" : content;
        if (content == null || content.isEmpty()) {
            sender.updateCardElementContent(cardId, ELEMENT_ID, finalContent, ++sequence);
        }
        sender.finishStreamingCard(cardId, buildStreamingCard(finalContent, false, truncateSummary(finalContent)), ++sequence);
    }

    private void failTerminal() {
        try {
            throttle.dispose();
            String failed = (content == null ? "" : content) + "\n\n(Generation interrupted)";
            sender.updateCardElementContent(cardId, ELEMENT_ID, failed, ++sequence);
            sender.finishStreamingCard(cardId, buildStreamingCard(failed, false, truncateSummary(failed)), ++sequence);
        } catch (Exception ignored) {
        }
    }

    private String truncateSummary(String text) {
        if (text == null) {
            return "";
        }
        String cleaned = text.replaceAll("\\s+", " ").trim();
        return cleaned.length() <= 50 ? cleaned : cleaned.substring(0, 49) + "…";
    }

    private Map<String, Object> buildStreamingCard(String text) {
        return buildStreamingCard(text, true, "[Generating...]");
    }

    private Map<String, Object> buildStreamingCard(String text, boolean streamingMode, String summary) {
        Map<String, Object> markdown = new LinkedHashMap<>();
        markdown.put("tag", "markdown");
        markdown.put("element_id", ELEMENT_ID);
        markdown.put("content", text == null || text.isEmpty() ? "Thinking..." : text);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("elements", java.util.Collections.singletonList(markdown));

        Map<String, Object> title = new LinkedHashMap<>();
        title.put("tag", "plain_text");
        title.put("content", "Streaming response");
        Map<String, Object> header = new LinkedHashMap<>();
        header.put("title", title);

        Map<String, Object> config = new LinkedHashMap<>();
        config.put("streaming_mode", streamingMode);
        config.put("summary", java.util.Collections.singletonMap("content", summary));

        Map<String, Object> card = new LinkedHashMap<>();
        card.put("schema", "2.0");
        card.put("header", header);
        card.put("config", config);
        card.put("body", body);
        return card;
    }
}
