package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// POST /open-apis/apaas/v1/applications/:namespace/objects/search
public class SearchApplicationObjectSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchApplicationObjectReq req = SearchApplicationObjectReq.newBuilder()
			 .namespace("package_test__c")
			.searchApplicationObjectReqBody(SearchApplicationObjectReqBody.newBuilder()
				 .q("搜索关键字")
				 .searchObjects(new SearchObjectParam[]{})
				 .pageToken("eyJvYmplY3RzX3BhZ2VfdG9rZW4iOlt7Im9ial9pZCI6MTc2OTI4NzM5M")
				 .pageSize("100")
				 .metadata("Label")
				  .build())
			 .build();

	  // 发起请求
	  SearchApplicationObjectResp resp = client.apaas().v1().applicationObject().search(req);

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
