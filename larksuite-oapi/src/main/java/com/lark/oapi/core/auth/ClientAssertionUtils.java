package com.lark.oapi.core.auth;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.utils.Strings;

import java.net.URI;

public final class ClientAssertionUtils {
    private ClientAssertionUtils() {
    }

    public static String resolveOAuthBaseUrl(Config config) {
        if (config != null && Strings.isNotEmpty(config.getOAuthBaseUrl())) {
            return normalizeBaseUrl(config.getOAuthBaseUrl());
        }

        String aud = extractAudFromUrl(config == null ? null : config.getBaseUrl());
        if (extractAudFromUrl(BaseUrlEnum.FeiShu.getUrl()).equals(aud)) {
            return "https://accounts.feishu.cn";
        }
        if (extractAudFromUrl(BaseUrlEnum.LarkSuite.getUrl()).equals(aud)) {
            return "https://accounts.larksuite.com";
        }

        throw new IllegalArgumentException("OAuthBaseUrl is not configured. When BaseUrl is set to a non-default value (neither open.feishu.cn nor open.larksuite.com), you must explicitly configure OAuthBaseUrl via oauthBaseUrl(...)");
    }

    public static String resolveOAuthAud(Config config) {
        return extractAudFromUrl(resolveOAuthBaseUrl(config));
    }

    public static String extractAudFromUrl(String rawUrl) {
        if (Strings.isEmpty(rawUrl)) {
            throw new IllegalArgumentException("invalid url : " + rawUrl);
        }
        String normalized = rawUrl.contains("://") ? rawUrl : "https://" + rawUrl;
        URI uri = URI.create(normalized);
        if (uri.getHost() == null) {
            throw new IllegalArgumentException("invalid url : " + rawUrl);
        }
        return uri.getPort() > 0 ? uri.getHost() + ":" + uri.getPort() : uri.getHost();
    }

    public static String buildProxyUrl(String targetService, String targetPrefix, String apiPath) {
        String service = targetService.contains("://") ? targetService : "https://" + targetService;
        String prefix = targetPrefix == null ? "" : targetPrefix;
        return service + prefix + apiPath;
    }

    public static String normalizeBaseUrl(String baseUrl) {
        String normalized = baseUrl.contains("://") ? baseUrl : "https://" + baseUrl;
        while (normalized.endsWith("/")) {
            normalized = normalized.substring(0, normalized.length() - 1);
        }
        return normalized;
    }
}
