package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.GetRoomLevelReq;
import com.lark.oapi.service.vc.v1.model.GetRoomLevelResp;

// GET /open-apis/vc/v1/room_levels/:room_level_id
public class GetRoomLevelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetRoomLevelReq req = GetRoomLevelReq.newBuilder()
                .roomLevelId("omb_57c9cc7d9a81e27e54c8fabfd02759e7")
                .build();

        // 发起请求
        GetRoomLevelResp resp = client.vc().roomLevel().get(req);

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
