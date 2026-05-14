package com.lark.oapi.channel.model;

import java.util.Map;

/**
 * Controller exposed to interactive-card streaming producers.
 */
public interface CardStreamController {
    /**
     * Patch the current card state. The channel sends the update through the
     * cardkit streaming API and records the new current state.
     */
    void update(Map<String, Object> next);

    /**
     * Latest card JSON state known by the controller.
     */
    Map<String, Object> getCurrent();

    /**
     * Message id of the card message once it has been sent.
     */
    String getMessageId();
}
