package com.lark.oapi.sample.apiall.workplacev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.workplace.v1.model.*;
import java.util.HashMap;

// POST /open-apis/workplace/v1/workplace_access_data/search
public class SearchWorkplaceAccessDataSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchWorkplaceAccessDataReq req = SearchWorkplaceAccessDataReq.newBuilder()
			 .fromDate("2023-03-01")
			 .toDate("2023-03-22")
			 .pageSize(20)
			 .pageToken("ddowkdkl9w2d")
			 .build();

	  // 发起请求
	  SearchWorkplaceAccessDataResp resp = client.workplace().v1().workplaceAccessData().search(req);

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
