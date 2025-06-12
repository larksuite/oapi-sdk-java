package com.lark.oapi.sample.apiall.wikiv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v1.model.*;

import java.util.HashMap;

// POST /open-apis/wiki/v1/nodes/search
public class SearchNodeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchNodeReq req = SearchNodeReq.newBuilder()
                .pageToken("")
                .pageSize(20)
                .searchNodeReqBody(SearchNodeReqBody.newBuilder()
                        .query("123")
                        .spaceId("6967549310762221587")
                        .nodeId("O5UIw9NA8iW308kQQeybWLZqcXc")
                        .build())
                .build();

        // 发起请求
        SearchNodeResp resp = client.wiki().v1().node().search(req);

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
