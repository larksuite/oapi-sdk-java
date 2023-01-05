package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.ListSpaceReq;
import com.lark.oapi.service.wiki.v2.model.ListSpaceResp;

// GET /open-apis/wiki/v2/spaces
public class ListSpaceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSpaceReq req = ListSpaceReq.newBuilder()
                .pageSize(10)
                .pageToken("1565676577122621")
                .build();

        // 发起请求
        ListSpaceResp resp = client.wiki().space().list(req);

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
