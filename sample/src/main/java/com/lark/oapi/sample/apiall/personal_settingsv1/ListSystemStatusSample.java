package com.lark.oapi.sample.apiall.personal_settingsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.personal_settings.v1.model.*;
import java.util.HashMap;

// GET /open-apis/personal_settings/v1/system_statuses
public class ListSystemStatusSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListSystemStatusReq req = ListSystemStatusReq.newBuilder()
			 .pageSize(50)
			 .pageToken("GxmvlNRvP0NdQZpa7yIqf_Lv_QuBwTQ8tXkX7w-irAghVD_TvuYd1aoJ1LQph86O-XImC4X9j9FhUPhXQDvtrQ==")
			 .build();

	  // 发起请求
	  ListSystemStatusResp resp = client.personalSettings().systemStatus().list(req);

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
