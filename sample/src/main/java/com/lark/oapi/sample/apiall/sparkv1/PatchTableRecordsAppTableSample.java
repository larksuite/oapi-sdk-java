package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// PATCH /open-apis/spark/v1/apps/:app_id/tables/:table_name/records
public class PatchTableRecordsAppTableSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchTableRecordsAppTableReq req = PatchTableRecordsAppTableReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .tableName("table_name_1")
                .filter("age=gt.10")
                .env("online")
                .userIdentifierType("miaoda_user_id")
                .patchTableRecordsAppTableReqBody(PatchTableRecordsAppTableReqBody.newBuilder()
                        .record("")
                        .build())
                .build();

        // 发起请求
        PatchTableRecordsAppTableResp resp = client.spark().v1().appTable().patchTableRecords(req);

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
