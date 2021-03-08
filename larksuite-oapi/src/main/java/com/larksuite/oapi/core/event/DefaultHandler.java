package com.larksuite.oapi.core.event;

import com.larksuite.oapi.core.Context;

import java.util.Map;

public interface DefaultHandler {
    void Handle(Context context, Map<String, Object> event) throws Exception;
}
