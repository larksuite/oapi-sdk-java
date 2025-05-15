package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// GET /open-apis/vc/v1/resource_reservation_list
public class GetResourceReservationListSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetResourceReservationListReq req = GetResourceReservationListReq.newBuilder()
			 .roomLevelId("omb_57c9cc7d9a81e27e54c8fabfd02759e7")
			 .needTopic(true)
			 .startTime("1655276858")
			 .endTime("1655276858")
			 .roomIds(new String[]{})
			 .isExclude(false)
			 .pageSize(20)
			 .pageToken("")
			 .build();

	  // 发起请求
	  GetResourceReservationListResp resp = client.vc().v1().resourceReservationList().get(req);

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
