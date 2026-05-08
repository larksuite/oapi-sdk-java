package com.lark.oapi.channel.model;

public interface MarkdownStreamProducer {
    void produce(MarkdownStreamController controller) throws Exception;
}
