package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/assigned_users/search
public class SearchAssignedUserSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchAssignedUserReq req = SearchAssignedUserReq.newBuilder()
			 .userIdType("people_corehr_id")
			.searchAssignedUserReqBody(SearchAssignedUserReqBody.newBuilder()
				 .roleId("100")
				 .managementScopeList(new ManagementScope[]{})
				 .searchMethod("1")
				 .pageToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")
				 .pageSize("100")
				  .build())
			 .build();

	  // 发起请求
	  SearchAssignedUserResp resp = client.corehr().v1().assignedUser().search(req);

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
