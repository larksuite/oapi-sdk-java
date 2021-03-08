package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.tools.OKHttps;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

public class SendSubHandler implements SubHandler {

    @Override
    public <I, O> void handle(Context context, Request<I, O> req) throws Exception {
        OkHttpClient okHttpClient = OKHttps.defaultClient;
        if (req.getTimeoutOfMs() > 0) {
            okHttpClient = OKHttps.create(req.getTimeoutOfMs(), req.getTimeoutOfMs(), TimeUnit.MILLISECONDS);
        }
        okhttp3.Request request = req.getHttpRequestBuilder().build();
        Response response = okHttpClient.newCall(request).execute();
        String logID = response.header(Constants.HTTP_HEADER_KEY_LOG_ID);
        String requestID = response.header(Constants.HTTP_HEADER_KEY_REQUEST_ID);
        context.setRequestID(logID, requestID);
        context.set(Constants.HTTP_KEY_STATUS_CODE, response.code());
        req.setHttpResponse(response);
        req.setResponse(new com.larksuite.oapi.core.api.response.Response<>(context));
    }
}
