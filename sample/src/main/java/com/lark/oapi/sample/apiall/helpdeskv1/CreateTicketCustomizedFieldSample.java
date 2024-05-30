package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.*;
import java.util.HashMap;

// POST /open-apis/helpdesk/v1/ticket_customized_fields
public class CreateTicketCustomizedFieldSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateTicketCustomizedFieldReq req = CreateTicketCustomizedFieldReq.newBuilder()
			.ticketCustomizedField(TicketCustomizedField.newBuilder()
				 .helpdeskId("")
				 .keyName("")
				 .displayName("")
				 .position("")
				 .fieldType("")
				 .description("")
				 .visible(false)
				 .editable(false)
				 .required(false)
				 .dropdownAllowMultiple(false)
				  .build())
			 .build();

	  // 发起请求
	  CreateTicketCustomizedFieldResp resp = client.helpdesk().v1().ticketCustomizedField().create(req);

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
