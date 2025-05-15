package com.lark.oapi.sample.apiall.payrollv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.payroll.v1.model.*;
import java.util.HashMap;

// GET /open-apis/payroll/v1/acct_items
public class ListAcctItemSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListAcctItemReq req = ListAcctItemReq.newBuilder()
			 .pageSize(50)
			 .pageToken("")
			 .build();

	  // 发起请求
	  ListAcctItemResp resp = client.payroll().v1().acctItem().list(req);

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
