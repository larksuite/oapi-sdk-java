package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.AppTableRecord;
import com.lark.oapi.service.bitable.v1.model.BatchUpdateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.BatchUpdateAppTableRecordReqBody;
import com.lark.oapi.service.bitable.v1.model.BatchUpdateAppTableRecordResp;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records/batch_update
public class BatchUpdateAppTableRecordSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    BatchUpdateAppTableRecordReq req = BatchUpdateAppTableRecordReq.newBuilder()
        .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
        .tableId("tblsRc9GRRXKqhvW")
        .userIdType("user_id")
        .batchUpdateAppTableRecordReqBody(BatchUpdateAppTableRecordReqBody.newBuilder()
            .records(new AppTableRecord[]{})
            .build())
        .build();

    // 发起请求
    BatchUpdateAppTableRecordResp resp = client.bitable().appTableRecord().batchUpdate(req);

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
