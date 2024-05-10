package com.lark.oapi.sample.apiall.translationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.translation.v1.model.*;
import java.util.HashMap;

// POST /open-apis/translation/v1/text/translate
public class TranslateTextSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  TranslateTextReq req = TranslateTextReq.newBuilder()
			.translateTextReqBody(TranslateTextReqBody.newBuilder()
				 .sourceLanguage("zh")
				 .text("尝试使用一下飞书吧")
				 .targetLanguage("en")
				 .glossary(new Term[]{})
				  .build())
			 .build();

	  // 发起请求
	  TranslateTextResp resp = client.translation().v1().text().translate(req);

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
