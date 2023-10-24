package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/employee_type_enums
public class CreateEmployeeTypeEnumSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateEmployeeTypeEnumReq req = CreateEmployeeTypeEnumReq.newBuilder()
			.employeeTypeEnum(EmployeeTypeEnum.newBuilder()
				 .content("")
				 .enumType(1)
				 .enumStatus(1)
				 .i18nContent(new I18nContent[]{})
				  .build())
			 .build();

	  // 发起请求
	  CreateEmployeeTypeEnumResp resp = client.contact().employeeTypeEnum().create(req);

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
