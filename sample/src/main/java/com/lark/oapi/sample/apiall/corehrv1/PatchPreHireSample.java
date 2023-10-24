package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import com.lark.oapi.service.corehr.v1.model.Enum;

import java.util.HashMap;

// PATCH /open-apis/corehr/v1/pre_hires/:pre_hire_id
public class PatchPreHireSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchPreHireReq req = PatchPreHireReq.newBuilder()
			 .preHireId("1616161616")
			 .clientToken("12454646")
			.preHire(PreHire.newBuilder()
				 .atsApplicationId("4719168654814483759")
				 .hireDate("2020-01-01")
				 .employeeType(Enum.newBuilder().build())
				 .workerId("1245646")
				 .employeeTypeId("正式")
				 .personId("656464648662")
				 .customFields(new ObjectFieldData[]{})
				 .costCenterRate(new SupportCostCenterItem[]{})
				 .onboardingStatus(Enum.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  PatchPreHireResp resp = client.corehr().preHire().patch(req);

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
