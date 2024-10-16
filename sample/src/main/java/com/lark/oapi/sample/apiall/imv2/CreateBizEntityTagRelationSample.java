package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.*;

import java.util.HashMap;

// POST /open-apis/im/v2/biz_entity_tag_relation
public class CreateBizEntityTagRelationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateBizEntityTagRelationReq req = CreateBizEntityTagRelationReq.newBuilder()
                .createBizEntityTagRelationReqBody(CreateBizEntityTagRelationReqBody.newBuilder()
                        .tagBizType("chat")
                        .bizEntityId("71616xxxx")
                        .tagIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateBizEntityTagRelationResp resp = client.im().v2().bizEntityTagRelation().create(req);

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
