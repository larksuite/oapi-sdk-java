package com.lark.oapi.sample.apiall.gray_test_open_sgv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.gray_test_open_sg.v1.model.*;
import java.util.HashMap;

// GET /open-apis/gray_test_open_sg/v1/motos
public class ListMotoSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListMotoReq req = ListMotoReq.newBuilder()
			 .pageSize(0)
			 .pageToken("")
			 .level(0)
			 .build();

	  // 发起请求
	  ListMotoResp resp = client.grayTestOpenSg().moto().list(req);

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
