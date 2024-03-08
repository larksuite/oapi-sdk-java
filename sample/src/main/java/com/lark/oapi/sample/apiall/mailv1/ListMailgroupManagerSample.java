package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;
import java.util.HashMap;

// GET /open-apis/mail/v1/mailgroups/:mailgroup_id/managers
public class ListMailgroupManagerSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListMailgroupManagerReq req = ListMailgroupManagerReq.newBuilder()
			 .mailgroupId("xxxxxx 或 test_mail_group@xx.xx")
			 .pageSize(20)
			 .pageToken("xxxxxx")
			 .userIdType("open_id")
			 .build();

	  // 发起请求
	  ListMailgroupManagerResp resp = client.mail().v1().mailgroupManager().list(req);

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
