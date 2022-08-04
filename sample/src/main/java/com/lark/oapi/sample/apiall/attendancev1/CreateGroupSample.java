package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.CreateGroupReq;
import com.lark.oapi.service.attendance.v1.model.CreateGroupReqBody;
import com.lark.oapi.service.attendance.v1.model.CreateGroupResp;
import com.lark.oapi.service.attendance.v1.model.Group;

// HTTP PATH: /open-apis/attendance/v1/groups"
public class CreateGroupSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateGroupReq req = CreateGroupReq.newBuilder()
        .employeeType("employee_id")
        .deptType("open_id")
        .createGroupReqBody(CreateGroupReqBody.newBuilder()
            .group(Group.newBuilder().build())
            .operatorId("dd31248a")
            .build())
        .build();

    // 发起请求
    CreateGroupResp resp = client.attendance().group().create(req);

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
