package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.*;
import java.util.HashMap;

// GET /open-apis/okr/v1/users/:user_id/okrs
public class ListUserOkrSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListUserOkrReq req = ListUserOkrReq.newBuilder()
			 .userId("ou-asdasdasdasdasd")
			 .userIdType("open_id")
			 .offset("0")
			 .limit("5")
			 .lang("zh_cn")
			 .periodIds(new String[]{})
			 .build();

	  // 发起请求
	  ListUserOkrResp resp = client.okr().userOkr().list(req);

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
