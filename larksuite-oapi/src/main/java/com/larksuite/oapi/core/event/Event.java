package com.larksuite.oapi.core.event;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.model.HTTPEvent;
import com.larksuite.oapi.core.event.v1.AppTicketEventHandler;
import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

import static com.larksuite.oapi.core.event.handler.Handler.DEFAULT;

public class Event {
    private static volatile boolean inited = false;

    public static void setTypeHandler(Config config, String eventType, IHandler handler) {
        IHandler.Hub.setEventTypeHandler(config, eventType, handler);
    }

    public static void setTypeHandler(Config config, String eventType, DefaultHandler handler) {
        IHandler.Hub.setEventTypeHandler(config, eventType, handler);
    }

    private static void init(Config config) {
        if (!inited) {
            synchronized (Event.class) {
                if (!inited) {
                    AppTicketEventHandler.register(config);
                    inited = true;
                }
            }
        }
    }

    public static OapiResponse handle(Config config, OapiRequest request) {
        init(config);
        Context context = new Context();
        config.withContext(context);
        OapiResponse response = new OapiResponse();
        HTTPEvent httpEvent = new HTTPEvent(request, response);
        DEFAULT.handle(context, httpEvent);
        return response;
    }
}
