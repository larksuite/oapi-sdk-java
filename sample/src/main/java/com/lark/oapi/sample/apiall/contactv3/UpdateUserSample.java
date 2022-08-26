package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.UpdateUserReq;
import com.lark.oapi.service.contact.v3.model.UpdateUserResp;
import com.lark.oapi.service.contact.v3.model.User;
import com.lark.oapi.service.contact.v3.model.UserCustomAttr;
import com.lark.oapi.service.contact.v3.model.UserOrder;

// PUT /open-apis/contact/v3/users/:user_id
public class UpdateUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateUserReq req = UpdateUserReq.newBuilder()
        .userId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .user(User.newBuilder()
            .name("")
            .enName("")
            .nickname("")
            .email("")
            .mobile("")
            .mobileVisible(false)
            .gender(0)
            .avatarKey("")
            .departmentIds(new String[]{})
            .leaderUserId("")
            .city("")
            .country("")
            .workStation("")
            .joinTime(0)
            .employeeNo("")
            .employeeType(0)
            .orders(new UserOrder[]{})
            .customAttrs(new UserCustomAttr[]{})
            .enterpriseEmail("")
            .jobTitle("")
            .isFrozen(false)
            .build())
        .build();

    // 发起请求
    UpdateUserResp resp = client.contact().user().update(req);

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
