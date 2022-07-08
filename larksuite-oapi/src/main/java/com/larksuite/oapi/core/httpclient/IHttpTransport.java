package com.larksuite.oapi.core.httpclient;

import com.larksuite.oapi.core.request.RawRequest;
import com.larksuite.oapi.core.response.RawResponse;

public interface IHttpTransport {
    RawResponse execute(RawRequest request) throws Exception;
}
