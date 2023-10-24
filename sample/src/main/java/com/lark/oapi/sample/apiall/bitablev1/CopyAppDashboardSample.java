package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/dashboards/:block_id/copy
public class CopyAppDashboardSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CopyAppDashboardReq req = CopyAppDashboardReq.newBuilder()
			 .appToken("basbcldP5xZeskcHDFZQfeToydb")
			 .blockId("blkEsvEEaNllY2UV")
			.copyAppDashboardReqBody(CopyAppDashboardReqBody.newBuilder()
				 .name("Dashboard")
				  .build())
			 .build();

	  // 发起请求
	  CopyAppDashboardResp resp = client.bitable().appDashboard().copy(req);

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
