package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import com.lark.oapi.service.corehr.v1.model.Enum;

import java.util.HashMap;

// POST /open-apis/corehr/v1/departments
public class CreateDepartmentSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateDepartmentReq req = CreateDepartmentReq.newBuilder()
			 .clientToken("12454646")
			 .userIdType("people_corehr_id")
			 .departmentIdType("people_corehr_department_id")
			.departmentCreate(DepartmentCreate.newBuilder()
				 .subType(Enum.newBuilder().build())
				 .manager("6893013238632416776")
				 .isConfidential(true)
				 .hiberarchyCommon(HiberarchyCommon.newBuilder().build())
				 .effectiveTime("2020-05-01 00:00:00")
				 .customFields(new ObjectFieldData[]{})
				 .costCenterId("7142384817131652652")
				  .build())
			 .build();

	  // 发起请求
	  CreateDepartmentResp resp = client.corehr().department().create(req);

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
