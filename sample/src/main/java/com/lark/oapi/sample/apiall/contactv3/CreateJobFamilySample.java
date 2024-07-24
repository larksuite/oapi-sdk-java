package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;
import java.util.HashMap;

// POST /open-apis/contact/v3/job_families
public class CreateJobFamilySample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateJobFamilyReq req = CreateJobFamilyReq.newBuilder()
			.jobFamily(JobFamily.newBuilder()
				 .name("产品")
				 .description("负责产品策略制定的相关工作")
				 .parentJobFamilyId("mga5oa8ayjlp9rb")
				 .status(false)
				 .i18nName(new I18nContent[]{})
				 .i18nDescription(new I18nContent[]{})
				  .build())
			 .build();

	  // 发起请求
	  CreateJobFamilyResp resp = client.contact().v3().jobFamily().create(req);

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
