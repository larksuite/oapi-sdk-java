package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.ListAdminDeptStatReq;
import com.lark.oapi.service.admin.v1.model.ListAdminDeptStatResp;

// HTTP PATH: /open-apis/admin/v1/admin_dept_stats"
public class ListAdminDeptStatSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListAdminDeptStatReq req = ListAdminDeptStatReq.newBuilder()
        .departmentIdType("department_id")
        .startDate("")
        .endDate("")
        .departmentId("")
        .containsChildDept(false)
        .pageSize(0)
        .pageToken("")
        .build();

    // 发起请求
    ListAdminDeptStatResp resp = client.admin().adminDeptStat().list(req);

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
