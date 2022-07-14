package com.lark.oapi.core;

import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import java.io.IOException;

public interface IHttpAdapter {

  EventReq getEventReq() throws IOException;

  void writeResp(EventResp eventResp) throws IOException;
}
