package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.SearchRoomReq;
import com.lark.oapi.service.vc.v1.model.SearchRoomReqBody;
import com.lark.oapi.service.vc.v1.model.SearchRoomResp;

// POST /open-apis/vc/v1/rooms/search
public class SearchRoomSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchRoomReq req = SearchRoomReq.newBuilder()
                .userIdType("user_id")
                .searchRoomReqBody(SearchRoomReqBody.newBuilder()
                        .customRoomIds(new String[]{})
                        .keyword("测试会议室")
                        .roomLevelId("omb_4ad1a2c7a2fbc5fc9570f38456931293")
                        .searchLevelName(true)
                        .pageSize(10)
                        .pageToken("0")
                        .build())
                .build();

        // 发起请求
        SearchRoomResp resp = client.vc().room().search(req);

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
