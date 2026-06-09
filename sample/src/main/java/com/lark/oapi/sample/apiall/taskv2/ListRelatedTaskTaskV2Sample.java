package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// GET /open-apis/task/v2/task_v2/list_related_task
public class ListRelatedTaskTaskV2Sample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListRelatedTaskTaskV2Req req = ListRelatedTaskTaskV2Req.newBuilder()
                .pageSize(0)
                .pageToken("")
                .completed(false)
                .userIdType("user_id")
                .build();

        // 发起请求
        ListRelatedTaskTaskV2Resp resp = client.task().v2().taskV2().listRelatedTask(req);

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
