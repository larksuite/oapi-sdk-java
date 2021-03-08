package com.larksuite.oapi.core.api.handler;

import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.request.Request;

public interface SubHandler {
    <I, O> void handle(Context ctx, Request<I, O> req) throws Exception;
}
