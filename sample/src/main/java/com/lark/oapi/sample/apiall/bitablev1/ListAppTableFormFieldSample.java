package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.ListAppTableFormFieldReq;
import com.lark.oapi.service.bitable.v1.model.ListAppTableFormFieldResp;

// GET /open-apis/bitable/v1/apps/:app_token/tables/:table_id/forms/:form_id/fields
public class ListAppTableFormFieldSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListAppTableFormFieldReq req = ListAppTableFormFieldReq.newBuilder()
        .appToken("bascnCMII2ORej2RItqpZZUNMIe")
        .tableId("tblxI2tWaxP5dG7p")
        .formId("vewTpR1urY")
        .pageSize(10)
        .pageToken("vewTpR1urY")
        .build();

    // 发起请求
    ListAppTableFormFieldResp resp = client.bitable().appTableFormField().list(req);

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
