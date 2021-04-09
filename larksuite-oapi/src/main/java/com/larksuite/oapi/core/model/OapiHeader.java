package com.larksuite.oapi.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OapiHeader {

    private final Map<String, List<String>> m = new HashMap<>();

    public OapiHeader(Map<String, List<String>> headers) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            this.m.put(normalizeKey(entry.getKey()), entry.getValue());
        }
    }

    private static String normalizeKey(String name) {
        return name != null ? name.toLowerCase() : null;
    }

    public Set<String> getNames() {
        return m.keySet();
    }

    public List<String> getMultiValues(String name) {
        return this.m.get(normalizeKey(name));
    }

    public String getFirstValue(String name) {
        List<String> values = this.m.get(normalizeKey(name));
        if (values != null && values.size() > 0) {
            return values.get(0);
        } else {
            return null;
        }
    }
}
