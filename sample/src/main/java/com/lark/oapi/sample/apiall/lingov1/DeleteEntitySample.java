package com.lark.oapi.sample.apiall.lingov1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.lingo.v1.model.*;
import java.util.HashMap;

// DELETE /open-apis/lingo/v1/entities/:entity_id
public class DeleteEntitySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  DeleteEntityReq req = DeleteEntityReq.newBuilder()
			 .entityId("enterprise_43742132363")
			 .provider("星云")
			 .outerId("123aaa")
			 .build();

	  // 发起请求
	  DeleteEntityResp resp = client.lingo().v1().entity().delete(req);

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
