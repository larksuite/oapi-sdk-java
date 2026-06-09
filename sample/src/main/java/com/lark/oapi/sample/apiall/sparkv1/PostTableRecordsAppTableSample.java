package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// POST /open-apis/spark/v1/apps/:app_id/tables/:table_name/records
public class PostTableRecordsAppTableSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PostTableRecordsAppTableReq req = PostTableRecordsAppTableReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .tableName("table_name_1")
                .columns("name,age")
                .onConflict("user_id,product_id")
                .env("online")
                .userIdentifierType("miaoda_user_id")
                .postTableRecordsAppTableReqBody(PostTableRecordsAppTableReqBody.newBuilder()
                        .records("")
                        .build())
                .build();

        // 发起请求
        PostTableRecordsAppTableResp resp = client.spark().v1().appTable().postTableRecords(req);

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
