package com.larksuite.oapi.core.event.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.IHandler;
import com.larksuite.oapi.core.event.exception.NotFoundHandlerException;
import com.larksuite.oapi.core.event.handler.ISubHandler;
import com.larksuite.oapi.core.event.model.HTTPEvent;
import com.larksuite.oapi.core.utils.Jsons;

public class HandleSubHandler implements ISubHandler {

    @Override
    public <E> void handle(Context context, HTTPEvent httpEvent) throws Exception {
        if (Constants.URL_VERIFICATION.equals(httpEvent.getType())) {
            return;
        }
        Config config = Config.ByCtx(context);
        IHandler<E> handler = IHandler.Hub.GetEventHandler(config, httpEvent.getEventType());
        if (handler == null) {
            throw new NotFoundHandlerException(httpEvent.getEventType());
        }
        E e = handler.getEvent();
        e = (E) Jsons.DEFAULT_GSON.fromJson(httpEvent.getInput().trim(), e.getClass());
        handler.Handle(context, e);
    }
}
