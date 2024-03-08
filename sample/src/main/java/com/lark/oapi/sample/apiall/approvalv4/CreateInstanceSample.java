package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;
import java.util.HashMap;

// POST /open-apis/approval/v4/instances
public class CreateInstanceSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateInstanceReq req = CreateInstanceReq.newBuilder()
			.instanceCreate(InstanceCreate.newBuilder()
				 .approvalCode("7C468A54-8745-2245-9675-08B7C63E7A85")
				 .userId("f7cb567e")
				 .openId("ou_123456")
				 .departmentId("123456")
				 .form("")
				 .nodeApproverUserIdList(new NodeApprover[]{})
				 .nodeApproverOpenIdList(new NodeApprover[]{})
				 .nodeCcUserIdList(new NodeCc[]{})
				 .nodeCcOpenIdList(new NodeCc[]{})
				 .uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
				 .allowResubmit(true)
				 .allowSubmitAgain(true)
				 .cancelBotNotification("0")
				 .forbidRevoke(false)
				 .i18nResources(new I18nResource[]{})
				 .title("@i18n@1")
				 .titleDisplayMethod(0)
				  .build())
			 .build();

	  // 发起请求
	  CreateInstanceResp resp = client.approval().v4().instance().create(req);

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
