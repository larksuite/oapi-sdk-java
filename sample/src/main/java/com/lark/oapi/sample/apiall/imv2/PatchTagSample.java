package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.*;
import java.util.HashMap;

// PATCH /open-apis/im/v2/tags/:tag_id
public class PatchTagSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchTagReq req = PatchTagReq.newBuilder()
			 .tagId("716168xxxxx")
			.patchTagReqBody(PatchTagReqBody.newBuilder()
				 .patchTag(PatchTag.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  PatchTagResp resp = client.im().v2().tag().patch(req);

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
