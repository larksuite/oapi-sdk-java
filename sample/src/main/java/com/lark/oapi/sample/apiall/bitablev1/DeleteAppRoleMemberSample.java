package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.DeleteAppRoleMemberReq;
import com.lark.oapi.service.bitable.v1.model.DeleteAppRoleMemberResp;

// DELETE /open-apis/bitable/v1/apps/:app_token/roles/:role_id/members/:member_id
public class DeleteAppRoleMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteAppRoleMemberReq req = DeleteAppRoleMemberReq.newBuilder()
        .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
        .roleId("roljRpwIUt")
        .memberId("ou_7dab8a3d3cdcc9da365777c7ad53uew2")
        .memberIdType("open_id")
        .build();

    // 发起请求
    DeleteAppRoleMemberResp resp = client.bitable().appRoleMember().delete(req);

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
