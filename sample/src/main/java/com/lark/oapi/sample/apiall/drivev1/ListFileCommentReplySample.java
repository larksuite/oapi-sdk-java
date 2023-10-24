package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;
import java.util.HashMap;

// GET /open-apis/drive/v1/files/:file_token/comments/:comment_id/replies
public class ListFileCommentReplySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListFileCommentReplyReq req = ListFileCommentReplyReq.newBuilder()
			 .fileToken("doxbcdl03Vsxhm7Qmnj110abcef")
			 .commentId("1654857036541812356")
			 .pageSize(10)
			 .pageToken("1654857036541812356")
			 .fileType("docx")
			 .userIdType("user_id")
			 .build();

	  // 发起请求
	  ListFileCommentReplyResp resp = client.drive().fileCommentReply().list(req);

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
