package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.SearchDepartmentReq;
import com.lark.oapi.service.contact.v3.model.SearchDepartmentReqBody;
import com.lark.oapi.service.contact.v3.model.SearchDepartmentResp;

// HTTP PATH: /open-apis/contact/v3/departments/search"
public class SearchDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SearchDepartmentReq req = SearchDepartmentReq.newBuilder()
        .userIdType("user_id")
        .departmentIdType("department_id")
        .pageToken("")
        .pageSize(20)
        .searchDepartmentReqBody(SearchDepartmentReqBody.newBuilder()
            .query("")
            .build())
        .build();

    // 发起请求
    SearchDepartmentResp resp = client.contact().department().search(req);

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
