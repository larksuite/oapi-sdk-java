package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.*;
import java.util.HashMap;

// POST /open-apis/docx/v1/documents/:document_id/blocks/:block_id/children
public class CreateDocumentBlockChildrenSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateDocumentBlockChildrenReq req = CreateDocumentBlockChildrenReq.newBuilder()
			 .documentId("doxcnePuYufKa49ISjhD8Ih0ikh")
			 .blockId("doxcnO6UW6wAw2qIcYf4hZpFIth")
			 .documentRevisionId(-1)
			 .clientToken("fe599b60-450f-46ff-b2ef-9f6675625b97")
			 .userIdType("user_id")
			.createDocumentBlockChildrenReqBody(CreateDocumentBlockChildrenReqBody.newBuilder()
				 .children(new Block[]{})
				 .index(-1)
				  .build())
			 .build();

	  // 发起请求
	  CreateDocumentBlockChildrenResp resp = client.docx().v1().documentBlockChildren().create(req);

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
