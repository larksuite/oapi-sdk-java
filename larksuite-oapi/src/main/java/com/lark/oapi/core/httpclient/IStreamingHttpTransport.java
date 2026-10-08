package com.lark.oapi.core.httpclient;

import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.sse.SSEOptions;
import com.lark.oapi.core.sse.StreamingCall;

/** Additive capability: existing custom IHttpTransport implementations still compile. */
public interface IStreamingHttpTransport extends IHttpTransport {
    StreamingCall createStreamingCall(RawRequest request, SSEOptions options) throws Exception;
}
