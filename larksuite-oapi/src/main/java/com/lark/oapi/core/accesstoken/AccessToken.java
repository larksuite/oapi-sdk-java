package com.lark.oapi.core.accesstoken;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.ClientAssertionUtils;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.exception.ClientAssertionException;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Lists;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.Strings;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessToken {
    private final Config config;

    public AccessToken(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public AccessTokenResp retrieveByAuthorizationCode(AuthorizationCodeTokenRequest request) throws Exception {
        return retrieveByAuthorizationCode(request, new RequestOptions());
    }

    public AccessTokenResp retrieveByAuthorizationCode(AuthorizationCodeTokenRequest request,
                                                       RequestOptions options) throws Exception {
        PreparedRequest prepared = prepareRequest(Constants.GRANT_TYPE_AUTHORIZATION_CODE, options);
        putIfNotEmpty(prepared.body, "code", request.getCode());
        putIfNotEmpty(prepared.body, "redirect_uri", request.getRedirectUri());
        putIfNotEmpty(prepared.body, "code_verifier", request.getCodeVerifier());
        putIfNotEmpty(prepared.body, "scope", request.getScope());
        return send(prepared, options);
    }

    public AccessTokenResp refresh(RefreshTokenRequest request) throws Exception {
        return refresh(request, new RequestOptions());
    }

    public AccessTokenResp refresh(RefreshTokenRequest request, RequestOptions options) throws Exception {
        PreparedRequest prepared = prepareRequest(Constants.GRANT_TYPE_REFRESH_TOKEN, options);
        putIfNotEmpty(prepared.body, "refresh_token", request.getRefreshToken());
        putIfNotEmpty(prepared.body, "scope", request.getScope());
        return send(prepared, options);
    }

    private PreparedRequest prepareRequest(String grantType, RequestOptions options) throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("grant_type", grantType);
        body.put("client_id", config.getAppId());
        String reqUrl = ClientAssertionUtils.resolveOAuthBaseUrl(config) + Constants.OAUTH_TOKEN_URL_PATH;

        if (config.getClientAssertionProvider() != null) {
            String aud = ClientAssertionUtils.resolveOAuthAud(config);
            ClientAssertionToken token;
            try {
                token = config.getClientAssertionProvider().retrieveToken(aud);
            } catch (Exception e) {
                throw new ClientAssertionException(
                        Constants.ERR_CODE_CLIENT_ASSERTION_RETRIEVE_FAILED,
                        e.getMessage(),
                        e);
            }
            if (token == null || Strings.isEmpty(token.getValue())) {
                throw new ClientAssertionException(
                        Constants.ERR_CODE_CLIENT_ASSERTION_TOKEN_EMPTY,
                        "client assertion token is empty");
            }
            body.put("client_assertion_type", Constants.CLIENT_ASSERTION_TYPE_JWT_BEARER);
            body.put("client_assertion", token.getValue());
            applyTargetInfo(options, aud, token.getTargetInfo());
            if (token.getTargetInfo() != null && Strings.isNotEmpty(token.getTargetInfo().getTargetService())) {
                reqUrl = ClientAssertionUtils.buildProxyUrl(
                        token.getTargetInfo().getTargetService(),
                        token.getTargetInfo().getTargetPrefix(),
                        Constants.OAUTH_TOKEN_URL_PATH);
            }
            return new PreparedRequest(body, reqUrl);
        }

        if (Strings.isNotEmpty(config.getAppSecret())) {
            body.put("client_secret", config.getAppSecret());
            return new PreparedRequest(body, reqUrl);
        }

        throw new ClientAssertionException(
                Constants.ERR_CODE_APP_SECRET_AND_CLIENT_ASSERTION_EMPTY,
                "AppSecret and ClientAssertionProvider cannot both be empty for AccessToken APIs");
    }

    private void applyTargetInfo(RequestOptions options, String aud, TargetInfo targetInfo) {
        if (targetInfo == null || Strings.isEmpty(targetInfo.getTargetService())) {
            return;
        }
        Map<String, List<String>> headers = options.getHeaders();
        if (headers == null) {
            headers = new HashMap<>();
            options.setHeaders(headers);
        }
        headers.put(Constants.HEADER_X_TARGET_SERVICE, Lists.newArrayList(aud));
    }

    private AccessTokenResp send(PreparedRequest prepared, RequestOptions options) throws Exception {
        RawResponse rawResponse = Transport.send(config,
                options,
                "POST",
                prepared.reqUrl,
                Sets.newHashSet(AccessTokenType.None),
                prepared.body);

        JsonObject jsonObject = parseBody(rawResponse);
        if (rawResponse.getStatusCode() < 200 || rawResponse.getStatusCode() >= 300) {
            throw new AccessTokenError(rawResponse.getStatusCode(),
                    getInt(jsonObject, "code"),
                    getString(jsonObject, "error"),
                    getString(jsonObject, "error_description"),
                    rawResponse);
        }

        AccessTokenRespData data = new AccessTokenRespData();
        data.setAccessToken(getString(jsonObject, "access_token"));
        data.setTokenType(getString(jsonObject, "token_type"));
        data.setExpiresIn(getInt(jsonObject, "expires_in"));
        data.setRefreshToken(getString(jsonObject, "refresh_token"));
        data.setRefreshTokenExpiresIn(getInt(jsonObject, "refresh_token_expires_in"));
        data.setScope(getString(jsonObject, "scope"));
        return new AccessTokenResp(rawResponse.getStatusCode(), rawResponse, data);
    }

    private JsonObject parseBody(RawResponse rawResponse) {
        if (rawResponse.getBody() == null || rawResponse.getBody().length == 0) {
            return new JsonObject();
        }
        return JsonParser.parseString(new String(rawResponse.getBody(), StandardCharsets.UTF_8)).getAsJsonObject();
    }

    private void putIfNotEmpty(Map<String, Object> body, String key, String value) {
        if (Strings.isNotEmpty(value)) {
            body.put(key, value);
        }
    }

    private String getString(JsonObject jsonObject, String key) {
        if (jsonObject == null || !jsonObject.has(key) || jsonObject.get(key).isJsonNull()) {
            return "";
        }
        return jsonObject.get(key).getAsString();
    }

    private int getInt(JsonObject jsonObject, String key) {
        if (jsonObject == null || !jsonObject.has(key) || jsonObject.get(key).isJsonNull()) {
            return 0;
        }
        return jsonObject.get(key).getAsInt();
    }

    private static class PreparedRequest {
        private final Map<String, Object> body;
        private final String reqUrl;

        private PreparedRequest(Map<String, Object> body, String reqUrl) {
            this.body = body;
            this.reqUrl = reqUrl;
        }
    }
}
