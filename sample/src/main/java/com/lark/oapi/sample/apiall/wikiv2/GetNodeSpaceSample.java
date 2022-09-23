package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.*;
import java.util.HashMap;

// GET /open-apis/wiki/v2/spaces/get_node
public class GetNodeSpaceSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetNodeSpaceReq req = GetNodeSpaceReq.newBuilder()
			 .token("wikcnKQ1k3pcuo5uSK4t8VN6kVf")
			 .build();

	  // 发起请求
	  GetNodeSpaceResp resp = client.wiki().space().getNode(req);

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
