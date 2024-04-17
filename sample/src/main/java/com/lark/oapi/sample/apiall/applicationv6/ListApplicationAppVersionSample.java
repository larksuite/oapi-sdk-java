package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.ListApplicationAppVersionReq;
import com.lark.oapi.service.application.v6.model.ListApplicationAppVersionResp;

// GET /open-apis/application/v6/applications/:app_id/app_versions
public class ListApplicationAppVersionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListApplicationAppVersionReq req = ListApplicationAppVersionReq.newBuilder()
                .appId("cli_9b445f5258795107")
                .lang("zh_cn")
                .pageSize(20)
                .pageToken("new-e3c5a0627cdf0c2e057da7257b90376a")
                .order(0)
                .userIdType("user_id")
                .build();

        // 发起请求
        ListApplicationAppVersionResp resp = client.application().v6().applicationAppVersion().list(req);

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
