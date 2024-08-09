package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/tasks/:task_guid/add_members
public class AddMembersTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddMembersTaskReq req = AddMembersTaskReq.newBuilder()
                .taskGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
                .userIdType("open_id")
                .addMembersTaskReqBody(AddMembersTaskReqBody.newBuilder()
                        .members(new Member[]{})
                        .clientToken("6d99f59c-4d7d-4452-98d6-3d0556393cf6")
                        .build())
                .build();

        // 发起请求
        AddMembersTaskResp resp = client.task().v2().task().addMembers(req);

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
