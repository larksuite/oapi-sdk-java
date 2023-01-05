package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.QueryRoomConfigReq;
import com.lark.oapi.service.vc.v1.model.QueryRoomConfigResp;

// GET /open-apis/vc/v1/room_configs/query
public class QueryRoomConfigSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryRoomConfigReq req = QueryRoomConfigReq.newBuilder()
                .scope(5)
                .countryId("1")
                .districtId("2")
                .buildingId("3")
                .floorName("4")
                .roomId("6383786266263")
                .userIdType("user_id")
                .build();

        // 发起请求
        QueryRoomConfigResp resp = client.vc().roomConfig().query(req);

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
