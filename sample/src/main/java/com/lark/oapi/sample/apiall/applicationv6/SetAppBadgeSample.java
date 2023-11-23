package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.AppBadge;
import com.lark.oapi.service.application.v6.model.ClientBadgeNum;
import com.lark.oapi.service.application.v6.model.SetAppBadgeReq;
import com.lark.oapi.service.application.v6.model.SetAppBadgeResp;

// POST /open-apis/application/v6/app_badge/set
public class SetAppBadgeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SetAppBadgeReq req = SetAppBadgeReq.newBuilder()
                .userIdType("user_id")
                .appBadge(AppBadge.newBuilder()
                        .userId("")
                        .version("")
                        .extra("")
                        .pc(ClientBadgeNum.newBuilder().build())
                        .mobile(ClientBadgeNum.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        SetAppBadgeResp resp = client.application().v6().appBadge().set(req);

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
