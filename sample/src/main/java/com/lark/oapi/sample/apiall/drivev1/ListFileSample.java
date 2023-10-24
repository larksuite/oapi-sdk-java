package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;
import java.util.HashMap;

// GET /open-apis/drive/v1/files
public class ListFileSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListFileReq req = ListFileReq.newBuilder()
			 .pageSize(10)
			 .pageToken("MTY1NTA3MTA1OXw3MTA4NDc2MDc1NzkyOTI0Nabcef")
			 .folderToken("fldbcO1UuPz8VwnpPx5a9abcef")
			 .orderBy("EditedTime")
			 .direction("DESC")
			 .userIdType("user_id")
			 .build();

	  // 发起请求
	  ListFileResp resp = client.drive().file().list(req);

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
