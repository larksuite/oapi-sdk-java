package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/spark/v1/apps/:app_id/tables/:table_name/records
public class DeleteTableRecordsAppTableSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTableRecordsAppTableReq req = DeleteTableRecordsAppTableReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .tableName("table_name_1")
                .filter("age=gt.10")
                .env("online")
                .build();

        // 发起请求
        DeleteTableRecordsAppTableResp resp = client.spark().v1().appTable().deleteTableRecords(req);

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
