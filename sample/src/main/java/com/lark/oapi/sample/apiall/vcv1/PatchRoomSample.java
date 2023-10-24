package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/vc/v1/rooms/:room_id
public class PatchRoomSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchRoomReq req = PatchRoomReq.newBuilder()
			 .roomId("omm_4de32cf10a4358788ff4e09e37ebbf9b")
			 .userIdType("open_id")
			.room(Room.newBuilder()
				 .name("测试会议室")
				 .capacity(10)
				 .description("测试会议室描述")
				 .customRoomId("1234")
				 .roomLevelId("omb_8d020b12fe49e82847c2af3c193d5754")
				 .roomStatus(RoomStatus.newBuilder().build())
				 .device(new Device[]{})
				  .build())
			 .build();

	  // 发起请求
	  PatchRoomResp resp = client.vc().room().patch(req);

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
