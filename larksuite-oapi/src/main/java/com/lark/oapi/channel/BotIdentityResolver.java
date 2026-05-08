package com.lark.oapi.channel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.outbound.OutboundErrors;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import java.nio.charset.StandardCharsets;

final class BotIdentityResolver {
    private final Client client;
    private final LarkChannelOptions options;

    BotIdentityResolver(Client client, LarkChannelOptions options) {
        this.client = client;
        this.options = options;
    }

    BotIdentity fetch() {
        try {
            RawResponse response = client.get("/open-apis/bot/v3/info", null, AccessTokenType.Tenant,
                    options.getHttpInstance());
            if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
                throw new LarkChannelException(LarkChannelErrorCode.PERMISSION_DENIED,
                        "permission denied while fetching bot info");
            }
            if (response.getStatusCode() == 429) {
                throw new LarkChannelException(LarkChannelErrorCode.RATE_LIMITED,
                        "rate limited while fetching bot info");
            }
            JsonObject json = JsonParser.parseString(new String(response.getBody(), StandardCharsets.UTF_8)).getAsJsonObject();
            int code = json.has("code") ? json.get("code").getAsInt() : -1;
            if (code == 99991401 || code == 99991400) {
                throw new LarkChannelException(LarkChannelErrorCode.PERMISSION_DENIED,
                        "permission denied while fetching bot info");
            }
            JsonObject data = firstObject(json, "bot", "data");
            String openId = optString(data, "open_id");
            if ((openId == null || openId.isEmpty()) && code != 0) {
                throw new LarkChannelException(LarkChannelErrorCode.NOT_CONNECTED, "failed to fetch bot info: " + json);
            }
            if (openId == null || openId.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.NOT_CONNECTED, "could not resolve bot identity");
            }
            return new BotIdentity(openId, firstNonBlank(optString(data, "name"), optString(data, "app_name"), "bot"));
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            LarkChannelException classified = OutboundErrors.classifyError(e, "connect failed");
            if (LarkChannelErrorCode.UNKNOWN.getValue().equals(classified.getCode())) {
                throw new LarkChannelException(LarkChannelErrorCode.NOT_CONNECTED, "connect failed", null, e);
            }
            throw classified;
        }
    }

    private String firstNonBlank(String first, String second, String third) {
        if (first != null && !first.isEmpty()) {
            return first;
        }
        if (second != null && !second.isEmpty()) {
            return second;
        }
        return third;
    }

    private String optString(JsonObject object, String key) {
        if (object == null || !object.has(key) || object.get(key).isJsonNull()) {
            return null;
        }
        return object.get(key).getAsString();
    }

    private JsonObject firstObject(JsonObject object, String... keys) {
        if (object == null || keys == null) {
            return null;
        }
        for (String key : keys) {
            if (object.has(key) && object.get(key).isJsonObject()) {
                return object.getAsJsonObject(key);
            }
        }
        return null;
    }
}
