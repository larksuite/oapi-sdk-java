package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// GET /open-apis/apaas/v1/applications/:namespace/audit_log/data_change_log_detail
public class DataChangeLogDetailApplicationAuditLogSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  DataChangeLogDetailApplicationAuditLogReq req = DataChangeLogDetailApplicationAuditLogReq.newBuilder()
			 .namespace("package_aaa")
			 .logId("7405456257290600492")
			 .build();

	  // 发起请求
	  DataChangeLogDetailApplicationAuditLogResp resp = client.apaas().v1().applicationAuditLog().dataChangeLogDetail(req);

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
