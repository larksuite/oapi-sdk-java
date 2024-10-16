package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/tasks/:task_guid/add_reminders
public class AddRemindersTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddRemindersTaskReq req = AddRemindersTaskReq.newBuilder()
                .taskGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
                .userIdType("open_id")
                .addRemindersTaskReqBody(AddRemindersTaskReqBody.newBuilder()
                        .reminders(new Reminder[]{})
                        .build())
                .build();

        // 发起请求
        AddRemindersTaskResp resp = client.task().v2().task().addReminders(req);

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
