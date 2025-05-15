package com.lark.oapi.sample.apiall.payrollv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.payroll.v1.model.*;
import java.util.HashMap;

// GET /open-apis/payroll/v1/paygroups
public class ListPaygroupSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListPaygroupReq req = ListPaygroupReq.newBuilder()
			 .pageSize(50)
			 .pageToken("6862995757234914824")
			 .build();

	  // 发起请求
	  ListPaygroupResp resp = client.payroll().v1().paygroup().list(req);

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
