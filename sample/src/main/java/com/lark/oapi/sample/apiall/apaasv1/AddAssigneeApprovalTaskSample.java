package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// POST /open-apis/apaas/v1/approval_tasks/:approval_task_id/add_assignee
public class AddAssigneeApprovalTaskSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  AddAssigneeApprovalTaskReq req = AddAssigneeApprovalTaskReq.newBuilder()
			 .approvalTaskId("1785771068261436")
			.addAssigneeApprovalTaskReqBody(AddAssigneeApprovalTaskReqBody.newBuilder()
				 .userId("")
				 .approvers(new String[]{})
				 .addAssigneeType("currentAndAddAssign")
				 .opinion("加签")
				  .build())
			 .build();

	  // 发起请求
	  AddAssigneeApprovalTaskResp resp = client.apaas().v1().approvalTask().addAssignee(req);

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
