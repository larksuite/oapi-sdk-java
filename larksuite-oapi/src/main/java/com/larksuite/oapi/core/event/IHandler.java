package com.larksuite.oapi.core.event;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;

import java.util.HashMap;
import java.util.Map;

public interface IHandler<E> {
    E getEvent();

    void Handle(Context context, E event) throws Exception;


    class Hub {
        public static final Map<String, Map<String, IHandler>> appID2EventType2Handler = new HashMap<>();

        public static void setEventTypeHandler(Config config, String eventType, IHandler handler) {
            String appID = config.getAppSettings().getAppID();
            Map<String, IHandler> eventType2Handler = appID2EventType2Handler.computeIfAbsent(appID, k -> new HashMap<>());
            eventType2Handler.put(eventType, handler);
        }

        public static void setEventTypeHandler(Config config, String eventType, DefaultHandler handler) {
            setEventTypeHandler(config, eventType, new defaultHandler(handler));
        }

        public static IHandler GetEventHandler(Config config, String eventType) {
            String appID = config.getAppSettings().getAppID();
            Map<String, IHandler> eventType2Handler = appID2EventType2Handler.get(appID);
            if (eventType2Handler == null) {
                return null;
            }
            return eventType2Handler.get(eventType);
        }

    }

    class defaultHandler implements IHandler<Map<String, Object>> {

        private final DefaultHandler handler;

        public defaultHandler(DefaultHandler handler) {
            this.handler = handler;
        }

        @Override
        public Map<String, Object> getEvent() {
            return new HashMap<>();
        }

        @Override
        public void Handle(Context context, Map<String, Object> event) throws Exception {
            this.handler.Handle(context, event);
        }
    }
}
