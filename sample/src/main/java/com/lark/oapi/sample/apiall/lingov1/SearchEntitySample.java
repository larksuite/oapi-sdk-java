package com.lark.oapi.sample.apiall.lingov1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.lingo.v1.model.*;
import java.util.HashMap;

// POST /open-apis/lingo/v1/entities/search
public class SearchEntitySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchEntityReq req = SearchEntityReq.newBuilder()
			 .pageSize(20)
			 .pageToken("b152fa6e6f62a291019a04c3a93f365f8ac641910506ff15ff4cad6534e087cb4ed8fa2c")
			 .repoId("7202510112396640276")
			 .userIdType("user_id")
			.searchEntityReqBody(SearchEntityReqBody.newBuilder()
				 .query("飞书词典")
				 .classificationFilter(ClassificationFilter.newBuilder().build())
				 .sources(new Integer[]{})
				 .creators(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  SearchEntityResp resp = client.lingo().v1().entity().search(req);

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
