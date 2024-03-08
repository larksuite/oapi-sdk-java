package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;
import java.util.HashMap;

// GET /open-apis/mail/v1/mailgroups
public class ListMailgroupSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListMailgroupReq req = ListMailgroupReq.newBuilder()
			 .managerUserId("ou_xxxxxx")
			 .userIdType("user_id")
			 .pageToken("xxx")
			 .pageSize(20)
			 .build();

	  // 发起请求
	  ListMailgroupResp resp = client.mail().v1().mailgroup().list(req);

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
