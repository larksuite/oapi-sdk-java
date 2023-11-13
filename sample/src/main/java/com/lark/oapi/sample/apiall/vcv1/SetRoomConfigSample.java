package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.RoomConfig;
import com.lark.oapi.service.vc.v1.model.SetRoomConfigReq;
import com.lark.oapi.service.vc.v1.model.SetRoomConfigReqBody;
import com.lark.oapi.service.vc.v1.model.SetRoomConfigResp;

// POST /open-apis/vc/v1/room_configs/set
public class SetRoomConfigSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SetRoomConfigReq req = SetRoomConfigReq.newBuilder()
                .userIdType("user_id")
                .setRoomConfigReqBody(SetRoomConfigReqBody.newBuilder()
                        .scope(5)
                        .countryId("1")
                        .districtId("2")
                        .buildingId("3")
                        .floorName("4")
                        .roomId("67687262867363")
                        .roomConfig(RoomConfig.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        SetRoomConfigResp resp = client.vc().roomConfig().set(req);

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
