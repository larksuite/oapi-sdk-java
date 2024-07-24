package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/probation/submit
public class SubmitProbationSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SubmitProbationReq req = SubmitProbationReq.newBuilder()
			 .clientToken("6822122262122064111")
			 .userIdType("open_id")
			.submitProbationReqBody(SubmitProbationReqBody.newBuilder()
				 .employmentId("7140964208476371111")
				 .conversionMode(1)
				 .actualProbationEndDate("2022-05-20")
				 .submissionType("system")
				 .initiatorId("7140964208476371111")
				 .notes("符合预期")
				 .selfReview("符合预期")
				 .customFields(new CustomFieldData[]{})
				  .build())
			 .build();

	  // 发起请求
	  SubmitProbationResp resp = client.corehr().v2().probation().submit(req);

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
