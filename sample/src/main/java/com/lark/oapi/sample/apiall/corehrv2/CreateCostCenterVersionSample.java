package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/cost_centers/:cost_center_id/versions
public class CreateCostCenterVersionSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateCostCenterVersionReq req = CreateCostCenterVersionReq.newBuilder()
			 .costCenterId("6862995757234914824")
			 .userIdType("people_corehr_id")
			.costCenterVersion(CostCenterVersion.newBuilder()
				 .name(new I18n[]{})
				 .parentCostCenterId("6862995757234914824")
				 .managers(new String[]{})
				 .description(new I18n[]{})
				 .effectiveTime("2020-01-01")
				 .operationReason("过期作废")
				  .build())
			 .build();

	  // 发起请求
	  CreateCostCenterVersionResp resp = client.corehr().v2().costCenterVersion().create(req);

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
