package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.SetCheckboardAccessCodeRoomConfigReq;
import com.lark.oapi.service.vc.v1.model.SetCheckboardAccessCodeRoomConfigReqBody;
import com.lark.oapi.service.vc.v1.model.SetCheckboardAccessCodeRoomConfigResp;

// POST /open-apis/vc/v1/room_configs/set_checkboard_access_code
public class SetCheckboardAccessCodeRoomConfigSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SetCheckboardAccessCodeRoomConfigReq req = SetCheckboardAccessCodeRoomConfigReq.newBuilder()
                .setCheckboardAccessCodeRoomConfigReqBody(SetCheckboardAccessCodeRoomConfigReqBody.newBuilder()
                        .scope(5)
                        .countryId("1")
                        .districtId("2")
                        .buildingId("3")
                        .floorName("4")
                        .roomId("67687262867363")
                        .validDay(1)
                        .build())
                .build();

        // 发起请求
        SetCheckboardAccessCodeRoomConfigResp resp = client.vc().roomConfig().setCheckboardAccessCode(req);

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
