package com.lark.oapi.e2e;

import com.lark.oapi.core.auth.ClientAssertionProvider;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.okhttp.Dns;
import com.lark.oapi.okhttp.OkHttpClient;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

final class ClientAssertionLiveHarness {
    static final DeployDomains ONLINE_DOMAINS = new DeployDomains(
            "https://open.feishu.cn",
            "https://accounts.feishu.cn");
    static final DeployDomains BOE_DOMAINS = new DeployDomains(
            "https://open.feishu-boe.cn",
            "https://accounts.feishu-boe.cn");

    private ClientAssertionLiveHarness() {
    }

    static boolean parseBool(String value, boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        if ("1".equals(normalized)
                || "true".equals(normalized)
                || "yes".equals(normalized)
                || "y".equals(normalized)
                || "on".equals(normalized)) {
            return true;
        }
        if ("0".equals(normalized)
                || "false".equals(normalized)
                || "no".equals(normalized)
                || "n".equals(normalized)
                || "off".equals(normalized)) {
            return false;
        }
        return defaultValue;
    }

    static DeployDomains deployDomains(String deployEnv) {
        String normalized = deployEnv == null ? "online" : deployEnv.trim().toLowerCase(Locale.ROOT);
        if ("online".equals(normalized)
                || "prod".equals(normalized)
                || "production".equals(normalized)
                || "cn".equals(normalized)) {
            return ONLINE_DOMAINS;
        }
        if ("boe".equals(normalized)) {
            return BOE_DOMAINS;
        }
        throw new IllegalArgumentException("LARK_DEPLOY_ENV must be online or boe");
    }

    static boolean loadEnvFile(File file, Map<String, String> env, boolean override) throws IOException {
        if (file == null || !file.isFile()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String rawLine;
            while ((rawLine = reader.readLine()) != null) {
                String line = rawLine.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                if (line.startsWith("export ")) {
                    line = line.substring("export ".length()).trim();
                }
                int equals = line.indexOf('=');
                if (equals <= 0) {
                    continue;
                }
                String key = line.substring(0, equals).trim();
                String value = parseEnvValue(line.substring(equals + 1).trim());
                if (!override && env.containsKey(key)) {
                    continue;
                }
                env.put(key, value);
            }
        }
        return true;
    }

    static Env loadEnv() throws IOException {
        Map<String, String> values = new LinkedHashMap<>();
        values.putAll(System.getenv());

        String envFile = firstNonEmpty(
                System.getProperty("lark.e2e.envFile"),
                System.getenv("LARK_E2E_ENV_FILE"));
        if (Strings.isNotEmpty(envFile)) {
            loadEnvFile(new File(envFile), values, false);
        }
        return new Env(values);
    }

    static String buildAuthorizeUrl(String oauthBaseUrl,
                                    String appId,
                                    String redirectUri,
                                    String scope,
                                    String state,
                                    String codeChallenge) {
        Map<String, String> query = new LinkedHashMap<>();
        query.put("app_id", appId);
        query.put("redirect_uri", redirectUri);
        query.put("scope", scope);
        query.put("state", state);
        if (Strings.isNotEmpty(codeChallenge)) {
            query.put("code_challenge", codeChallenge);
            query.put("code_challenge_method", "S256");
        }

        StringBuilder url = new StringBuilder(trimTrailingSlash(oauthBaseUrl))
                .append("/open-apis/authen/v1/authorize?");
        boolean first = true;
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (!first) {
                url.append('&');
            }
            first = false;
            url.append(urlEncode(entry.getKey())).append('=').append(urlEncode(entry.getValue()));
        }
        return url.toString();
    }

    static String randomState() {
        byte[] bytes = new byte[24];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    static String randomCodeVerifier() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    static String codeChallenge(String verifier) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return Base64.getUrlEncoder().withoutPadding()
                .encodeToString(digest.digest(verifier.getBytes(StandardCharsets.US_ASCII)));
    }

    static String caseId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }

    static String extractHost(String url) {
        URI uri = URI.create(url);
        if (Strings.isNotEmpty(uri.getHost())) {
            return uri.getHost();
        }
        String noScheme = url.replaceFirst("^https?://", "");
        int slash = noScheme.indexOf('/');
        String hostPort = slash >= 0 ? noScheme.substring(0, slash) : noScheme;
        int colon = hostPort.indexOf(':');
        return colon >= 0 ? hostPort.substring(0, colon) : hostPort;
    }

    static OAuthCallbackServer startCallbackServer(String redirectUri, String expectedState) throws IOException {
        return OAuthCallbackServer.start(redirectUri, expectedState);
    }

    static OkHttpClient okHttpClient(Env env, long callTimeout, TimeUnit timeUnit) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .callTimeout(callTimeout, timeUnit);
        Dns dns = proxyDnsOverride(env);
        if (dns != null) {
            builder.dns(dns);
        }
        return builder.build();
    }

    private static Dns proxyDnsOverride(Env env) {
        String proxyService = env.get("LARK_GDPR_PROXY_SERVICE");
        String resolveIp = env.get("LARK_GDPR_PROXY_RESOLVE_IP");
        if (Strings.isEmpty(proxyService) || Strings.isEmpty(resolveIp)) {
            return null;
        }
        String proxyHost = extractHost(proxyService);
        return hostname -> {
            if (proxyHost.equalsIgnoreCase(hostname)) {
                return Collections.singletonList(InetAddress.getByName(resolveIp));
            }
            return Dns.SYSTEM.lookup(hostname);
        };
    }

    private static String parseEnvValue(String rawValue) {
        String withoutComment = stripComment(rawValue).trim();
        if (withoutComment.length() >= 2) {
            char first = withoutComment.charAt(0);
            char last = withoutComment.charAt(withoutComment.length() - 1);
            if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
                return unescapeQuoted(withoutComment.substring(1, withoutComment.length() - 1), first);
            }
        }
        return withoutComment;
    }

    private static String stripComment(String value) {
        boolean inSingle = false;
        boolean inDouble = false;
        boolean escaped = false;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (escaped) {
                escaped = false;
                continue;
            }
            if (ch == '\\' && inDouble) {
                escaped = true;
                continue;
            }
            if (ch == '\'' && !inDouble) {
                inSingle = !inSingle;
                continue;
            }
            if (ch == '"' && !inSingle) {
                inDouble = !inDouble;
                continue;
            }
            if (ch == '#' && !inSingle && !inDouble && (i == 0 || Character.isWhitespace(value.charAt(i - 1)))) {
                return value.substring(0, i);
            }
        }
        return value;
    }

    private static String unescapeQuoted(String value, char quote) {
        if (quote == '\'') {
            return value;
        }
        StringBuilder builder = new StringBuilder();
        boolean escaped = false;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (escaped) {
                if (ch == 'n') {
                    builder.append('\n');
                } else if (ch == 't') {
                    builder.append('\t');
                } else {
                    builder.append(ch);
                }
                escaped = false;
                continue;
            }
            if (ch == '\\') {
                escaped = true;
                continue;
            }
            builder.append(ch);
        }
        if (escaped) {
            builder.append('\\');
        }
        return builder.toString();
    }

    private static String trimTrailingSlash(String value) {
        if (value.endsWith("/")) {
            return value.substring(0, value.length() - 1);
        }
        return value;
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String urlDecode(String value) {
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String firstNonEmpty(String first, String second) {
        return Strings.isNotEmpty(first) ? first : second;
    }

    static final class DeployDomains {
        private final String openApiDomain;
        private final String oauthBaseUrl;

        private DeployDomains(String openApiDomain, String oauthBaseUrl) {
            this.openApiDomain = openApiDomain;
            this.oauthBaseUrl = oauthBaseUrl;
        }

        String getOpenApiDomain() {
            return openApiDomain;
        }

        String getOAuthBaseUrl() {
            return oauthBaseUrl;
        }
    }

    static final class Env {
        private final Map<String, String> values;

        Env(Map<String, String> values) {
            this.values = new LinkedHashMap<>(values);
        }

        boolean enabled() {
            return "1".equals(get("LARK_CLIENT_ASSERTION_E2E"));
        }

        String get(String key) {
            return values.get(key);
        }

        String require(String key) {
            String value = get(key);
            if (Strings.isEmpty(value)) {
                throw new IllegalStateException("missing env: " + key);
            }
            return value;
        }

        boolean bool(String key, boolean defaultValue) {
            return parseBool(get(key), defaultValue);
        }

        int intValue(String key, int defaultValue) {
            String value = get(key);
            if (Strings.isEmpty(value)) {
                return defaultValue;
            }
            return Integer.parseInt(value);
        }

        boolean modeEnabled(String mode) {
            String modes = get("LARK_E2E_MODES");
            if (Strings.isEmpty(modes)) {
                return true;
            }
            String expected = normalizeMode(mode);
            String[] parts = modes.split("[,\\s]+");
            for (String part : parts) {
                if (expected.equals(normalizeMode(part))) {
                    return true;
                }
            }
            return false;
        }

        DeployDomains domains() {
            DeployDomains defaults = deployDomains(get("LARK_DEPLOY_ENV"));
            return new DeployDomains(
                    firstNonEmpty(get("LARK_OPEN_BASE_URL"), defaults.getOpenApiDomain()),
                    firstNonEmpty(get("LARK_OAUTH_BASE_URL"), defaults.getOAuthBaseUrl()));
        }

        String authorizeBaseUrl() {
            return firstNonEmpty(get("LARK_AUTHORIZE_BASE_URL"), domains().getOAuthBaseUrl());
        }

        private String normalizeMode(String mode) {
            if (mode == null) {
                return "";
            }
            String normalized = mode.toLowerCase(Locale.ROOT).replace("-", "_");
            if ("secret".equals(normalized) || "appsecret".equals(normalized)) {
                return "app_secret";
            }
            return normalized;
        }
    }

    static final class ModeEnvProvider implements ClientAssertionProvider {
        private final String mode;
        private final Env env;
        private final List<String> auds = Collections.synchronizedList(new ArrayList<>());

        ModeEnvProvider(String mode, Env env) {
            if (!"zti".equals(mode) && !"gdpr".equals(mode)) {
                throw new IllegalArgumentException("mode must be zti or gdpr");
            }
            this.mode = mode;
            this.env = env;
        }

        @Override
        public ClientAssertionToken retrieveToken(String aud) {
            auds.add(aud);
            if ("zti".equals(mode)) {
                return new ClientAssertionToken(env.require("LARK_ZTI_CLIENT_ASSERTION"));
            }
            String prefix = env.require("LARK_GDPR_PROXY_PREFIX");
            if (!prefix.startsWith("/")) {
                throw new IllegalStateException("LARK_GDPR_PROXY_PREFIX must start with /");
            }
            return new ClientAssertionToken(
                    env.require("LARK_GDPR_CLIENT_ASSERTION"),
                    new TargetInfo(env.require("LARK_GDPR_PROXY_SERVICE"), prefix));
        }

        List<String> getAuds() {
            return auds;
        }

        String getMode() {
            return mode;
        }
    }

    static final class NoopCache implements ICache {
        @Override
        public String get(String key) {
            return "";
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
        }
    }

    static final class OAuthCallbackServer implements AutoCloseable {
        private final HttpServer server;
        private final ArrayBlockingQueue<Map<String, String>> queue;

        private OAuthCallbackServer(HttpServer server,
                                    ArrayBlockingQueue<Map<String, String>> queue) {
            this.server = server;
            this.queue = queue;
        }

        static OAuthCallbackServer start(String redirectUri, String expectedState) throws IOException {
            URI uri = URI.create(redirectUri);
            if (!"http".equals(uri.getScheme())
                    || (!"127.0.0.1".equals(uri.getHost()) && !"localhost".equals(uri.getHost()))) {
                throw new IllegalArgumentException("LARK_OAUTH_REDIRECT_URI must be a local http callback");
            }
            if (uri.getPort() <= 0) {
                throw new IllegalArgumentException("LARK_OAUTH_REDIRECT_URI must include a port");
            }

            ArrayBlockingQueue<Map<String, String>> queue = new ArrayBlockingQueue<>(1);
            HttpServer server = HttpServer.create(new InetSocketAddress(uri.getHost(), uri.getPort()), 0);
            server.createContext(uri.getPath(), exchange -> {
                Map<String, String> params = parseQuery(exchange.getRequestURI().getRawQuery());
                if (!expectedState.equals(params.get("state"))) {
                    params.put("error", "state_mismatch");
                    queue.offer(params);
                    respond(exchange, 400, "OAuth state mismatch.");
                    return;
                }
                if (!params.containsKey("code")) {
                    params.putIfAbsent("error", "missing_code");
                    queue.offer(params);
                    respond(exchange, 400, "OAuth callback missing code.");
                    return;
                }
                queue.offer(params);
                respond(exchange, 200, "OAuth callback received. You can close this tab.");
            });

            server.start();
            return new OAuthCallbackServer(server, queue);
        }

        Map<String, String> await(int timeoutSeconds) throws InterruptedException {
            return queue.poll(timeoutSeconds, TimeUnit.SECONDS);
        }

        @Override
        public void close() {
            server.stop(0);
        }

        private static void respond(com.sun.net.httpserver.HttpExchange exchange,
                                    int status,
                                    String message) throws IOException {
            byte[] body = message.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(status, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        }

        private static Map<String, String> parseQuery(String rawQuery) {
            Map<String, String> params = new HashMap<>();
            if (rawQuery == null || rawQuery.isEmpty()) {
                return params;
            }
            String[] parts = rawQuery.split("&");
            for (String part : parts) {
                int equals = part.indexOf('=');
                if (equals < 0) {
                    params.put(urlDecode(part), "");
                } else {
                    params.put(urlDecode(part.substring(0, equals)), urlDecode(part.substring(equals + 1)));
                }
            }
            return params;
        }
    }
}
