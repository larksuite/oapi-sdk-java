package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records/batch_delete
public class BatchDeleteAppTableRecordSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchDeleteAppTableRecordReq req = BatchDeleteAppTableRecordReq.newBuilder()
			 .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
			 .tableId("tblsRc9GRRXKqhvW")
			.batchDeleteAppTableRecordReqBody(BatchDeleteAppTableRecordReqBody.newBuilder()
				 .records(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchDeleteAppTableRecordResp resp = client.bitable().appTableRecord().batchDelete(req);

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
