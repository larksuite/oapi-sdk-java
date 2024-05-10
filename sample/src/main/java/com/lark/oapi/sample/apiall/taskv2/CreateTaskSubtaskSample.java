package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/tasks/:task_guid/subtasks
public class CreateTaskSubtaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateTaskSubtaskReq req = CreateTaskSubtaskReq.newBuilder()
                .taskGuid("e297ddff-06ca-4166-b917-4ce57cd3a7a0")
                .userIdType("open_id")
                .inputTask(InputTask.newBuilder()
                        .summary("针对全年销售进行一次复盘")
                        .description("需要事先阅读复盘总结文档")
                        .due(Due.newBuilder().build())
                        .origin(Origin.newBuilder().build())
                        .extra("dGVzdA==")
                        .completedAt("0")
                        .members(new Member[]{})
                        .repeatRule("FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,WE,TH,FR")
                        .customComplete(CustomComplete.newBuilder().build())
                        .tasklists(new TaskInTasklistInfo[]{})
                        .clientToken("daa2237f-8310-4707-a83b-52c8a81e0fb7")
                        .start(Start.newBuilder().build())
                        .reminders(new Reminder[]{})
                        .mode(2)
                        .isMilestone(false)
                        .customFields(new InputCustomFieldValue[]{})
                        .docxSource(DocxSource.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateTaskSubtaskResp resp = client.task().v2().taskSubtask().create(req);

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
