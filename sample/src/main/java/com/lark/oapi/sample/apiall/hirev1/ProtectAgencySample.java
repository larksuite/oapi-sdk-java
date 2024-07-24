package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/agencies/protect
public class ProtectAgencySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ProtectAgencyReq req = ProtectAgencyReq.newBuilder()
			 .userIdType("open_id")
			.protectAgencyReqBody(ProtectAgencyReqBody.newBuilder()
				 .talentId("6962051712422398239")
				 .supplierId("6898173495386147079")
				 .consultantId("ou_f476cb099ac9227c9bae09ce46112579")
				 .protectCreateTime(1610695587)
				 .protectExpireTime(1626333987)
				 .comment("此候选人非常优秀，建议录用。")
				 .currentSalary("15k * 13")
				 .expectedSalary("18k * 16")
				  .build())
			 .build();

	  // 发起请求
	  ProtectAgencyResp resp = client.hire().v1().agency().protect(req);

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
