package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/employments
public class CreateEmploymentSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateEmploymentReq req = CreateEmploymentReq.newBuilder()
			 .clientToken("12454646")
			.employmentCreate(EmploymentCreate.newBuilder()
				 .seniorityDate("2020-01-01")
				 .employeeNumber("1000000")
				 .effectiveTime("2020-01-01")
				 .expirationTime("2021-01-01")
				 .employmentType(Enum.newBuilder().build())
				 .personId("6919733936050406926")
				 .primaryEmployment(true)
				 .employmentStatus(Enum.newBuilder().build())
				 .customFields(new ObjectFieldData[]{})
				 .workEmailList(new Email[]{})
				 .reasonForOffboarding(Enum.newBuilder().build())
				 .atsApplicationId("6838119494196871234")
				 .rehire(Enum.newBuilder().build())
				 .rehireEmploymentId("7051837122449425964")
				  .build())
			 .build();

	  // 发起请求
	  CreateEmploymentResp resp = client.corehr().v1().employment().create(req);

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
