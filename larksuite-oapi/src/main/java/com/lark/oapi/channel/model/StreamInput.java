package com.lark.oapi.channel.model;

import java.util.Map;

public class StreamInput {
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

    public static StreamInput markdown(MarkdownStreamProducer producer) {
        return new StreamInput(Kind.MARKDOWN, producer, null, null);
    }

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
