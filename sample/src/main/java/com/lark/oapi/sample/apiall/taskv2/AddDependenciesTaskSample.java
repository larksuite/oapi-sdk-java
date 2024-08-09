package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/tasks/:task_guid/add_dependencies
public class AddDependenciesTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddDependenciesTaskReq req = AddDependenciesTaskReq.newBuilder()
                .taskGuid("93b7bd05-35e6-4371-b3c9-6b7cbd7100c0")
                .addDependenciesTaskReqBody(AddDependenciesTaskReqBody.newBuilder()
                        .dependencies(new TaskDependency[]{})
                        .build())
                .build();

        // 发起请求
        AddDependenciesTaskResp resp = client.task().v2().task().addDependencies(req);

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
