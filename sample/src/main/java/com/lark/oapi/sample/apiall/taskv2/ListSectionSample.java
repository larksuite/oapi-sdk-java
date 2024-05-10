package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// GET /open-apis/task/v2/sections
public class ListSectionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSectionReq req = ListSectionReq.newBuilder()
                .pageSize(50)
                .pageToken("aWQ9NzEwMjMzMjMxMDE=")
                .resourceType("tasklist")
                .resourceId("caef228f-2342-23c1-c36d-91186414dc64")
                .userIdType("open_id")
                .build();

        // 发起请求
        ListSectionResp resp = client.task().v2().section().list(req);

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
