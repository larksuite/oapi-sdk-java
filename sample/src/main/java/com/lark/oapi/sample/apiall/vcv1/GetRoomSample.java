package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// GET /open-apis/vc/v1/rooms/:room_id
public class GetRoomSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetRoomReq req = GetRoomReq.newBuilder()
			 .roomId("omm_4de32cf10a4358788ff4e09e37ebbf9c")
			 .userIdType("user_id")
			 .build();

	  // 发起请求
	  GetRoomResp resp = client.vc().v1().room().get(req);

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
