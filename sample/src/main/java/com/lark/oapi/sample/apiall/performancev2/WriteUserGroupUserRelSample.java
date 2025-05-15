package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;
import java.util.HashMap;

// POST /open-apis/performance/v2/user_group_user_rels/write
public class WriteUserGroupUserRelSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  WriteUserGroupUserRelReq req = WriteUserGroupUserRelReq.newBuilder()
			 .clientToken("123456")
			 .userIdType("open_id")
			.writeUserGroupUserRelReqBody(WriteUserGroupUserRelReqBody.newBuilder()
				 .groupId("ABCDEFG")
				 .scopeVisibleSetting(1)
				 .userIds(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  WriteUserGroupUserRelResp resp = client.performance().v2().userGroupUserRel().write(req);

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
