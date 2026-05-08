package com.lark.oapi.channel.model;

import java.util.Map;

public interface CardStreamController {
    void update(Map<String, Object> next);

    Map<String, Object> getCurrent();

    String getMessageId();
}
