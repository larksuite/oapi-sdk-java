package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// GET /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records
public class ListAppTableRecordSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListAppTableRecordReq req = ListAppTableRecordReq.newBuilder()
			 .appToken("bascnCMII2ORej2RItqpZZUNMIe")
			 .tableId("tblxI2tWaxP5dG7p")
			 .viewId("vewqhz51lk")
			 .filter("AND(CurrentValue.[身高]>180, CurrentValue.[体重]>150)")
			 .sort("")
			 .fieldNames("")
			 .textFieldAsArray(true)
			 .userIdType("user_id")
			 .displayFormulaRef(true)
			 .automaticFields(true)
			 .pageToken("recn0hoyXL")
			 .pageSize(20)
			 .build();

	  // 发起请求
	  ListAppTableRecordResp resp = client.bitable().v1().appTableRecord().list(req);

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
