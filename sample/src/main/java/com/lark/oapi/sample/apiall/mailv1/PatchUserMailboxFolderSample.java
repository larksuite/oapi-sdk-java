package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/folders/:folder_id
public class PatchUserMailboxFolderSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchUserMailboxFolderReq req = PatchUserMailboxFolderReq.newBuilder()
			 .userMailboxId("user@xxx.xx 或 me")
			 .folderId("111111")
			.folder(Folder.newBuilder()
				 .name("newsletter 相关")
				 .parentFolderId("725627422334644")
				  .build())
			 .build();

	  // 发起请求
	  PatchUserMailboxFolderResp resp = client.mail().v1().userMailboxFolder().patch(req);

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
