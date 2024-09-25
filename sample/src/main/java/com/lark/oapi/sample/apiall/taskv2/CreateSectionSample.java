package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.CreateSectionReq;
import com.lark.oapi.service.task.v2.model.CreateSectionResp;
import com.lark.oapi.service.task.v2.model.InputSection;

// POST /open-apis/task/v2/sections
public class CreateSectionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateSectionReq req = CreateSectionReq.newBuilder()
                .userIdType("open_id")
                .inputSection(InputSection.newBuilder()
                        .name("已经审核过的任务")
                        .resourceType("tasklist")
                        .resourceId("cc371766-6584-cf50-a222-c22cd9055004")
                        .insertBefore("e6e37dcc-f75a-5936-f589-12fb4b5c80c2")
                        .insertAfter("e6e37dcc-f75a-5936-f589-12fb4b5c80c2")
                        .build())
                .build();

        // 发起请求
        CreateSectionResp resp = client.task().v2().section().create(req);

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
