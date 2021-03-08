package com.larksuite.oapi.core.card.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.IHandler;
import com.larksuite.oapi.core.card.exception.NotFoundHandlerException;
import com.larksuite.oapi.core.card.handler.ISubHandler;
import com.larksuite.oapi.core.card.mode.Card;
import com.larksuite.oapi.core.card.mode.HTTPCard;
import com.larksuite.oapi.core.utils.Jsons;

public class HandleSubHandler implements ISubHandler {
    @Override
    public void handle(Context context, HTTPCard httpCard) throws Exception {
        if (Constants.URL_VERIFICATION.equals(httpCard.getType())) {
            return;
        }
        Config config = Config.ByCtx(context);
        IHandler handler = IHandler.Hub.getHandler(config);
        if (handler == null) {
            throw new NotFoundHandlerException();
        }
        Card card = Jsons.DEFAULT_GSON.fromJson(httpCard.getInput().trim(), Card.class);
        httpCard.setOutput(handler.handle(context, card));
    }
}
