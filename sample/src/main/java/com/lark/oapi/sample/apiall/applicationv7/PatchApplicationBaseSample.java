package com.lark.oapi.sample.apiall.applicationv7;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v7.model.*;

import java.util.HashMap;

// PATCH /open-apis/application/v7/applications/:app_id/base
public class PatchApplicationBaseSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchApplicationBaseReq req = PatchApplicationBaseReq.newBuilder()
                .appId("cli_a306c5476fb8d00c")
                .patchApplicationBaseReqBody(PatchApplicationBaseReqBody.newBuilder()
                        .i18ns(new AppI18nInfo[]{})
                        .avatarUrl("https://s3-imfile.feishucdn.com/static-resource/v1/v2_953a8fc1-50bd-4b2e-87e2-b09e47dba23g")
                        .homepageUrl("https://open.feishu.cn/")
                        .build())
                .build();

        // 发起请求
        PatchApplicationBaseResp resp = client.application().v7().applicationBase().patch(req);

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
