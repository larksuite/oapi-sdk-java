package com.lark.oapi.core;

import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;

public interface IHandler {

  EventResp handle(EventReq eventReq) throws Throwable;
}
