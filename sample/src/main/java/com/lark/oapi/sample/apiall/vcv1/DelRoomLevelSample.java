package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// POST /open-apis/vc/v1/room_levels/del
public class DelRoomLevelSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  DelRoomLevelReq req = DelRoomLevelReq.newBuilder()
			.delRoomLevelReqBody(DelRoomLevelReqBody.newBuilder()
				 .roomLevelId("omb_4ad1a2c7a2fbc5fc9570f38456931293")
				 .deleteChild(false)
				  .build())
			 .build();

	  // 发起请求
	  DelRoomLevelResp resp = client.vc().v1().roomLevel().del(req);

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
