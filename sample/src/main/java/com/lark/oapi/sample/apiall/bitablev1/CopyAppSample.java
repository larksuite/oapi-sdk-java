package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/copy
public class CopyAppSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CopyAppReq req = CopyAppReq.newBuilder()
			 .appToken("S404b*****e9PQsYDWYcNryFn0g")
			.copyAppReqBody(CopyAppReqBody.newBuilder()
				 .name("一篇新的多维表格")
				 .folderToken("fldbco*****CIMltVc")
				 .withoutContent(false)
				 .timeZone("Asia/Shanghai")
				  .build())
			 .build();

	  // 发起请求
	  CopyAppResp resp = client.bitable().v1().app().copy(req);

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
