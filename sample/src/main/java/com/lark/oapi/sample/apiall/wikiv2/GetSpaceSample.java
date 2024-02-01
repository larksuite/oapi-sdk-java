package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.GetSpaceReq;
import com.lark.oapi.service.wiki.v2.model.GetSpaceResp;

// GET /open-apis/wiki/v2/spaces/:space_id
public class GetSpaceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetSpaceReq req = GetSpaceReq.newBuilder()
                .spaceId("6870403571079249922")
                .lang("en")
                .build();

        // 发起请求
        GetSpaceResp resp = client.wiki().v2().space().get(req);

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
