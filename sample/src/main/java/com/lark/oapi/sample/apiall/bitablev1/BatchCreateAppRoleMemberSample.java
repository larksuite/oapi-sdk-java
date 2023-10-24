package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/roles/:role_id/members/batch_create
public class BatchCreateAppRoleMemberSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchCreateAppRoleMemberReq req = BatchCreateAppRoleMemberReq.newBuilder()
			 .appToken("bascnnKKvcoUblgmmhZkYqabcef")
			 .roleId("rolNGhPqks")
			.batchCreateAppRoleMemberReqBody(BatchCreateAppRoleMemberReqBody.newBuilder()
				 .memberList(new AppRoleMemberId[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchCreateAppRoleMemberResp resp = client.bitable().appRoleMember().batchCreate(req);

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
