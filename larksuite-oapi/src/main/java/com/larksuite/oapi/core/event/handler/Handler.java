package com.larksuite.oapi.core.event.handler;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.exception.NotFoundHandlerException;
import com.larksuite.oapi.core.event.handler.subhandler.HandleSubHandler;
import com.larksuite.oapi.core.event.handler.subhandler.UnmarshalSubHandler;
import com.larksuite.oapi.core.event.model.HTTPEvent;
import com.larksuite.oapi.core.model.OapiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler {

    public static final Handler DEFAULT = new Handler();
    private static final Logger log = LoggerFactory.getLogger(Handler.class);
    private final ISubHandler[] subHandlers;

    public Handler() {
        this.subHandlers = new ISubHandler[]{new UnmarshalSubHandler(), new HandleSubHandler()};
    }

    public void handle(Context context, HTTPEvent httpEvent) {
        OapiResponse response = httpEvent.getResponse();
        response.setStatusCode(200);
        response.setContentType(Constants.APPLICATION_JSON);
        try {
            for (ISubHandler subHandler : this.subHandlers) {
                subHandler.handle(context, httpEvent);
            }
            complement(httpEvent, response);
        } catch (Exception e) {
            if (e instanceof NotFoundHandlerException) {
                log.info("event handle failed, requestId:{} - {}", context.getRequestID(), e.getMessage());
                response.setBody(String.format(OapiResponse.RESPONSE_FORMAT, e.getMessage()));
                return;
            }
            log.error("event handle failed, requestId:{} - {}", context.getRequestID(), e.getMessage(), e);
            response.setStatusCode(500);
            response.setBody(String.format(OapiResponse.RESPONSE_FORMAT, e.getMessage()));
        }
    }

    private void complement(HTTPEvent httpEvent, OapiResponse response) {
        if (Constants.URL_VERIFICATION.equals(httpEvent.getType())) {
            response.setBody(String.format(OapiResponse.CHALLENGE_RESPONSE_FORMAT, httpEvent.getChallenge()));
            return;
        }
        response.setBody(String.format(OapiResponse.RESPONSE_FORMAT, "success"));
    }

}
