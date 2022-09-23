package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/users
public class CreateUserSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateUserReq req = CreateUserReq.newBuilder()
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			 .clientToken("xxxx-xxxxx-xxx")
			.user(User.newBuilder()
				 .userId("")
				 .name("")
				 .enName("")
				 .nickname("")
				 .email("")
				 .mobile("")
				 .mobileVisible(false)
				 .gender(0)
				 .avatarKey("")
				 .departmentIds(new String[]{})
				 .leaderUserId("")
				 .city("")
				 .country("")
				 .workStation("")
				 .joinTime(0)
				 .employeeNo("")
				 .employeeType(0)
				 .orders(new UserOrder[]{})
				 .customAttrs(new UserCustomAttr[]{})
				 .enterpriseEmail("")
				 .jobTitle("")
				 .geo("")
				  .build())
			 .build();

	  // 发起请求
	  CreateUserResp resp = client.contact().user().create(req);

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
