package com.lark.oapi.channel.model;

/**
 * User callback that writes incremental Markdown content.
 */
public interface MarkdownStreamProducer {
    /**
     * Produce streaming chunks using the provided controller.
     */
    void produce(MarkdownStreamController controller) throws Exception;
}
