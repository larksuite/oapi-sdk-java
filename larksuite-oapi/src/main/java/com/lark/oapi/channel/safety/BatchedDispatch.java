package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.model.NormalizedMessage;
import java.util.List;

class BatchedDispatch {
    private final NormalizedMessage message;
    private final List<String> sourceIds;

    BatchedDispatch(NormalizedMessage message, List<String> sourceIds) {
        this.message = message;
        this.sourceIds = sourceIds;
    }

    NormalizedMessage getMessage() {
        return message;
    }

    List<String> getSourceIds() {
        return sourceIds;
    }
}
