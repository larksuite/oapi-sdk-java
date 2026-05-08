package com.lark.oapi.channel.model;

public interface CardStreamProducer {
    void produce(CardStreamController controller) throws Exception;
}
