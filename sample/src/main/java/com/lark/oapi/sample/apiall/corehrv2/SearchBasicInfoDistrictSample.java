package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/basic_info/districts/search
public class SearchBasicInfoDistrictSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  SearchBasicInfoDistrictReq req = SearchBasicInfoDistrictReq.newBuilder()
			 .pageSize(100)
			 .pageToken("6863333352758314504")
			.searchBasicInfoDistrictReqBody(SearchBasicInfoDistrictReqBody.newBuilder()
				 .cityIdList(new String[]{})
				 .districtIdList(new String[]{})
				 .statusList(new Integer[]{})
				  .build())
			 .build();

	  // 发起请求
	  SearchBasicInfoDistrictResp resp = client.corehr().v2().basicInfoDistrict().search(req);

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
