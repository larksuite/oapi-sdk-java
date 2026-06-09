package com.lark.oapi.sample.apiall.performancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v1.model.*;

import java.util.HashMap;

// GET /open-apis/performance/v1/semesters
public class ListSemesterSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSemesterReq req = ListSemesterReq.newBuilder()
                .startTime("1630425599999")
                .endTime("1630425599999")
                .year(2024)
                .typeGroup("Month")
                .type("June")
                .userIdType("open_id")
                .build();

        // 发起请求
        ListSemesterResp resp = client.performance().v1().semester().list(req);

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
