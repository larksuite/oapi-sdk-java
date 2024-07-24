package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;
import java.util.HashMap;

// PATCH /open-apis/application/v6/applications/:app_id/visibility
public class PatchApplicationVisibilitySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchApplicationVisibilityReq req = PatchApplicationVisibilityReq.newBuilder()
			 .appId("cli_9b445f5258795107")
			 .departmentIdType("open_department_id")
			 .userIdType("open_id")
			.patchApplicationVisibilityReqBody(PatchApplicationVisibilityReqBody.newBuilder()
				 .addVisibleList(AppVisibilityIdList.newBuilder().build())
				 .delVisibleList(AppVisibilityIdList.newBuilder().build())
				 .addInvisibleList(AppVisibilityIdList.newBuilder().build())
				 .delInvisibleList(AppVisibilityIdList.newBuilder().build())
				 .isVisibleToAll(false)
				  .build())
			 .build();

	  // 发起请求
	  PatchApplicationVisibilityResp resp = client.application().v6().applicationVisibility().patch(req);

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
