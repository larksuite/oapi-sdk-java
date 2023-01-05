package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.MeetingUser;
import com.lark.oapi.service.vc.v1.model.SetHostMeetingReq;
import com.lark.oapi.service.vc.v1.model.SetHostMeetingReqBody;
import com.lark.oapi.service.vc.v1.model.SetHostMeetingResp;

// PATCH /open-apis/vc/v1/meetings/:meeting_id/set_host
public class SetHostMeetingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SetHostMeetingReq req = SetHostMeetingReq.newBuilder()
                .meetingId("6911188411932033028")
                .userIdType("user_id")
                .setHostMeetingReqBody(SetHostMeetingReqBody.newBuilder()
                        .hostUser(MeetingUser.newBuilder().build())
                        .oldHostUser(MeetingUser.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        SetHostMeetingResp resp = client.vc().meeting().setHost(req);

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
