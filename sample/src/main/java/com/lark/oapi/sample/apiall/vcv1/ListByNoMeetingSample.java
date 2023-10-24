package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;
import java.util.HashMap;

// GET /open-apis/vc/v1/meetings/list_by_no
public class ListByNoMeetingSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListByNoMeetingReq req = ListByNoMeetingReq.newBuilder()
			 .meetingNo("123456789")
			 .startTime("1608888867")
			 .endTime("1608888867")
			 .pageToken("5")
			 .pageSize(20)
			 .build();

	  // 发起请求
	  ListByNoMeetingResp resp = client.vc().meeting().listByNo(req);

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
