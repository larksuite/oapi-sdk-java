package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// POST /open-apis/apaas/v1/applications/:namespace/flows/:flow_id/execute
public class ExecuteApplicationFlowSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ExecuteApplicationFlowReq req = ExecuteApplicationFlowReq.newBuilder()
			 .namespace("123")
			 .flowId("deleteObject_99c0b74799f")
			.executeApplicationFlowReqBody(ExecuteApplicationFlowReqBody.newBuilder()
				 .isAsync(true)
				 .idempotentKey("123")
				 .loopMasks(new String[]{})
				 .params("123")
				 .operator("123")
				  .build())
			 .build();

	  // 发起请求
	  ExecuteApplicationFlowResp resp = client.apaas().v1().applicationFlow().execute(req);

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
