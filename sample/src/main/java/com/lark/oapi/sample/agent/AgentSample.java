package com.lark.oapi.sample.agent;

import com.lark.oapi.Client;
import com.lark.oapi.core.httpclient.ApacheHttpClientTransport;
import com.lark.oapi.core.httpclient.OkHttpTransport;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.BaseResponse;
import com.lark.oapi.okhttp.OkHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/** Run one Agent scenario. See sample/agent/README.md for setup and commands. */
public final class AgentSample implements AutoCloseable {
    final Client client;
    final RequestOptions options;
    private final OkHttpClient okhttp;
    private final CloseableHttpClient apache;

    AgentSample() {
        String app = required("APP_ID");
        String secret = required("APP_SECRET");
        options = RequestOptions.newBuilder()
                .userAccessToken(required("USER_ACCESS_TOKEN"))
                .build();
        String base = System.getenv("OPEN_BASE_URL");
        if (base == null || base.isEmpty()) {
            base = "https://open.feishu.cn";
        }
        URI uri;
        try {
            uri = URI.create(base);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException("invalid OPEN_BASE_URL");
        }
        boolean local = "http".equals(uri.getScheme()) &&
                ("127.0.0.1".equals(uri.getHost()) || "localhost".equals(uri.getHost()));
        if (uri.getHost() == null || uri.getUserInfo() != null || uri.getQuery() != null ||
                uri.getFragment() != null || !("https".equals(uri.getScheme()) || local)) {
            throw new IllegalArgumentException(
                    "OPEN_BASE_URL must be HTTPS (HTTP allowed only for localhost testing)");
        }
        Client.Builder builder = Client.newBuilder(app, secret)
                .openBaseUrl(base)
                .requestTimeout(10, TimeUnit.SECONDS)
                .logReqAtDebug(false);
        String transport = System.getenv("AGENT_TRANSPORT");
        if (transport == null || transport.isEmpty() || "okhttp".equals(transport)) {
            apache = null;
            okhttp = new OkHttpClient.Builder()
                    .callTimeout(10, TimeUnit.SECONDS)
                    .build();
            builder.httpTransport(new OkHttpTransport(okhttp));
        } else if ("apache".equals(transport)) {
            okhttp = null;
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000)
                    .build();
            apache = HttpClients.custom()
                    .disableAutomaticRetries()
                    .disableRedirectHandling()
                    .setDefaultRequestConfig(config)
                    .build();
            ApacheHttpClientTransport httpTransport = ApacheHttpClientTransport.newBuilder()
                    .httpclient(apache)
                    .build();
            builder.httpTransport(httpTransport);
        } else {
            throw new IllegalArgumentException("AGENT_TRANSPORT must be okhttp or apache");
        }
        client = builder.build();
    }

    static String required(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty() || value.indexOf('\r') >= 0 ||
                value.indexOf('\n') >= 0 || value.indexOf('\0') >= 0) {
            throw new IllegalArgumentException("set a valid " + name + " environment variable");
        }
        return value;
    }

    static <T> T checked(BaseResponse<T> response, String action) {
        if (!response.success()) {
            int status = response.getRawResponse().getStatusCode();
            throw new IllegalStateException(
                    action + ": HTTP " + status + ", code " + response.getCode());
        }
        if (response.getData() == null) {
            throw new IllegalStateException(action + ": missing response data");
        }
        return response.getData();
    }

    private void run(String mode) throws Exception {
        switch (mode) {
            case "chat":
                AgentConversation.chat(this);
                break;
            case "upload":
                AgentUpload.upload(this);
                break;
            case "resume":
            case "close":
                String sid = required("AGENT_SESSION_ID");
                String query = required("AGENT_QUERY_MESSAGE_ID");
                String cursor = "resume".equals(mode) ? required("AGENT_LAST_EVENT_ID") : "";
                boolean closeEarly = "close".equals(mode);
                AgentConversation.read(this, sid, query, cursor, closeEarly);
                break;
            case "interrupt":
                AgentConversation.interrupt(this);
                break;
            default:
                throw new IllegalArgumentException(
                        "mode must be chat, upload, resume, close or interrupt");
        }
    }

    @Override
    public void close() throws Exception {
        if (apache != null) {
            apache.close();
        }
        if (okhttp != null) {
            okhttp.connectionPool().evictAll();
            okhttp.dispatcher().executorService().shutdown();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: AgentSample chat|upload|resume|close|interrupt");
            System.exit(1);
        }
        try (AgentSample example = new AgentSample()) {
            example.run(args[0]);
        } catch (Exception error) {
            // Do not dump requests, credentials or response bodies on failure.
            boolean readable = error instanceof IllegalStateException ||
                    error instanceof IllegalArgumentException;
            String message = readable ? error.getMessage() : error.getClass().getSimpleName();
            System.err.println(message);
            System.exit(1);
        }
    }
}
