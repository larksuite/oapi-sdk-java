package com.larksuite.oapi.core.utils;

import com.larksuite.oapi.core.response.RawResponse;

import java.nio.charset.StandardCharsets;

public class UnmarshalRespUtil {

    public static <T> T unmarshalResp(RawResponse resp, Class<T> respClass) {
        return Jsons.LONG_TO_STR_GSON.fromJson(new String(resp.getBody(), StandardCharsets.UTF_8), respClass);
    }
}
