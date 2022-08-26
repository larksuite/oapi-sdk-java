package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.ParentDepartmentReq;
import com.lark.oapi.service.contact.v3.model.ParentDepartmentResp;

// GET /open-apis/contact/v3/departments/parent
public class ParentDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ParentDepartmentReq req = ParentDepartmentReq.newBuilder()
        .userIdType("user_id")
        .departmentIdType("open_department_id")
        .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
        .pageToken(
            "AQD9/Rn9eij9Pm39ED40/RD/cIFmu77WxpxPB/2oHfQLZ%2BG8JG6tK7%2BZnHiT7COhD2hMSICh/eBl7cpzU6JEC3J7COKNe4jrQ8ExwBCR")
        .pageSize(20)
        .build();

    // 发起请求
    ParentDepartmentResp resp = client.contact().department().parent(req);

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
