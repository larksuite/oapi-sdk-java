package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/offers/:offer_id/intern_offer_status
public class InternOfferStatusOfferSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  InternOfferStatusOfferReq req = InternOfferStatusOfferReq.newBuilder()
			 .offerId("7016605170635213100")
			.internOfferStatus(InternOfferStatus.newBuilder()
				 .operation("confirm_onboarding")
				 .onboardingInfo(InternOfferOnboardingInfo.newBuilder().build())
				 .offboardingInfo(InternOfferOffboardingInfo.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  InternOfferStatusOfferResp resp = client.hire().offer().internOfferStatus(req);

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
