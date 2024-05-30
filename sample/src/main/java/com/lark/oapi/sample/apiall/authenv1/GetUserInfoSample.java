package com.lark.oapi.sample.apiall.authenv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.*;
import java.util.HashMap;

// GET /open-apis/authen/v1/user_info
public class GetUserInfoSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象

	   // 发起请求
	  GetUserInfoResp resp = client.authen().userInfo().get();

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
