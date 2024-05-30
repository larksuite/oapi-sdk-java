package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.*;
import java.util.HashMap;

// POST /open-apis/wiki/v2/spaces/:space_id/nodes/move_docs_to_wiki
public class MoveDocsToWikiSpaceNodeSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  MoveDocsToWikiSpaceNodeReq req = MoveDocsToWikiSpaceNodeReq.newBuilder()
			 .spaceId("1565676577122621")
			.moveDocsToWikiSpaceNodeReqBody(MoveDocsToWikiSpaceNodeReqBody.newBuilder()
				 .parentWikiToken("wikcnKQ1k3p******8Vabce")
				 .objType("doc")
				 .objToken("doccnzAaOD******Wabcdef")
				 .apply(true)
				  .build())
			 .build();

	  // 发起请求
	  MoveDocsToWikiSpaceNodeResp resp = client.wiki().v2().spaceNode().moveDocsToWiki(req);

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
