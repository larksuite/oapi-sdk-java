package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/eco_background_check_packages/batch_delete
public class BatchDeleteEcoBackgroundCheckPackageSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchDeleteEcoBackgroundCheckPackageReq req = BatchDeleteEcoBackgroundCheckPackageReq.newBuilder()
			.batchDeleteEcoBackgroundCheckPackageReqBody(BatchDeleteEcoBackgroundCheckPackageReqBody.newBuilder()
				 .accountId("xd_bc_001")
				 .packageIdList(new String[]{})
				 .additionalItemIdList(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchDeleteEcoBackgroundCheckPackageResp resp = client.hire().v1().ecoBackgroundCheckPackage().batchDelete(req);

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
