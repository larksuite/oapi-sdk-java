package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.ListRoomReq;
import com.lark.oapi.service.vc.v1.model.ListRoomResp;

// GET /open-apis/vc/v1/rooms
public class ListRoomSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListRoomReq req = ListRoomReq.newBuilder()
                .pageSize(10)
                .pageToken("10")
                .roomLevelId("omb_4ad1a2c7a2fbc5fc9570f38456931293")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListRoomResp resp = client.vc().room().list(req);

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
