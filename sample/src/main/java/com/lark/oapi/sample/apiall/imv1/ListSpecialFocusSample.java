package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ListSpecialFocusReq;
import com.lark.oapi.service.im.v1.model.ListSpecialFocusResp;

// GET /open-apis/im/v1/special_focus
public class ListSpecialFocusSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSpecialFocusReq req = ListSpecialFocusReq.newBuilder()
                .memberIdType("open_id")
                .pageSize(100)
                .pageToken("eVQrYzJBNDNONlk4VFZBZVlSdzlKdFJ4bVVHVExENDNKVHoxaVdiVnViQT0=")
                .build();

        // 发起请求
        ListSpecialFocusResp resp = client.im().specialFocus().list(req);

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
