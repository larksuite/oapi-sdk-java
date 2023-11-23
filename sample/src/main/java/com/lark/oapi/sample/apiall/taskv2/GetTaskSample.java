package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.GetTaskReq;
import com.lark.oapi.service.task.v2.model.GetTaskResp;

// GET /open-apis/task/v2/tasks/:task_guid
public class GetTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetTaskReq req = GetTaskReq.newBuilder()
                .taskGuid("e297ddff-06ca-4166-b917-4ce57cd3a7a0")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetTaskResp resp = client.task().v2().task().get(req);

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
