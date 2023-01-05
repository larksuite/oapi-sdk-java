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

package com.lark.oapi.core.request;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.token.AccessTokenType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestReqTranslator {

    @Test
    public void testTranslator() throws Exception {

        ReqTranslator reqTranslator = new ReqTranslator();
        // 构建http body
        Map<String, Object> body = new HashMap<>();
        body.put("receive_id", "ou_c245b0a7dff2725cfa2fb104f8b48b9d");
        body.put("content",
                "{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}");
        body.put("msg_type", "text");

        Config config = new Config();
        config.setAppId("appId");
        config.setAppSecret("appSecret");
        config.setDisableTokenCache(true);

        RequestOptions options = new RequestOptions();
        options.setTenantAccessToken("token");

        Object httpReq = reqTranslator.translate(body, AccessTokenType.Tenant, config, "POST",
                "https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=open_id", options);
        assert httpReq != null;

    }
}
