package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// GET /open-apis/apaas/v1/applications/:namespace/roles/:role_api_name/member
public class GetApplicationRoleMemberSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetApplicationRoleMemberReq req = GetApplicationRoleMemberReq.newBuilder()
			 .namespace("package_test__c")
			 .roleApiName("adminRole")
			 .needDisplayName(false)
			 .useApiId(false)
			 .build();

	  // 发起请求
	  GetApplicationRoleMemberResp resp = client.apaas().v1().applicationRoleMember().get(req);

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
