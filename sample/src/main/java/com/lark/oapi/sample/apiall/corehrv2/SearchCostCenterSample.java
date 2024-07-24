package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/cost_centers/search
public class SearchCostCenterSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchCostCenterReq req = SearchCostCenterReq.newBuilder()
			 .pageSize(100)
			 .pageToken("6891251722631890445")
			 .userIdType("people_corehr_id")
			.searchCostCenterReqBody(SearchCostCenterReqBody.newBuilder()
				 .costCenterIdList(new String[]{})
				 .nameList(new String[]{})
				 .code("MDPD00000023")
				 .parentCostCenterId("6862995757234914824")
				 .getAllVersion(false)
				  .build())
			 .build();

	  // 发起请求
	  SearchCostCenterResp resp = client.corehr().v2().costCenter().search(req);

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
