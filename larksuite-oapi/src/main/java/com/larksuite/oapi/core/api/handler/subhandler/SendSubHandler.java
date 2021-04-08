package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.tools.OKHttps;
import com.larksuite.oapi.core.model.OapiHeader;
import com.larksuite.oapi.okhttp3_14.OkHttpClient;
import com.larksuite.oapi.okhttp3_14.Response;

import java.util.concurrent.TimeUnit;

public class SendSubHandler implements SubHandler {

    @Override
    public <I, O> void handle(Context context, Request<I, O> req) throws Exception {
        OkHttpClient okHttpClient = OKHttps.defaultClient;
        if (req.getTimeoutOfMs() > 0) {
            okHttpClient = OKHttps.create(req.getTimeoutOfMs(), req.getTimeoutOfMs(), TimeUnit.MILLISECONDS);
        }
        com.larksuite.oapi.okhttp3_14.Request request = req.getHttpRequestBuilder().build();
        Response response = okHttpClient.newCall(request).execute();
        OapiHeader oapiHeader =new OapiHeader(response.headers().toMultimap());
        context.set(Constants.HTTP_HEADER, oapiHeader);
        context.set(Constants.HTTP_KEY_STATUS_CODE, response.code());
        req.setHttpResponse(response);
        req.setResponse(new com.larksuite.oapi.core.api.response.Response<>(context));
    }
}
