package com.lark.oapi.sample.apiall.applicationv7;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v7.model.*;

import java.util.HashMap;

// POST /open-apis/application/v7/applications/:app_id/publish
public class CreateApplicationPublishSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateApplicationPublishReq req = CreateApplicationPublishReq.newBuilder()
                .appId("cli_a508dbf34038d01c")
                .createApplicationPublishReqBody(CreateApplicationPublishReqBody.newBuilder()
                        .mobileDefaultAbility("gadget")
                        .pcDefaultAbility("gadget")
                        .remark("更新了移动端默认应用能力")
                        .changelog("更新了小程序的头像")
                        .version("1.1.1")
                        .build())
                .build();

        // 发起请求
        CreateApplicationPublishResp resp = client.application().v7().applicationPublish().create(req);

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
