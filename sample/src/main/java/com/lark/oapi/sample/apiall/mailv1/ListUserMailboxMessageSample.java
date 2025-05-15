package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;
import java.util.HashMap;

// GET /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/messages
public class ListUserMailboxMessageSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListUserMailboxMessageReq req = ListUserMailboxMessageReq.newBuilder()
			 .userMailboxId("user@xxx.xx 或 me")
			 .pageSize(1)
			 .pageToken("xxx")
			 .folderId("INBOX 或者用户文件夹 id")
			 .onlyUnread(true)
			 .build();

	  // 发起请求
	  ListUserMailboxMessageResp resp = client.mail().v1().userMailboxMessage().list(req);

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
