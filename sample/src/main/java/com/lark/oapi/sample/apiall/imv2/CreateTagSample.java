package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.CreateTag;
import com.lark.oapi.service.im.v2.model.CreateTagReq;
import com.lark.oapi.service.im.v2.model.CreateTagReqBody;
import com.lark.oapi.service.im.v2.model.CreateTagResp;

// POST /open-apis/im/v2/tags
public class CreateTagSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateTagReq req = CreateTagReq.newBuilder()
                .createTagReqBody(CreateTagReqBody.newBuilder()
                        .createTag(CreateTag.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateTagResp resp = client.im().v2().tag().create(req);

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