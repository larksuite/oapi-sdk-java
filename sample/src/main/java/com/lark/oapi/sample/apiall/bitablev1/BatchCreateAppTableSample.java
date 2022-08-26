package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableReq;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableReqBody;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableResp;
import com.lark.oapi.service.bitable.v1.model.ReqTable;

// POST /open-apis/bitable/v1/apps/:app_token/tables/batch_create
public class BatchCreateAppTableSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    BatchCreateAppTableReq req = BatchCreateAppTableReq.newBuilder()
        .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
        .userIdType("user_id")
        .batchCreateAppTableReqBody(BatchCreateAppTableReqBody.newBuilder()
            .tables(new ReqTable[]{})
            .build())
        .build();

    // 发起请求
    BatchCreateAppTableResp resp = client.bitable().appTable().batchCreate(req);

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
