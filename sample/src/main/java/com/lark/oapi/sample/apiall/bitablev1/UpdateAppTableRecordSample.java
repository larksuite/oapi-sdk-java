package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.UpdateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.UpdateAppTableRecordResp;

// HTTP PATH: /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records/:record_id"
public class UpdateAppTableRecordSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateAppTableRecordReq req = UpdateAppTableRecordReq.newBuilder()
        .appToken("")
        .tableId("")
        .recordId("")
        .userIdType("user_id")
        .build();

    // 发起请求
    UpdateAppTableRecordResp resp = client.bitable().appTableRecord().update(req);

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
