package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/tasklists
public class CreateTasklistSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateTasklistReq req = CreateTasklistReq.newBuilder()
                .userIdType("open_id")
                .inputTasklist(InputTasklist.newBuilder()
                        .name("年会工作任务清单")
                        .members(new Member[]{})
                        .build())
                .build();

        // 发起请求
        CreateTasklistResp resp = client.task().v2().tasklist().create(req);

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
