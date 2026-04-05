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

import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.RawResponse;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class TestUnmarshalRespUtil {

    public static class SimpleResp {
        @SerializedName("code")
        private int code;
        @SerializedName("msg")
        private String msg;

        public int getCode() { return code; }
        public String getMsg() { return msg; }
    }

    @Test
    public void testUnmarshalSuccess() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(200);
        raw.setBody("{\"code\":0,\"msg\":\"ok\"}".getBytes(StandardCharsets.UTF_8));

        SimpleResp resp = UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
        assert resp != null;
        assert resp.getCode() == 0;
        assert "ok".equals(resp.getMsg());
    }

    @Test(expected = JsonSyntaxException.class)
    public void testUnmarshalInvalidJson() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(502);
        raw.setBody("Bad Gateway".getBytes(StandardCharsets.UTF_8));

        UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testUnmarshalStringInsteadOfObject() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(200);
        raw.setBody("\"some error message\"".getBytes(StandardCharsets.UTF_8));

        UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testUnmarshalHtmlResponse() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(403);
        raw.setBody("<html><body>Forbidden</body></html>".getBytes(StandardCharsets.UTF_8));

        UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testUnmarshalLongBodyIsTruncatedInLog() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(500);
        StringBuilder sb = new StringBuilder("\"");
        for (int i = 0; i < 600; i++) {
            sb.append("x");
        }
        sb.append("\"");
        raw.setBody(sb.toString().getBytes(StandardCharsets.UTF_8));

        UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
    }

    @Test
    public void testUnmarshalNon2xxWithValidJson() {
        RawResponse raw = new RawResponse();
        raw.setStatusCode(400);
        raw.setBody("{\"code\":99991400,\"msg\":\"param error\"}".getBytes(StandardCharsets.UTF_8));

        SimpleResp resp = UnmarshalRespUtil.unmarshalResp(raw, SimpleResp.class);
        assert resp != null;
        assert resp.getCode() == 99991400;
    }
}
