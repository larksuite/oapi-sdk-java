package com.lark.oapi.core.sse;

/** Optional streaming capability; cancellation must interrupt execute and reads. */
public interface StreamingCall {
    StreamingResponse execute() throws Exception;

    void cancel();
}
