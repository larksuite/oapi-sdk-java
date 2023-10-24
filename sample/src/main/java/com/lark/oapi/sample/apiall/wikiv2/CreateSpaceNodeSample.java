package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.*;
import java.util.HashMap;

// POST /open-apis/wiki/v2/spaces/:space_id/nodes
public class CreateSpaceNodeSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateSpaceNodeReq req = CreateSpaceNodeReq.newBuilder()
			 .spaceId("6704147935988285963")
			.node(Node.newBuilder()
				 .objType("doc")
				 .parentNodeToken("")
				 .nodeType("origin")
				 .originNodeToken("")
				 .title("")
				  .build())
			 .build();

	  // 发起请求
	  CreateSpaceNodeResp resp = client.wiki().spaceNode().create(req);

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
