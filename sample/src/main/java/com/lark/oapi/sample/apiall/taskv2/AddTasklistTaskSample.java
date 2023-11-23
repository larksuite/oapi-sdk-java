package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.AddTasklistTaskReq;
import com.lark.oapi.service.task.v2.model.AddTasklistTaskReqBody;
import com.lark.oapi.service.task.v2.model.AddTasklistTaskResp;

// POST /open-apis/task/v2/tasks/:task_guid/add_tasklist
public class AddTasklistTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddTasklistTaskReq req = AddTasklistTaskReq.newBuilder()
                .taskGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
                .userIdType("open_id")
                .addTasklistTaskReqBody(AddTasklistTaskReqBody.newBuilder()
                        .tasklistGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
                        .sectionGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
                        .build())
                .build();

        // 发起请求
        AddTasklistTaskResp resp = client.task().v2().task().addTasklist(req);

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
