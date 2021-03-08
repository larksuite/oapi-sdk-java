package com.larksuite.oapi.core.event.handler;

import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.model.HTTPEvent;

public interface ISubHandler {
    <E> void handle(Context context, HTTPEvent httpEvent) throws Exception;
}
