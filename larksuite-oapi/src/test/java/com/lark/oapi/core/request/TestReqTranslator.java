package com.lark.oapi.core.request;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.token.AccessTokenType;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

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
