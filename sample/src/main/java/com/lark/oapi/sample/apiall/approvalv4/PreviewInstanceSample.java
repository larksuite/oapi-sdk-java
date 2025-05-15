package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;
import java.util.HashMap;

// POST /open-apis/approval/v4/instances/preview
public class PreviewInstanceSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PreviewInstanceReq req = PreviewInstanceReq.newBuilder()
			 .userIdType("open_id")
			.previewInstanceReqBody(PreviewInstanceReqBody.newBuilder()
				 .userId("发起审批用户id，按照user_id_type类型填写")
				 .approvalCode("C2CAAA90-70D9-3214-906B-B6FFF947F00D")
				 .departmentId("6982332863116876308")
				 .form("")
				 .instanceCode("12345CA6-97AC-32BB-8231-47C33FFFCCFD")
				 .locale("zh-CN: 中文 en-US: 英文")
				 .taskId("6982332863116876308")
				  .build())
			 .build();

	  // 发起请求
	  PreviewInstanceResp resp = client.approval().v4().instance().preview(req);

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
