package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.ListTasklistReq;
import com.lark.oapi.service.task.v2.model.ListTasklistResp;

// GET /open-apis/task/v2/tasklists
public class ListTasklistSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListTasklistReq req = ListTasklistReq.newBuilder()
                .pageSize(50)
                .pageToken("aWQ9NzEwMjMzMjMxMDE=")
                .userIdType("open_id")
                .build();

        // 发起请求
        ListTasklistResp resp = client.task().v2().tasklist().list(req);

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
