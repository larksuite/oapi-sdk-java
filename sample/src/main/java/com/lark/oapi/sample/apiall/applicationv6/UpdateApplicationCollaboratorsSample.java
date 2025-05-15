package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;
import java.util.HashMap;

// PUT /open-apis/application/v6/applications/:app_id/collaborators
public class UpdateApplicationCollaboratorsSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UpdateApplicationCollaboratorsReq req = UpdateApplicationCollaboratorsReq.newBuilder()
			 .appId("cli_a5002df1b6f8d01c")
			 .userIdType("open_id")
			.updateApplicationCollaboratorsReqBody(UpdateApplicationCollaboratorsReqBody.newBuilder()
				 .adds(new AppCollaborator[]{})
				 .removes(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  UpdateApplicationCollaboratorsResp resp = client.application().v6().applicationCollaborators().update(req);

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
