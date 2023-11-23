package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.BatchUserReq;
import com.lark.oapi.service.contact.v3.model.BatchUserResp;

// GET /open-apis/contact/v3/users/batch
public class BatchUserSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUserReq req = BatchUserReq.newBuilder()
                .userIds(new String[]{})
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .build();

        // 发起请求
        BatchUserResp resp = client.contact().v3().user().batch(req);

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
