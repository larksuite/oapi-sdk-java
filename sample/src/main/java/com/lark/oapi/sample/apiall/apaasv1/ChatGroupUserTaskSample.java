package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// POST /open-apis/apaas/v1/user_tasks/:task_id/chat_group
public class ChatGroupUserTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ChatGroupUserTaskReq req = ChatGroupUserTaskReq.newBuilder()
                .taskId("1234")
                .chatGroupUserTaskReqBody(ChatGroupUserTaskReqBody.newBuilder()
                        .operatorUserId("1234")
                        .inviteUserIds(new String[]{})
                        .chatId("oc_1234")
                        .chatName("群名称")
                        .build())
                .build();

        // 发起请求
        ChatGroupUserTaskResp resp = client.apaas().v1().userTask().chatGroup(req);

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
