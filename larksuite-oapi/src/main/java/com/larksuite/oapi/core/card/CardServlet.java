package com.larksuite.oapi.core.card;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.OapiServlet;
import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

public class CardServlet extends OapiServlet {

    public CardServlet(Config config) {
        super(config);
    }

    @Override
    public OapiResponse handle(Config config, OapiRequest req) {
        return Card.handle(config, req);
    }
}
