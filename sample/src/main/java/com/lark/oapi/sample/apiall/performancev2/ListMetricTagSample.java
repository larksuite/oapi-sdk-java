package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;
import java.util.HashMap;

// GET /open-apis/performance/v2/metric_tags
public class ListMetricTagSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListMetricTagReq req = ListMetricTagReq.newBuilder()
			 .pageSize(0)
			 .pageToken("")
			 .tagIds(new String[]{})
			 .build();

	  // 发起请求
	  ListMetricTagResp resp = client.performance().v2().metricTag().list(req);

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
