package com.lark.oapi.sample.apiall.performancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v1.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v1/stage_tasks/find_by_user_list
public class FindByUserListStageTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        FindByUserListStageTaskReq req = FindByUserListStageTaskReq.newBuilder()
                .userIdType("open_id")
                .findByUserListStageTaskReqBody(FindByUserListStageTaskReqBody.newBuilder()
                        .semesterId("7033710017401751071")
                        .userIdLists(new String[]{})
                        .taskOptionLists(new Integer[]{})
                        .afterTime("1630425599999")
                        .beforeTime("1630425599999")
                        .build())
                .build();

        // 发起请求
        FindByUserListStageTaskResp resp = client.performance().v1().stageTask().findByUserList(req);

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
