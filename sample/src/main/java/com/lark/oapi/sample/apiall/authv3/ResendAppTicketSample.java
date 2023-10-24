package com.lark.oapi.sample.apiall.authv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.auth.v3.model.*;
import java.util.HashMap;

// POST /open-apis/auth/v3/app_ticket/resend
public class ResendAppTicketSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ResendAppTicketReq req = ResendAppTicketReq.newBuilder()
			.resendAppTicketReqBody(ResendAppTicketReqBody.newBuilder()
				 .appId("cli_slkdjalasdkjasd")
				 .appSecret("dskLLdkasdjlasdKK")
				  .build())
			 .build();

	  // 发起请求
	  ResendAppTicketResp resp = client.auth().appTicket().resend(req);

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
