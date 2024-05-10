package com.lark.oapi.sample.apiall.personal_settingsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.personal_settings.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/personal_settings/v1/system_statuses/:system_status_id
public class PatchSystemStatusSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchSystemStatusReq req = PatchSystemStatusReq.newBuilder()
			 .systemStatusId("7101214603622940633")
			.patchSystemStatusReqBody(PatchSystemStatusReqBody.newBuilder()
				 .systemStatus(SystemStatus.newBuilder().build())
				 .updateFields(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  PatchSystemStatusResp resp = client.personalSettings().v1().systemStatus().patch(req);

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
