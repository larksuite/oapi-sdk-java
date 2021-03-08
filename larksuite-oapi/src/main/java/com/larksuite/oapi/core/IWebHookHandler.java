package com.larksuite.oapi.core;

import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

public interface IWebHookHandler {
    OapiResponse handle(Config config, OapiRequest req);
}
