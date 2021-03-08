package com.larksuite.oapi.core.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.Handler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;

public class Api {
    public static <I, O> Response<O> send(Config config, Request<I, O> request) throws Exception {
        Context context = new Context();
        config.withContext(context);
        request.withContext(context);
        Handler.DEFAULT.handle(context, request);
        return request.getResponse();
    }
}
