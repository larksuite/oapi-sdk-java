package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.InputTask;
import com.lark.oapi.service.task.v2.model.PatchTaskReq;
import com.lark.oapi.service.task.v2.model.PatchTaskReqBody;
import com.lark.oapi.service.task.v2.model.PatchTaskResp;

// PATCH /open-apis/task/v2/tasks/:task_guid
public class PatchTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchTaskReq req = PatchTaskReq.newBuilder()
                .taskGuid("e297ddff-06ca-4166-b917-4ce57cd3a7a0")
                .userIdType("open_id")
                .patchTaskReqBody(PatchTaskReqBody.newBuilder()
                        .task(InputTask.newBuilder().build())
                        .updateFields(new String[]{})
                        .build())
                .build();

        // 发起请求
        PatchTaskResp resp = client.task().v2().task().patch(req);

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
