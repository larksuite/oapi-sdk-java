package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/users/:user_id/resurrect
public class ResurrectUserSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ResurrectUserReq req = ResurrectUserReq.newBuilder()
			 .userId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			.resurrectUserReqBody(ResurrectUserReqBody.newBuilder()
				 .departments(new UserDepartmentInfo[]{})
				 .subscriptionIds(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  ResurrectUserResp resp = client.contact().user().resurrect(req);

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
