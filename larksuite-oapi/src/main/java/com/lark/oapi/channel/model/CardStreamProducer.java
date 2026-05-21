package com.lark.oapi.channel.model;

/**
 * User callback that updates an interactive card over time.
 */
public interface CardStreamProducer {
    /**
     * Produce card updates using the provided controller.
     */
    void produce(CardStreamController controller) throws Exception;
}
