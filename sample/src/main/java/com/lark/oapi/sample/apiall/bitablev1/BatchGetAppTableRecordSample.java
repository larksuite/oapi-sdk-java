package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records/batch_get
public class BatchGetAppTableRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetAppTableRecordReq req = BatchGetAppTableRecordReq.newBuilder()
                .appToken("NQRxbRkBMa6OnZsjtERcxhNWnNh")
                .tableId("tbl0xe5g8PP3U3cS")
                .batchGetAppTableRecordReqBody(BatchGetAppTableRecordReqBody.newBuilder()
                        .recordIds(new String[]{})
                        .userIdType("open_id")
                        .withSharedUrl(false)
                        .automaticFields(false)
                        .build())
                .build();

        // 发起请求
        BatchGetAppTableRecordResp resp = client.bitable().v1().appTableRecord().batchGet(req);

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
