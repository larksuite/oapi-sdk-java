package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.DeleteRoomReq;
import com.lark.oapi.service.vc.v1.model.DeleteRoomResp;

// DELETE /open-apis/vc/v1/rooms/:room_id
public class DeleteRoomSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteRoomReq req = DeleteRoomReq.newBuilder()
                .roomId("omm_4de32cf10a4358788ff4e09e37ebbf9b")
                .build();

        // 发起请求
        DeleteRoomResp resp = client.vc().v1().room().delete(req);

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
