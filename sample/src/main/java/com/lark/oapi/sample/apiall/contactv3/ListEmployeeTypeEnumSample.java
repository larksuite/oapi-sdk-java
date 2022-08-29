package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.ListEmployeeTypeEnumReq;
import com.lark.oapi.service.contact.v3.model.ListEmployeeTypeEnumResp;

// GET /open-apis/contact/v3/employee_type_enums
public class ListEmployeeTypeEnumSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListEmployeeTypeEnumReq req = ListEmployeeTypeEnumReq.newBuilder()
        .pageToken("3")
        .pageSize(20)
        .build();

    // 发起请求
    ListEmployeeTypeEnumResp resp = client.contact().employeeTypeEnum().list(req);

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