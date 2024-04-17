package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.DeleteTaskFollowerReq;
import com.lark.oapi.service.task.v1.model.DeleteTaskFollowerResp;

// DELETE /open-apis/task/v1/tasks/:task_id/followers/:follower_id
public class DeleteTaskFollowerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTaskFollowerReq req = DeleteTaskFollowerReq.newBuilder()
                .taskId("83912691-2e43-47fc-94a4-d512e03984fa")
                .followerId("ou_87e1a581b36ecc4862cbfbce473f346a")
                .userIdType("user_id")
                .build();

        // 发起请求
        DeleteTaskFollowerResp resp = client.task().v1().taskFollower().delete(req);

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
