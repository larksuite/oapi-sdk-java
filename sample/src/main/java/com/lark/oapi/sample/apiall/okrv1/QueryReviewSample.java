package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.*;
import java.util.HashMap;

// GET /open-apis/okr/v1/reviews/query
public class QueryReviewSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  QueryReviewReq req = QueryReviewReq.newBuilder()
			 .userIdType("open_id")
			 .userIds(new String[]{})
			 .periodIds(new String[]{})
			 .build();

	  // 发起请求
	  QueryReviewResp resp = client.okr().v1().review().query(req);

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
