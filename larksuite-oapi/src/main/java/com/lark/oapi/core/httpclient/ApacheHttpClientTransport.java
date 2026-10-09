package com.lark.oapi.core.httpclient;

import com.lark.oapi.core.request.FormData;
import com.lark.oapi.core.request.FormDataFile;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.sse.SSEOptions;
import com.lark.oapi.core.sse.StreamingCall;
import com.lark.oapi.core.sse.StreamingResponse;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Strings;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ApacheHttpClientTransport implements IStreamingHttpTransport {
    private CloseableHttpClient httpclient;

    private ApacheHttpClientTransport(Builder builder) {
        this.httpclient = builder.httpclient;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void Close() throws IOException {
        this.httpclient.close();
    }

    @Override
    public StreamingCall createStreamingCall(RawRequest raw, SSEOptions options) {
        HttpEntityEnclosingRequestBase request =
                new HttpEntityEnclosingRequestBase() {
                    public String getMethod() {
                        return raw.getHttpMethod();
                    }
                };
        request.setURI(URI.create(raw.getReqUrl()));
        raw.getHeaders()
                .forEach((key, values) -> values.forEach(value -> request.addHeader(key, value)));
        request.setConfig(
                RequestConfig.custom()
                        .setConnectTimeout((int) options.getOpenTimeoutMillis())
                        .setConnectionRequestTimeout((int) options.getOpenTimeoutMillis())
                        .setSocketTimeout(options.getIdleReadTimeoutMillis())
                        .setRedirectsEnabled(false)
                        .build());
        if (raw.getBody() != null) {
            String json =
                    raw.isSupportLong2String()
                            ? Jsons.LONG_TO_STR.toJson(raw.getBody())
                            : Jsons.DEFAULT.toJson(raw.getBody());
            // A non-repeatable body prevents a transport from replaying a sent stream request.
            BasicHttpEntity entity = new BasicHttpEntity();
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            entity.setContent(new ByteArrayInputStream(bytes));
            entity.setContentLength(bytes.length);
            entity.setContentType("application/json; charset=utf-8");
            request.setEntity(entity);
        }
        return new StreamingCall() {
            public StreamingResponse execute() throws Exception {
                return readStreamingResponse(httpclient.execute(request));
            }

            public void cancel() {
                request.abort();
            }
        };
    }

    private StreamingResponse readStreamingResponse(CloseableHttpResponse response)
            throws IOException {
        try {
            Map<String, List<String>> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (Header header : response.getAllHeaders()) {
                headers.computeIfAbsent(header.getName(), key -> new ArrayList<>())
                        .add(header.getValue());
            }
            if (response.getEntity() == null) {
                throw new IOException("Missing SSE response body");
            }
            return new StreamingResponse(response.getStatusLine().getStatusCode(), headers,
                    response.getEntity().getContent(), response);
        } catch (IOException | RuntimeException error) {
            try {
                response.close();
            } catch (IOException cleanup) {
                error.addSuppressed(cleanup);
            }
            throw error;
        }
    }

    public RawResponse execute(RawRequest rawRequest) throws Exception {
        final String httpMethod = rawRequest.getHttpMethod();
        HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
            public String getMethod() {
                return httpMethod;
            }
        };
        request.setURI(URI.create(rawRequest.getReqUrl()));
        Iterator var4 = rawRequest.getHeaders().entrySet().iterator();

        while (var4.hasNext()) {
            Map.Entry<String, List<String>> entry = (Map.Entry) var4.next();
            String key = (String) entry.getKey();
            Iterator var7 = ((List) entry.getValue()).iterator();

            while (var7.hasNext()) {
                String value = (String) var7.next();
                request.addHeader(key, value);
            }
        }

        if (rawRequest.getBody() != null) {
            Object body = rawRequest.getBody();
            if (body instanceof FormData) {
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                builder.setCharset(StandardCharsets.UTF_8);
                builder.setContentType(ContentType.create(ContentType.MULTIPART_FORM_DATA.getMimeType()));
                Iterator var18 = ((FormData) rawRequest.getBody()).getFiles().iterator();

                while (var18.hasNext()) {
                    FormDataFile file = (FormDataFile) var18.next();
                    builder.addBinaryBody(file.getFieldName(), file.getFile(), ContentType.APPLICATION_OCTET_STREAM, Strings.isEmpty(file.getFileName()) ? "unknown" : file.getFileName());
                }

                var18 = ((FormData) rawRequest.getBody()).getParams().entrySet().iterator();

                while (var18.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry) var18.next();
                    builder.addTextBody((String) entry.getKey(), (String) entry.getValue(),
                            ContentType.create("text/plain", StandardCharsets.UTF_8));
                }

                request.setEntity(builder.build());
            } else {
                StringEntity entity = new StringEntity(Jsons.LONG_TO_STR.toJson(rawRequest.getBody()), "UTF-8");
                request.setEntity(entity);
            }
        }

        CloseableHttpResponse response = this.httpclient.execute(request);
        byte[] result = EntityUtils.toByteArray(response.getEntity());
        RawResponse rawResponse = new RawResponse();
        rawResponse.setStatusCode(response.getStatusLine().getStatusCode());
        rawResponse.setBody(result);
        rawResponse.setContentType(rawResponse.getContentType());
        Map<String, List<String>> headers = new HashMap();
        Header[] var23 = response.getAllHeaders();
        int var9 = var23.length;

        for (int var10 = 0; var10 < var9; ++var10) {
            Header header = var23[var10];
            if (headers.containsKey(header.getName())) {
                ((List) headers.get(header.getName())).add(header.getValue());
            } else {
                List<String> values = new ArrayList();
                values.add(header.getValue());
                headers.put(header.getName(), values);
            }
        }

        rawResponse.setHeaders(headers);
        return rawResponse;
    }

    public static final class Builder {
        private CloseableHttpClient httpclient;

        private Builder() {
        }

        public Builder httpclient(CloseableHttpClient httpclient) {
            this.httpclient = httpclient;
            return this;
        }

        public ApacheHttpClientTransport build() {
            return new ApacheHttpClientTransport(this);
        }
    }
}
