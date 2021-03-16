package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Body;
import com.larksuite.oapi.core.api.tools.IOs;
import com.larksuite.oapi.core.utils.Jsons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.util.Objects;

public class UnmarshalRespSubHandler implements SubHandler {

    private static final Logger log = LoggerFactory.getLogger(UnmarshalRespSubHandler.class);

    @Override
    public <I, O> void handle(Context ctx, Request<I, O> req) throws Exception {
        okhttp3.Response httpResponse = req.getHttpResponse();
        if (req.isResponseStreamReal()) {
            try {
                if (req.getOutput() instanceof OutputStream) {
                    IOs.copy(Objects.requireNonNull(httpResponse.body()).byteStream(), (OutputStream) req.getOutput());
                    req.getResponse().setData(req.getOutput());
                } else {
                    throw new UnsupportedOperationException("when response is stream, request.output instanceof OutputStream");
                }
            } finally {
                Objects.requireNonNull(httpResponse.body()).close();
            }
            return;
        }
        String body = Objects.requireNonNull(httpResponse.body()).string();
        log.debug("[unmarshalResponse] request:{}, response body:{}", req.toString(), body);
        unmarshalResp(req, body);
    }

    public <I, O> void unmarshalResp(Request<I, O> req, String body) {
        body = body.trim();
        Body b = Jsons.DEFAULT_GSON.fromJson(body, Body.class);
        req.setRetry(b.retry());
        req.getResponse().setBody(b);
        if (b.getCode() != Body.ErrCodeOk) {
            return;
        }
        if (req.isNotDataField()) {
            Object output = Jsons.DEFAULT_GSON.fromJson(body, req.getOutput().getClass());
            req.getResponse().setData((O) output);
        } else {
            if (b.getData() == null || b.getData().size() == 0) {
                return;
            }
            String data = Jsons.DEFAULT_GSON.toJson(b.getData());
            Object output = Jsons.DEFAULT_GSON.fromJson(data, req.getOutput().getClass());
            req.getResponse().setData((O) output);
        }
    }
}
