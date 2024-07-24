package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// PUT /open-apis/hire/v1/tripartite_agreements/:tripartite_agreement_id
public class UpdateTripartiteAgreementSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UpdateTripartiteAgreementReq req = UpdateTripartiteAgreementReq.newBuilder()
			 .tripartiteAgreementId("")
			.tripartiteAgreementInfo(TripartiteAgreementInfo.newBuilder()
				 .state(1)
				 .modifyTime("1698292282661")
				  .build())
			 .build();

	  // 发起请求
	  UpdateTripartiteAgreementResp resp = client.hire().v1().tripartiteAgreement().update(req);

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
