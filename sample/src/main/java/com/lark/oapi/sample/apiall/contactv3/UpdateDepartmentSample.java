package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.Department;
import com.lark.oapi.service.contact.v3.model.DepartmentI18nName;
import com.lark.oapi.service.contact.v3.model.DepartmentLeader;
import com.lark.oapi.service.contact.v3.model.UpdateDepartmentReq;
import com.lark.oapi.service.contact.v3.model.UpdateDepartmentResp;

// PUT /open-apis/contact/v3/departments/:department_id
public class UpdateDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateDepartmentReq req = UpdateDepartmentReq.newBuilder()
        .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .department(Department.newBuilder()
            .name("")
            .i18nName(DepartmentI18nName.newBuilder().build())
            .parentDepartmentId("")
            .leaderUserId("")
            .order("")
            .unitIds(new String[]{})
            .createGroupChat(false)
            .leaders(new DepartmentLeader[]{})
            .build())
        .build();

    // 发起请求
    UpdateDepartmentResp resp = client.contact().department().update(req);

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