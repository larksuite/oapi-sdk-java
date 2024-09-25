package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;

// POST /open-apis/vc/v1/rooms
public class CreateRoomSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateRoomReq req = CreateRoomReq.newBuilder()
                .userIdType("open_id")
                .room(Room.newBuilder()
                        .name("测试会议室")
                        .capacity(10)
                        .description("测试会议室描述")
                        .customRoomId("1234")
                        .roomLevelId("omb_8d020b12fe49e82847c2af3c193d5754")
                        .roomStatus(RoomStatus.newBuilder().build())
                        .device(new Device[]{})
                        .build())
                .build();

        // 发起请求
        CreateRoomResp resp = client.vc().v1().room().create(req);

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
