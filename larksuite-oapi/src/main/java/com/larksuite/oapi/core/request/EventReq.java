package com.larksuite.oapi.core.request;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.utils.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventReq {
    private byte[] body;
    private Map<String, List<String>> headers = new HashMap();

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    private String normalizeKey(String name) {
        return name != null ? name.toLowerCase() : null;
    }

    public String getHeaderFirstValue(String name) {
        List<String> values = this.headers.get(normalizeKey(name));
        if (values != null && values.size() > 0) {
            return values.get(0);
        } else {
            return "";
        }
    }

    public String getRequestID() {
        String logID = getHeaderFirstValue(Constants.HTTP_HEADER_KEY_LOG_ID);
        if (!Strings.isEmpty(logID)) {
            return logID;
        }
        return getHeaderFirstValue(Constants.HTTP_HEADER_KEY_REQUEST_ID);
    }
}
