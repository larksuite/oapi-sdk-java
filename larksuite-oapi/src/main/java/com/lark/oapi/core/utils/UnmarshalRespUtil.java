/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.utils;

import com.lark.oapi.core.response.RawResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class UnmarshalRespUtil {

    private static final Logger log = LoggerFactory.getLogger(UnmarshalRespUtil.class);
    private static final int MAX_LOG_BODY_LENGTH = 500;

    public static <T> T unmarshalResp(RawResponse resp, Class<T> respClass) {
        String bodyStr = new String(resp.getBody(), StandardCharsets.UTF_8);
        int statusCode = resp.getStatusCode();
        if (statusCode < 200 || statusCode >= 300) {
            String truncatedBody = truncate(bodyStr);
            log.warn("unexpected response status, statusCode={}, body={}", statusCode, truncatedBody);
        }
        try {
            return Jsons.DEFAULT.fromJson(bodyStr, respClass);
        } catch (Exception e) {
            String truncatedBody = truncate(bodyStr);
            log.error("unmarshal response error, statusCode={}, body={}", statusCode, truncatedBody);
            throw e;
        }
    }

    private static String truncate(String body) {
        if (body.length() > MAX_LOG_BODY_LENGTH) {
            return body.substring(0, MAX_LOG_BODY_LENGTH) + "...(truncated)";
        }
        return body;
    }
}
