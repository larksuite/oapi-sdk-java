package com.lark.oapi.sample.apiall.cardkitv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.*;
import java.util.HashMap;

// POST /open-apis/cardkit/v1/cards/id_convert
public class IdConvertCardSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  IdConvertCardReq req = IdConvertCardReq.newBuilder()
			.idConvertCardReqBody(IdConvertCardReqBody.newBuilder()
				 .messageId("om_fbdf6ed2e17f1d98e78fb26c1370186e")
				  .build())
			 .build();

	  // 发起请求
	  IdConvertCardResp resp = client.cardkit().v1().card().idConvert(req);

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
