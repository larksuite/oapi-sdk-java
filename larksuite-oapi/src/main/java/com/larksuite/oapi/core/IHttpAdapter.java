package com.larksuite.oapi.core;

import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;

import java.io.IOException;

public interface IHttpAdapter {
    EventReq getEventReq() throws IOException;

    void writeResp(EventResp eventResp) throws IOException;
}
