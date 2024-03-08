package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;
import java.util.HashMap;

// PATCH /open-apis/search/v2/data_sources/:data_source_id
public class PatchDataSourceSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchDataSourceReq req = PatchDataSourceReq.newBuilder()
			 .dataSourceId("service_ticket")
			.patchDataSourceReqBody(PatchDataSourceReqBody.newBuilder()
				 .name("客服工单")
				 .state(0)
				 .description("搜索客服工单")
				 .iconUrl("https://www.xxx.com/open.jpg")
				 .i18nName(I18nMeta.newBuilder().build())
				 .i18nDescription(I18nMeta.newBuilder().build())
				 .connectorParam(ConnectorParam.newBuilder().build())
				 .enableAnswer(false)
				  .build())
			 .build();

	  // 发起请求
	  PatchDataSourceResp resp = client.search().v2().dataSource().patch(req);

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
