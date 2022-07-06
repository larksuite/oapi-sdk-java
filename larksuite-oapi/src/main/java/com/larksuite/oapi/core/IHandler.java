package com.larksuite.oapi.core;

import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;

public interface IHandler {
    EventResp handle(EventReq eventReq) throws Throwable;
}
