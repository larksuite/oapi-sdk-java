package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import com.lark.oapi.service.corehr.v1.model.Enum;

import java.util.HashMap;

// POST /open-apis/corehr/v1/locations
public class CreateLocationSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateLocationReq req = CreateLocationReq.newBuilder()
			 .clientToken("12454646")
			.location(Location.newBuilder()
				 .hiberarchyCommon(HiberarchyCommon.newBuilder().build())
				 .locationUsageList(new Enum[]{})
				 .address(new Address[]{})
				 .workingHoursTypeId("4690238309151997779")
				 .effectiveTime("2020-05-01 00:00:00")
				 .locale(Enum.newBuilder().build())
				 .timeZoneId("123456789")
				 .displayLanguageId("123456789")
				  .build())
			 .build();

	  // 发起请求
	  CreateLocationResp resp = client.corehr().location().create(req);

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
