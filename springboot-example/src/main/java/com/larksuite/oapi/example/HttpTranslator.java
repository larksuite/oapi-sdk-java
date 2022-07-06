package com.larksuite.oapi.example;

import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class HttpTranslator {
    private Map<String, List<String>> toHeaderMap(HttpServletRequest req) {
        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            List<String> values = Collections.list(req.getHeaders(name));
            headers.put(name, values);
        }
        return headers;
    }

    public EventReq translate(HttpServletRequest request) throws IOException {
        String bodyStr = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        EventReq req = new EventReq();
        req.setHeaders(toHeaderMap(request));
        req.setBody(bodyStr.getBytes(StandardCharsets.UTF_8));
        return req;
    }

    public void write(HttpServletResponse response, EventResp eventResp) throws IOException {
        response.setStatus(eventResp.getStatusCode());
        eventResp.getHeaders().entrySet().stream().forEach(keyValues -> {
            String key = keyValues.getKey();
            List<String> values = keyValues.getValue();
            values.stream().forEach(v -> response.addHeader(key, v));
        });
        if (eventResp.getBody() != null) {
            response.getWriter().write(new String(eventResp.getBody()));
        }
    }
}
