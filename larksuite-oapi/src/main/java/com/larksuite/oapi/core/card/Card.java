package com.larksuite.oapi.core.card;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.mode.HTTPCard;
import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

import static com.larksuite.oapi.core.card.handler.Handler.DEFAULT;

public class Card {

    public static void setHandler(Config config, IHandler handler) {
        IHandler.Hub.register(config, handler);
    }

    public static OapiResponse handle(Config config, OapiRequest request) {
        Context context = new Context();
        config.withContext(context);
        OapiResponse response = new OapiResponse();
        HTTPCard httpCard = new HTTPCard(request, response);
        DEFAULT.handle(context, httpCard);
        return response;
    }
}
