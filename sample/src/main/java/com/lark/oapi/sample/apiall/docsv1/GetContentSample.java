package com.lark.oapi.sample.apiall.docsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docs.v1.model.*;

import java.util.HashMap;

// GET /open-apis/docs/v1/content
public class GetContentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetContentReq req = GetContentReq.newBuilder()
                .docToken("B4EPdAYx8oi8HRxgPQQbM15UcBf")
                .docType("docx")
                .contentType("markdown")
                .lang("zh")
                .build();

        // 发起请求
        GetContentResp resp = client.docs().v1().content().get(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
