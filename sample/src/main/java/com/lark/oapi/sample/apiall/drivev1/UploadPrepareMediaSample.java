package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;
import java.util.HashMap;

// POST /open-apis/drive/v1/medias/upload_prepare
public class UploadPrepareMediaSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UploadPrepareMediaReq req = UploadPrepareMediaReq.newBuilder()
			.mediaUploadInfo(MediaUploadInfo.newBuilder()
				 .fileName("123.txt")
				 .parentType("doc_image")
				 .parentNode("fldcnxxxxxx")
				 .size(1024)
				 .extra("test")
				  .build())
			 .build();

	  // 发起请求
	  UploadPrepareMediaResp resp = client.drive().media().uploadPrepare(req);

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
