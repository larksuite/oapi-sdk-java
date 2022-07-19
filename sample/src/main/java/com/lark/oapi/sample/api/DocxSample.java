package com.lark.oapi.sample.api;

import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Lists;
import com.lark.oapi.service.docx.v1.model.CreateDocumentReq;
import com.lark.oapi.service.docx.v1.model.CreateDocumentReqBody;
import com.lark.oapi.service.docx.v1.model.CreateDocumentResp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocxSample {

  public static void main(String arg[]) throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret).build();

    // 创建自定义 Headers
    Map<String, List<String>> headers = new HashMap<>();
    headers.put("key1", Lists.newArrayList("value1"));
    headers.put("key2", Lists.newArrayList("value2"));

    // 发起请求
    CreateDocumentResp resp = client.docx().document()
        .create(CreateDocumentReq.newBuilder()
                .createDocumentReqBody(CreateDocumentReqBody.newBuilder()
                    .title("title")
                    .folderToken("fldcniHf40Vcv1DoEc8SXeuA0Zd")
                    .build())
                .build()
            , RequestOptions.newBuilder()
                .userAccessToken("u-2GxFH7ysh8E9lj9UJp8XAG0k0gh1h5KzM800khEw2G6e") // 传递用户token
                .headers(headers) // 传递自定义 Headers
                .requestId("xxxx")
                .build());

    // 处理服务端错误
    if (!resp.success()) {
      System.out.println(String.format("code:%s,msg:%s,reqId:%s"
          , resp.getCode(), resp.getMsg(), resp.getRequestId()));
      return;
    }

    // 业务数据处理
    System.out.println(Jsons.DEFAULT.toJson(resp.getCreateDocument()));
  }
}

