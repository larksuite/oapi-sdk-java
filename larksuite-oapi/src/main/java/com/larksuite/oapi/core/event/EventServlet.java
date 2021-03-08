package com.larksuite.oapi.core.event;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.OapiServlet;
import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

public class EventServlet extends OapiServlet {

    public EventServlet(Config config) {
        super(config);
    }

    @Override
    public OapiResponse handle(Config config, OapiRequest req) {
        return Event.handle(config, req);
    }
}
