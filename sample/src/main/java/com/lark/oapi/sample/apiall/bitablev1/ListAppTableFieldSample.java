package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.ListAppTableFieldReq;
import com.lark.oapi.service.bitable.v1.model.ListAppTableFieldResp;

// GET /open-apis/bitable/v1/apps/:app_token/tables/:table_id/fields
public class ListAppTableFieldSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListAppTableFieldReq req = ListAppTableFieldReq.newBuilder()
        .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
        .tableId("tblsRc9GRRXKqhvW")
        .viewId("vewOVMEXPF")
        .pageToken("fldwJ4YrtB")
        .pageSize(20)
        .build();

    // 发起请求
    ListAppTableFieldResp resp = client.bitable().appTableField().list(req);

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
