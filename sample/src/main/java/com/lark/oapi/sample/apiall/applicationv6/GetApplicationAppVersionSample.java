package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.GetApplicationAppVersionReq;
import com.lark.oapi.service.application.v6.model.GetApplicationAppVersionResp;

// GET /open-apis/application/v6/applications/:app_id/app_versions/:version_id
public class GetApplicationAppVersionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetApplicationAppVersionReq req = GetApplicationAppVersionReq.newBuilder()
                .appId("cli_9f3ca975326b501b")
                .versionId("oav_d317f090b7258ad0372aa53963cda70d")
                .lang("zh_cn")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetApplicationAppVersionResp resp = client.application().applicationAppVersion().get(req);

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
