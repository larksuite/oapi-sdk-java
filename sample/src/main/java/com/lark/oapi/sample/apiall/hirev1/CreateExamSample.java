package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/exams
public class CreateExamSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateExamReq req = CreateExamReq.newBuilder()
			 .userIdType("user_id")
			.createExamReqBody(CreateExamReqBody.newBuilder()
				 .applicationId("6891565253964859661")
				 .examResourceName("笔试试卷")
				 .score(100.0)
				 .uuid("6949805467799537964")
				 .operatorId("ou_f476cb099ac9227c9bae09ce46112579")
				  .build())
			 .build();

	  // 发起请求
	  CreateExamResp resp = client.hire().v1().exam().create(req);

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
