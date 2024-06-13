package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.*;

import java.util.HashMap;

// POST /open-apis/baike/v1/entities/extract
public class ExtractEntitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ExtractEntityReq req = ExtractEntityReq.newBuilder()
                .extractEntityReqBody(ExtractEntityReqBody.newBuilder()
                        .text("企业百科是一部高效汇聚企业内各类信息，并可由企业成员参与编辑的在线百科全书")
                        .build())
                .build();

        // 发起请求
        ExtractEntityResp resp = client.baike().v1().entity().extract(req);

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
