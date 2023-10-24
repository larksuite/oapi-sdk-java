package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// GET /open-apis/vc/v1/room_levels
public class ListRoomLevelSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListRoomLevelReq req = ListRoomLevelReq.newBuilder()
			 .roomLevelId("omb_4ad1a2c7a2fbc5fc9570f38456931293")
			 .pageSize(10)
			 .pageToken("  ")
			 .build();

	  // 发起请求
	  ListRoomLevelResp resp = client.vc().roomLevel().list(req);

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
