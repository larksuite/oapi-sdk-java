package com.lark.oapi.sample.apiall.personal_settingsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.personal_settings.v1.model.*;
import java.util.HashMap;

// POST /open-apis/personal_settings/v1/system_statuses
public class CreateSystemStatusSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateSystemStatusReq req = CreateSystemStatusReq.newBuilder()
			.systemStatus(SystemStatus.newBuilder()
				 .title("出差")
				 .i18nTitle(SystemStatusI18nName.newBuilder().build())
				 .iconKey("GeneralBusinessTrip")
				 .color("BLUE")
				 .priority(0)
				 .syncSetting(SystemStatusSyncSetting.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  CreateSystemStatusResp resp = client.personalSettings().systemStatus().create(req);

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
