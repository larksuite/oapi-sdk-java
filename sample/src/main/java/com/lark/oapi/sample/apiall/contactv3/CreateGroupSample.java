package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/group
public class CreateGroupSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateGroupReq req = CreateGroupReq.newBuilder()
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			.group(Group.newBuilder()
				 .name("IT 外包组")
				 .description("IT服务人员的集合")
				 .type(1)
				 .groupId("g122817")
				  .build())
			 .build();

	  // 发起请求
	  CreateGroupResp resp = client.contact().group().create(req);

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
