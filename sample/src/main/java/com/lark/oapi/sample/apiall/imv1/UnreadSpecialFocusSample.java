package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.UnreadSpecialFocusReq;
import com.lark.oapi.service.im.v1.model.UnreadSpecialFocusReqBody;
import com.lark.oapi.service.im.v1.model.UnreadSpecialFocusResp;

// POST /open-apis/im/v1/special_focus/unread
public class UnreadSpecialFocusSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UnreadSpecialFocusReq req = UnreadSpecialFocusReq.newBuilder()
                .memberIdType("open_id")
                .unreadSpecialFocusReqBody(UnreadSpecialFocusReqBody.newBuilder()
                        .idList(new String[]{})
                        .chatMode("group")
                        .build())
                .build();

        // 发起请求
        UnreadSpecialFocusResp resp = client.im().specialFocus().unread(req);

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
