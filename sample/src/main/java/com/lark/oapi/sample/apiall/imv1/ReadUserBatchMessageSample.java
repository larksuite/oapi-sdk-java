package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.*;
import java.util.HashMap;

// GET /open-apis/im/v1/batch_messages/:batch_message_id/read_user
public class ReadUserBatchMessageSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ReadUserBatchMessageReq req = ReadUserBatchMessageReq.newBuilder()
			 .batchMessageId("bm_dc13264520392913993dd051dba21dcf")
			 .build();

	  // 发起请求
	  ReadUserBatchMessageResp resp = client.im().batchMessage().readUser(req);

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
