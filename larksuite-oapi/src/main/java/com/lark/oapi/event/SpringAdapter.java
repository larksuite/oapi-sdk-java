package com.lark.oapi.event;

import com.lark.oapi.core.IHandler;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import com.lark.oapi.core.utils.IOs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@SuppressWarnings("unused")
public class SpringAdapter {

    private static final Logger log = LoggerFactory.getLogger(SpringAdapter.class);

    public static ResponseEntity<String> handlerJavaxServletWebhook(javax.servlet.http.HttpServletRequest request, IHandler handler) {
        try {
            // read request headers
            HttpHeaders requestHeaders = new HttpHeaders();
            Enumeration<String> names = request.getHeaderNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                List<String> values = Collections.list(request.getHeaders(name));
                requestHeaders.put(name, values);
            }
            byte[] body = IOs.readAll(request.getInputStream());
            // build event request
            EventReq req = new EventReq();
            req.setHeaders(requestHeaders);
            req.setBody(body);
            req.setHttpPath(request.getRequestURI());
            // handle event
            EventResp resp = handler.handle(req);
            // build response
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.putAll(resp.getHeaders());
            return ResponseEntity.status(resp.getStatusCode())
                .headers(responseHeaders)
                .body(new String(resp.getBody()));
        } catch (Throwable e) {
            log.error("handler javax.servlet webhook error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public static ResponseEntity<String> handlerJakartaServletWebhook(jakarta.servlet.http.HttpServletRequest request, IHandler handler) {
        try {
            // read request headers
            HttpHeaders requestHeaders = new HttpHeaders();
            Enumeration<String> names = request.getHeaderNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                List<String> values = Collections.list(request.getHeaders(name));
                requestHeaders.put(name, values);
            }
            byte[] body = IOs.readAll(request.getInputStream());
            // build event request
            EventReq req = new EventReq();
            req.setHeaders(requestHeaders);
            req.setBody(body);
            req.setHttpPath(request.getRequestURI());
            // handle event
            EventResp resp = handler.handle(req);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.putAll(resp.getHeaders());
            return ResponseEntity.status(resp.getStatusCode())
                .headers(responseHeaders)
                .body(new String(resp.getBody()));
        } catch (Throwable e) {
            log.error("handler jakarta.servlet webhook error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public static Mono<ResponseEntity<String>> handlerReactorWebHook(ServerWebExchange exchange, IHandler handler) {
        return DataBufferUtils.join(exchange.getRequest().getBody())
            .flatMap(buf -> {
                byte[] bytes = new byte[buf.readableByteCount()];
                buf.read(bytes);
                DataBufferUtils.release(buf);
                return Mono.just(bytes);
            })
            .map(body -> {
                try {
                    // build event request
                    EventReq req = new EventReq();
                    req.setHeaders(exchange.getRequest().getHeaders());
                    req.setBody(body);
                    req.setHttpPath(exchange.getRequest().getURI().getPath());
                    // handle event
                    EventResp resp = handler.handle(req);
                    // build response
                    return ResponseEntity
                        .status(resp.getStatusCode())
                        .headers(headers -> headers.putAll(resp.getHeaders()))
                        .body(new String(resp.getBody()));
                } catch (Throwable e) {
                    log.error("Event dispatch error", e);
                    return ResponseEntity.internalServerError().body(String.format(EventResp.RESPONSE_FORMAT, e.getMessage()));
                }
            });
    }
}