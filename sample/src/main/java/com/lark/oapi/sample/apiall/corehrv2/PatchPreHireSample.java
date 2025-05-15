package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/pre_hires/:pre_hire_id
public class PatchPreHireSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchPreHireReq req = PatchPreHireReq.newBuilder()
			 .preHireId("7345005664477775411")
			.prehireUpdate(PrehireUpdate.newBuilder()
				 .basicInfoUpdate(BasicInfoUpdate.newBuilder().build())
				 .offerInfoUpdate(OfferInfoUpdate.newBuilder().build())
				 .standardUpdateFields(new String[]{})
				 .customUpdateFields(new String[]{})
				 .personCustomUpdateFields(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  PatchPreHireResp resp = client.corehr().v2().preHire().patch(req);

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
