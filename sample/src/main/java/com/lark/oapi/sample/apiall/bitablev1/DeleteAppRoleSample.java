package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.DeleteAppRoleReq;
import com.lark.oapi.service.bitable.v1.model.DeleteAppRoleResp;

// DELETE /open-apis/bitable/v1/apps/:app_token/roles/:role_id
public class DeleteAppRoleSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteAppRoleReq req = DeleteAppRoleReq.newBuilder()
        .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
        .roleId("roljRpwIUt")
        .build();

    // 发起请求
    DeleteAppRoleResp resp = client.bitable().appRole().delete(req);

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
