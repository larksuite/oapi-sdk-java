package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;
import java.util.HashMap;

// POST /open-apis/task/v2/custom_fields
public class CreateCustomFieldSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateCustomFieldReq req = CreateCustomFieldReq.newBuilder()
			 .userIdType("open_id")
			.inputCustomField(InputCustomField.newBuilder()
				 .resourceType("tasklist")
				 .resourceId("ec5ed63d-a4a9-44de-a935-7ba243471c0a")
				 .name("优先级")
				 .type("number")
				 .numberSetting(NumberSetting.newBuilder().build())
				 .memberSetting(MemberSetting.newBuilder().build())
				 .datetimeSetting(DatetimeSetting.newBuilder().build())
				 .singleSelectSetting(SelectSetting.newBuilder().build())
				 .multiSelectSetting(SelectSetting.newBuilder().build())
				 .textSetting(TextSetting.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  CreateCustomFieldResp resp = client.task().v2().customField().create(req);

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
