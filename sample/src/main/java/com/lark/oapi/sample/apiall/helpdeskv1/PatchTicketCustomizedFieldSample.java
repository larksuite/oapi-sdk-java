package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/helpdesk/v1/ticket_customized_fields/:ticket_customized_field_id
public class PatchTicketCustomizedFieldSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchTicketCustomizedFieldReq req = PatchTicketCustomizedFieldReq.newBuilder()
			 .ticketCustomizedFieldId("6948728206392295444")
			.ticketCustomizedField(TicketCustomizedField.newBuilder()
				 .displayName("")
				 .position("")
				 .description("")
				 .visible(false)
				 .required(false)
				  .build())
			 .build();

	  // 发起请求
	  PatchTicketCustomizedFieldResp resp = client.helpdesk().ticketCustomizedField().patch(req);

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
