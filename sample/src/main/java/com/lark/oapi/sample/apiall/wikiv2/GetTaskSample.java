package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.GetTaskReq;
import com.lark.oapi.service.wiki.v2.model.GetTaskResp;

// GET /open-apis/wiki/v2/tasks/:task_id
public class GetTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetTaskReq req = GetTaskReq.newBuilder()
                .taskId("7037044037068177428-075c9481e6a0007c1df689dfbe5b55a08b6b06f7")
                .taskType("move")
                .build();

        // 发起请求
        GetTaskResp resp = client.wiki().task().get(req);

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
