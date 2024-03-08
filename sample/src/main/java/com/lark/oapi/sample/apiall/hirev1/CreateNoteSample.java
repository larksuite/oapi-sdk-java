package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/notes
public class CreateNoteSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateNoteReq req = CreateNoteReq.newBuilder()
			 .userIdType("open_id")
			.note(Note.newBuilder()
				 .talentId("6916472453069883661")
				 .applicationId("6891565253964859661")
				 .creatorId("ou_f476cb099ac9227c9bae09ce46112579")
				 .content("测试5")
				 .privacy(1)
				  .build())
			 .build();

	  // 发起请求
	  CreateNoteResp resp = client.hire().v1().note().create(req);

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
