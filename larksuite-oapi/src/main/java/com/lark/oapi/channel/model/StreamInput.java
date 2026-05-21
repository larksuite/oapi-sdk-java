package com.lark.oapi.channel.model;

import java.util.Map;

/**
 * Streaming payload accepted by {@code LarkChannel.stream(...)}.
 *
 * <p>Markdown streams append generated text into a streaming card. Card
 * streams start from an initial card JSON object and progressively patch it.
 */
public class StreamInput {
    /** Supported streaming modes. */
    public enum Kind {
        MARKDOWN, CARD
    }

    private final Kind kind;
    private final MarkdownStreamProducer markdownProducer;
    private final Map<String, Object> initialCard;
    private final CardStreamProducer cardProducer;

    private StreamInput(Kind kind, MarkdownStreamProducer markdownProducer, Map<String, Object> initialCard,
                        CardStreamProducer cardProducer) {
        this.kind = kind;
        this.markdownProducer = markdownProducer;
        this.initialCard = initialCard;
        this.cardProducer = cardProducer;
    }

    /**
     * Create a Markdown streaming input.
     */
    public static StreamInput markdown(MarkdownStreamProducer producer) {
        return new StreamInput(Kind.MARKDOWN, producer, null, null);
    }

    /**
     * Create an interactive-card streaming input.
     */
    public static StreamInput card(Map<String, Object> initial, CardStreamProducer producer) {
        return new StreamInput(Kind.CARD, null, initial, producer);
    }

    public Kind getKind() {
        return kind;
    }

    public MarkdownStreamProducer getMarkdownProducer() {
        return markdownProducer;
    }

    public Map<String, Object> getInitialCard() {
        return initialCard;
    }

    public CardStreamProducer getCardProducer() {
        return cardProducer;
    }
}
