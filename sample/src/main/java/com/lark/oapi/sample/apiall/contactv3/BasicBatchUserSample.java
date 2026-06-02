package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;

import java.util.HashMap;

// POST /open-apis/contact/v3/users/basic_batch
public class BasicBatchUserSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BasicBatchUserReq req = BasicBatchUserReq.newBuilder()
                .userIdType("open_id")
                .basicBatchUserReqBody(BasicBatchUserReqBody.newBuilder()
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BasicBatchUserResp resp = client.contact().v3().user().basicBatch(req);

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
