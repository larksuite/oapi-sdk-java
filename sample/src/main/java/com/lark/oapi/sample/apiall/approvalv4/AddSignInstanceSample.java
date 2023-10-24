package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;
import java.util.HashMap;

// POST /open-apis/approval/v4/instances/add_sign
public class AddSignInstanceSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  AddSignInstanceReq req = AddSignInstanceReq.newBuilder()
			.addSignInstanceReqBody(AddSignInstanceReqBody.newBuilder()
				 .userId("b16g66e3")
				 .approvalCode("3B68E280-CF10-4198-B4CD-2E3BB97981D8")
				 .instanceCode("289330DE-FBF1-4A47-91F9-9EFCCF11BCAE")
				 .taskId("6955096766400167956")
				 .comment("addSignComment")
				 .addSignUserIds(new String[]{})
				 .addSignType(3)
				 .approvalMethod(1)
				  .build())
			 .build();

	  // 发起请求
	  AddSignInstanceResp resp = client.approval().instance().addSign(req);

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
