package com.larksuite.oapi.core.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;

public class DefaultReqCall<I, O> extends ReqCaller<I, O> {

    private final Config config;
    private final Request<I, O> request;

    public DefaultReqCall(Config config, Request<I, O> request) {
        this.config = config;
        this.request = request;
    }

    @Override
    public Response<O> execute() throws Exception {
        return Api.send(this.getConfig(), this.getRequest());
    }

    public Config getConfig() {
        return config;
    }

    public Request<I, O> getRequest() {
        return request;
    }
}
