package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.HighlightEntityReq;
import com.lark.oapi.service.baike.v1.model.HighlightEntityReqBody;
import com.lark.oapi.service.baike.v1.model.HighlightEntityResp;

// POST /open-apis/baike/v1/entities/highlight
public class HighlightEntitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        HighlightEntityReq req = HighlightEntityReq.newBuilder()
                .highlightEntityReqBody(HighlightEntityReqBody.newBuilder()
                        .text("企业百科是飞书提供的一款知识管理工具")
                        .build())
                .build();

        // 发起请求
        HighlightEntityResp resp = client.baike().entity().highlight(req);

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
