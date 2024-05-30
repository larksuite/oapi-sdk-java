package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.*;
import java.util.HashMap;

// POST /open-apis/okr/v1/progress_records
public class CreateProgressRecordSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateProgressRecordReq req = CreateProgressRecordReq.newBuilder()
			 .userIdType("user_id")
			.createProgressRecordReqBody(CreateProgressRecordReqBody.newBuilder()
				 .sourceTitle("周报系统")
				 .sourceUrl("https://www.zhoubao.com")
				 .targetId("7041430377642082323")
				 .targetType(1)
				 .content(ContentBlock.newBuilder().build())
				 .sourceUrlPc("open.feishu.cn")
				 .sourceUrlMobile("open.feishu.cn")
				  .build())
			 .build();

	  // 发起请求
	  CreateProgressRecordResp resp = client.okr().v1().progressRecord().create(req);

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
