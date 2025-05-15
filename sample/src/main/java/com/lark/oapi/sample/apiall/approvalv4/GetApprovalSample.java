package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;
import java.util.HashMap;

// GET /open-apis/approval/v4/approvals/:approval_code
public class GetApprovalSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetApprovalReq req = GetApprovalReq.newBuilder()
			 .approvalCode("7C468A54-8745-2245-9675-08B7C63E7A85")
			 .locale("zh-CN")
			 .withAdminId(false)
			 .userIdType("user_id")
			 .build();

	  // 发起请求
	  GetApprovalResp resp = client.approval().v4().approval().get(req);

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
