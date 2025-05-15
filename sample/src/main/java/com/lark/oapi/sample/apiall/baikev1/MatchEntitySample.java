package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.*;
import java.util.HashMap;

// POST /open-apis/baike/v1/entities/match
public class MatchEntitySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  MatchEntityReq req = MatchEntityReq.newBuilder()
			.matchEntityReqBody(MatchEntityReqBody.newBuilder()
				 .word("企业百科")
				  .build())
			 .build();

	  // 发起请求
	  MatchEntityResp resp = client.baike().v1().entity().match(req);

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
