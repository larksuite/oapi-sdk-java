package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// DELETE /open-apis/bitable/v1/apps/:app_token/tables/:table_id/fields/:field_id
public class DeleteAppTableFieldSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  DeleteAppTableFieldReq req = DeleteAppTableFieldReq.newBuilder()
			 .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
			 .tableId("tblsRc9GRRXKqhvW")
			 .fieldId("fldPTb0U2y")
			 .build();

	  // 发起请求
	  DeleteAppTableFieldResp resp = client.bitable().appTableField().delete(req);

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
