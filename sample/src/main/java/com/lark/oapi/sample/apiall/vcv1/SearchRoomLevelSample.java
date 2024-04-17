package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.SearchRoomLevelReq;
import com.lark.oapi.service.vc.v1.model.SearchRoomLevelResp;

// GET /open-apis/vc/v1/room_levels/search
public class SearchRoomLevelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchRoomLevelReq req = SearchRoomLevelReq.newBuilder()
                .customLevelIds("1000,1001")
                .build();

        // 发起请求
        SearchRoomLevelResp resp = client.vc().v1().roomLevel().search(req);

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
