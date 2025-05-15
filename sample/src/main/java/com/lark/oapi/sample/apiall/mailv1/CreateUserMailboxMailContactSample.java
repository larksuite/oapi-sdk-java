package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;
import java.util.HashMap;

// POST /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/mail_contacts
public class CreateUserMailboxMailContactSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateUserMailboxMailContactReq req = CreateUserMailboxMailContactReq.newBuilder()
			 .userMailboxId("user@xxx.xx 或 me")
			.mailContact(MailContact.newBuilder()
				 .name("张三")
				 .company("张三科技有限公司")
				 .phone("19912341234")
				 .mailAddress("zhangsan@example.com")
				 .tag("朋友")
				 .remark("飞书发布会认识")
				 .position("CFO")
				  .build())
			 .build();

	  // 发起请求
	  CreateUserMailboxMailContactResp resp = client.mail().v1().userMailboxMailContact().create(req);

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
