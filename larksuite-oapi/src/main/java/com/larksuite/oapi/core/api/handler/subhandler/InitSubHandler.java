package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;

public class InitSubHandler implements SubHandler {
    @Override
    public <I, O> void handle(Context ctx, Request<I, O> req) throws Exception {
        Config conf = Config.ByCtx(ctx);
        req.init(conf.getDomain());
    }
}
