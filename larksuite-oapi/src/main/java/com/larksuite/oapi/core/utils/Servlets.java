package com.larksuite.oapi.core.utils;

import com.larksuite.oapi.core.model.OapiHeader;
import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Servlets {

    public static OapiRequest toRequest(HttpServletRequest req) throws IOException {
        String uri = req.getRequestURI();
        OapiHeader header = new OapiHeader(toHeaderMap(req));
        Map<String, List<String>> query = toQueryMap(req.getQueryString());
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        String remoteAddress = req.getRemoteAddr();
        return new OapiRequest(uri, header, query, body, remoteAddress);
    }

    public static Map<String, List<String>> toHeaderMap(HttpServletRequest req) {
        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            List<String> values = Collections.list(req.getHeaders(name));
            headers.put(name, values);
        }
        return headers;
    }

    public static void writeResponse(OapiResponse oapiResponse, HttpServletResponse resp) throws IOException {
        resp.setStatus(oapiResponse.getStatusCode());
        for (Map.Entry<String, List<String>> header : oapiResponse.getHeaders().entrySet()) {
            String name = header.getKey();
            for (String value : header.getValue()) {
                resp.addHeader(name, value);
            }
        }
        if (oapiResponse.getBody() != null) {
            resp.setContentType(oapiResponse.getContentType());
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
            resp.getWriter().write(oapiResponse.getBody());
            resp.getWriter().flush();
        }
    }

    public static Map<String, List<String>> toQueryMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, List<String>> queryParams = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            try {
                if (pair.trim().isEmpty()) {
                    continue;
                }
                String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8.name());
                String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8.name());
                List<String> values = queryParams.get(key);
                if (values == null) {
                    values = new ArrayList<>();
                }
                values.add(value);
                queryParams.put(key, values);
            } catch (UnsupportedEncodingException e) {
                String key = pair.substring(0, idx);
                String value = pair.substring(idx + 1);
                List<String> values = queryParams.get(key);
                if (values == null) {
                    values = new ArrayList<>();
                }
                values.add(value);
                queryParams.put(key, values);
            }
        }
        return queryParams;
    }
}
