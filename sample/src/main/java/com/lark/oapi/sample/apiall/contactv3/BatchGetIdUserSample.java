package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/users/batch_get_id
public class BatchGetIdUserSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchGetIdUserReq req = BatchGetIdUserReq.newBuilder()
			 .userIdType("open_id")
			.batchGetIdUserReqBody(BatchGetIdUserReqBody.newBuilder()
				 .emails(new String[]{})
				 .mobiles(new String[]{})
				 .includeResigned(false)
				  .build())
			 .build();

	  // 发起请求
	  BatchGetIdUserResp resp = client.contact().v3().user().batchGetId(req);

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
