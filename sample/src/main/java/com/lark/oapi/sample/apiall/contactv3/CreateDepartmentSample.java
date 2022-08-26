package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.CreateDepartmentReq;
import com.lark.oapi.service.contact.v3.model.CreateDepartmentResp;
import com.lark.oapi.service.contact.v3.model.Department;
import com.lark.oapi.service.contact.v3.model.DepartmentI18nName;
import com.lark.oapi.service.contact.v3.model.DepartmentLeader;

// POST /open-apis/contact/v3/departments
public class CreateDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateDepartmentReq req = CreateDepartmentReq.newBuilder()
        .userIdType("user_id")
        .departmentIdType("open_department_id")
        .clientToken("473469C7-AA6F-4DC5-B3DB-A3DC0DE3C83E")
        .department(Department.newBuilder()
            .name("")
            .i18nName(DepartmentI18nName.newBuilder().build())
            .parentDepartmentId("")
            .departmentId("")
            .leaderUserId("")
            .order("")
            .unitIds(new String[]{})
            .createGroupChat(false)
            .leaders(new DepartmentLeader[]{})
            .build())
        .build();

    // 发起请求
    CreateDepartmentResp resp = client.contact().department().create(req);

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
