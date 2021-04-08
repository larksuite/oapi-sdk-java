package com.larksuite.oapi.core.event.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.Decrypt;
import com.larksuite.oapi.core.event.handler.ISubHandler;
import com.larksuite.oapi.core.event.model.Fuzzy;
import com.larksuite.oapi.core.event.model.HTTPEvent;
import com.larksuite.oapi.core.exception.TokenInvalidException;
import com.larksuite.oapi.core.model.OapiHeader;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnmarshalSubHandler implements ISubHandler {

    private static final Logger log = LoggerFactory.getLogger(UnmarshalSubHandler.class);

    @Override
    public void handle(Context context, HTTPEvent httpEvent) throws Exception {
        context.set(Constants.HTTP_HEADER, httpEvent.getRequest().getHeader());
        String requestBody = httpEvent.getRequest().getBody();
        log.debug("[unmarshal] event: {}", requestBody);
        Config config = Config.ByCtx(context);
        if (!Strings.isEmpty(config.getAppSettings().getEncryptKey())) {
            Fuzzy fuzzy = Jsons.DEFAULT_GSON.fromJson(requestBody, Fuzzy.class);
            requestBody = new Decrypt(config.getAppSettings().getEncryptKey()).decrypt(fuzzy.getEncrypt());
            log.debug("[unmarshal] decrypt event: {}", requestBody);
        }
        requestBody = requestBody.trim();
        httpEvent.setInput(requestBody);
        Fuzzy fuzzy = Jsons.DEFAULT_GSON.fromJson(requestBody, Fuzzy.class);
        String schema = HTTPEvent.Version1;
        String token = fuzzy.getToken();
        if (!Strings.isEmpty(fuzzy.getSchema())) {
            schema = fuzzy.getSchema();
        }
        String eventType = "";
        if (fuzzy.getEvent() != null) {
            eventType = fuzzy.getEvent().getType();
        }
        if (fuzzy.getHeader() != null) {
            token = fuzzy.getHeader().getToken();
            eventType = fuzzy.getHeader().getEventType();
        }
        httpEvent.setSchema(schema);
        httpEvent.setEventType(eventType);
        httpEvent.setType(fuzzy.getType());
        httpEvent.setChallenge(fuzzy.getChallenge());
        if (!token.equals(config.getAppSettings().getVerificationToken())) {
            throw new TokenInvalidException(token);
        }
    }
}
