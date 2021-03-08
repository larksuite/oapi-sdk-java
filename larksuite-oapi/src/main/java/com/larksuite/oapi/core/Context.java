package com.larksuite.oapi.core;

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

    public void setRequestID(String logID, String requestID) {
        if (!Strings.isEmpty(logID)) {
            set(Constants.HTTP_HEADER_KEY_REQUEST_ID, logID);
            return;
        }
        set(Constants.HTTP_HEADER_KEY_REQUEST_ID, requestID);
    }

    public String getRequestID() {
        Object v = this.m.get(Constants.HTTP_HEADER_KEY_REQUEST_ID);
        if (v != null) {
            return (String) v;
        }
        return "";
    }

    public int getHTTPStatusCode() {
        Object v = this.m.get(Constants.HTTP_KEY_STATUS_CODE);
        if (v != null) {
            return (int) v;
        }
        return 0;
    }
}
