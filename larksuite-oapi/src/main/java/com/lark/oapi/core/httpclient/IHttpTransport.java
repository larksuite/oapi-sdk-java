package com.lark.oapi.core.httpclient;

import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;

public interface IHttpTransport {

  RawResponse execute(RawRequest request) throws Exception;
}
