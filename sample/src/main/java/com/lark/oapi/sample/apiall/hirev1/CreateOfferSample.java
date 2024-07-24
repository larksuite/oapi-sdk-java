package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/offers
public class CreateOfferSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateOfferReq req = CreateOfferReq.newBuilder()
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			 .jobLevelIdType("people_admin_job_level_id")
			 .jobFamilyIdType("people_admin_job_category_id")
			 .employeeTypeIdType("people_admin_employee_type_id")
			.offerInfo(OfferInfo.newBuilder()
				 .applicationId("7013552389293279532")
				 .schemaId("7013318077945596204")
				 .offerType(1)
				 .basicInfo(OfferBasicInfo.newBuilder().build())
				 .salaryInfo(OfferSalaryInfo.newBuilder().build())
				 .customizedInfoList(new OfferCustomizedInfo[]{})
				  .build())
			 .build();

	  // 发起请求
	  CreateOfferResp resp = client.hire().v1().offer().create(req);

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
