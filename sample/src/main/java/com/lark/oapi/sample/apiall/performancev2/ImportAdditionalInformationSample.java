package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;
import java.util.HashMap;

// POST /open-apis/performance/v2/additional_informations/import
public class ImportAdditionalInformationSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ImportAdditionalInformationReq req = ImportAdditionalInformationReq.newBuilder()
			 .clientToken("12454646")
			 .userIdType("open_id")
			.importAdditionalInformationReqBody(ImportAdditionalInformationReqBody.newBuilder()
				 .semesterId("7348736302176534547")
				 .additionalInformations(new AdditionalInformation[]{})
				 .importRecordName("API导入")
				  .build())
			 .build();

	  // 发起请求
	  ImportAdditionalInformationResp resp = client.performance().v2().additionalInformation().import_(req);

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
