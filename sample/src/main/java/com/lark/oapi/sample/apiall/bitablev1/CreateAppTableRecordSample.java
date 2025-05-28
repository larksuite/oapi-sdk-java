package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records
public class CreateAppTableRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppTableRecordReq req = CreateAppTableRecordReq.newBuilder()
                .appToken("bascng7vrxcxpig7geggXiCtadY")
                .tableId("tblUa9vcYjWQYJCj")
                .userIdType("user_id")
                .clientToken("fe599b60-450f-46ff-b2ef-9f6675625b97")
                .ignoreConsistencyCheck(true)
                .appTableRecord(AppTableRecord.newBuilder()
                        .fields(new HashMap<String, Object>())
                        .build())
                .build();

        // 发起请求
        CreateAppTableRecordResp resp = client.bitable().v1().appTableRecord().create(req);

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
