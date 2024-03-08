package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;
import java.util.HashMap;

// POST /open-apis/attendance/v1/groups/search
public class SearchGroupSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchGroupReq req = SearchGroupReq.newBuilder()
			.searchGroupReqBody(SearchGroupReqBody.newBuilder()
				 .groupName("考勤组1")
				  .build())
			 .build();

	  // 发起请求
	  SearchGroupResp resp = client.attendance().v1().group().search(req);

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
