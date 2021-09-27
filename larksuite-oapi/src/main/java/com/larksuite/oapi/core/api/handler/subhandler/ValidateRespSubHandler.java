package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.exception.ResponseInvalidException;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.okhttp3_14.ResponseBody;
import com.larksuite.oapi.core.utils.Strings;

public class ValidateRespSubHandler implements SubHandler {
    @Override
    public <I, O> void handle(Context ctx, Request<I, O> req) throws Exception {
        String contentType = req.getHttpResponse().header(Constants.CONTENT_TYPE);
        if (req.isResponseStream()) {
            if (contentType != null && contentType.contains(Constants.APPLICATION_JSON)) {
                req.setResponseStreamReal(false);
                return;
            }
            if (req.getHttpResponse().code() != 200) {
                throw new ResponseInvalidException("response is stream, but status code:" + req.getHttpResponse().code());
            }
            req.setResponseStreamReal(true);
            return;
        }
        if (Strings.isEmpty(contentType) || !contentType.contains(Constants.APPLICATION_JSON)) {
            ResponseBody responseBody = req.getHttpResponse().body();
            String body = responseBody == null ? "" : responseBody.string();
            throw new ResponseInvalidException("request id:" + ctx.getRequestID() + ", status code:" + req.getHttpResponse().code() + ", content-type:"
                    + contentType + ", not is:" + Constants.APPLICATION_JSON
                    + ", body:" + body);
        }
    }
}
