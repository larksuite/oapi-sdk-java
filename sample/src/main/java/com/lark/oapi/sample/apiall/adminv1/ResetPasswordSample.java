package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.*;
import java.util.HashMap;

// POST /open-apis/admin/v1/password/reset
public class ResetPasswordSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ResetPasswordReq req = ResetPasswordReq.newBuilder()
			 .userIdType("user_id")
			.resetPasswordReqBody(ResetPasswordReqBody.newBuilder()
				 .password(Password.newBuilder().build())
				 .userId("abc123")
				  .build())
			 .build();

	  // 发起请求
	  ResetPasswordResp resp = client.admin().v1().password().reset(req);

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
