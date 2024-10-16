package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.*;

import java.util.HashMap;

// GET /open-apis/wiki/v2/spaces/:space_id/members
public class ListSpaceMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSpaceMemberReq req = ListSpaceMemberReq.newBuilder()
                .spaceId("7375263209671884820")
                .pageSize(1)
                .pageToken("ou_12345")
                .build();

        // 发起请求
        ListSpaceMemberResp resp = client.wiki().v2().spaceMember().list(req);

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
