package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// GET /open-apis/hire/v1/websites/:website_id/delivery_tasks/:delivery_task_id
public class GetWebsiteDeliveryTaskSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetWebsiteDeliveryTaskReq req = GetWebsiteDeliveryTaskReq.newBuilder()
			 .websiteId("7047318856652261676")
			 .deliveryTaskId("f1c2a0f138ec492d99d7ab73594158ad")
			 .build();

	  // 发起请求
	  GetWebsiteDeliveryTaskResp resp = client.hire().v1().websiteDeliveryTask().get(req);

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
