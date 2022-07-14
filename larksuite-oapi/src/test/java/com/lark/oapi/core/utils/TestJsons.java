package com.lark.oapi.core.utils;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TestJsons {

  @Test
  public void testJsons() {
    Map<String, Object> body = new HashMap<>();
    body.put("receive_id", "ou_c245b0a7dff2725cfa2fb104f8b48b9d");
    body.put("content",
        "{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}");
    body.put("msg_type", "text");
    String str = Jsons.LONG_TO_STR.toJson(body);
    System.out.println(str);

    assert !str.equals("");

  }
}
