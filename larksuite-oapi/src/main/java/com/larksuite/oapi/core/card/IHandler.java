package com.larksuite.oapi.core.card;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.mode.Card;

import java.util.HashMap;
import java.util.Map;

public interface IHandler {

    Object handle(Context context, Card card) throws Exception;

    class Hub {
        public static final Map<String, IHandler> appID2Handler = new HashMap<>();

        public static void register(Config config, IHandler handler) {
            appID2Handler.put(config.getAppSettings().getAppID(), handler);
        }

        public static IHandler getHandler(Config config) {
            return appID2Handler.get(config.getAppSettings().getAppID());
        }
    }
}
