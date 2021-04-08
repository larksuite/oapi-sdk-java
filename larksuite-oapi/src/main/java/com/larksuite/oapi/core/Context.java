package com.larksuite.oapi.core;

import com.larksuite.oapi.core.model.OapiHeader;
import com.larksuite.oapi.core.utils.Strings;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Object> m;

    public Context() {
        this.m = new HashMap<>();
    }

    public void set(String key, Object val) {
        this.m.put(key, val);
    }

    public Object get(String key) {
        return m.get(key);
    }

    public OapiHeader getHeader() {
        return (OapiHeader) this.m.get(Constants.HTTP_HEADER);
    }

    public String getRequestID() {
        OapiHeader header = getHeader();
        String logID = header.firstValue(Constants.HTTP_HEADER_KEY_LOG_ID);
        if (!Strings.isEmpty(logID)) {
            return logID;
        }
        return header.firstValue(Constants.HTTP_HEADER_KEY_REQUEST_ID);
    }

    public int getHTTPStatusCode() {
        Object v = this.m.get(Constants.HTTP_KEY_STATUS_CODE);
        if (v != null) {
            return (int) v;
        }
        return 0;
    }
}
