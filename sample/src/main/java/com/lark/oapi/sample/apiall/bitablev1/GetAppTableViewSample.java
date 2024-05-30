package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// GET /open-apis/bitable/v1/apps/:app_token/tables/:table_id/views/:view_id
public class GetAppTableViewSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  GetAppTableViewReq req = GetAppTableViewReq.newBuilder()
			 .appToken("bascnCMII2ORej2RItqpZZUNMIe")
			 .tableId("tblsRc9GRRXKqhvW")
			 .viewId("vewTpR1urY")
			 .build();

	  // 发起请求
	  GetAppTableViewResp resp = client.bitable().v1().appTableView().get(req);

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
