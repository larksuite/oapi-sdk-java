package com.lark.oapi.sample.apiall.lingov1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.lingo.v1.model.*;
import java.util.HashMap;

// POST /open-apis/lingo/v1/entities/match
public class MatchEntitySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  MatchEntityReq req = MatchEntityReq.newBuilder()
			 .repoId("7202510112396640276")
			.matchEntityReqBody(MatchEntityReqBody.newBuilder()
				 .word("企业百科")
				  .build())
			 .build();

	  // 发起请求
	  MatchEntityResp resp = client.lingo().entity().match(req);

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
