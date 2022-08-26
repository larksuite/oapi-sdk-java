package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.GetDepartmentReq;
import com.lark.oapi.service.contact.v3.model.GetDepartmentResp;

// GET /open-apis/contact/v3/departments/:department_id
public class GetDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetDepartmentReq req = GetDepartmentReq.newBuilder()
        .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .build();

    // 发起请求
    GetDepartmentResp resp = client.contact().department().get(req);

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
