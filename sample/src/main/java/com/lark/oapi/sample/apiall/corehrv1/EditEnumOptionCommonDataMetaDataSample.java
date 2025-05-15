package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/common_data/meta_data/edit_enum_option
public class EditEnumOptionCommonDataMetaDataSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  EditEnumOptionCommonDataMetaDataReq req = EditEnumOptionCommonDataMetaDataReq.newBuilder()
			 .clientToken("6727817538283013641")
			.editEnumOptionCommonDataMetaDataReqBody(EditEnumOptionCommonDataMetaDataReqBody.newBuilder()
				 .objectApiName("probation_management")
				 .enumFieldApiName("final_assessment_grade")
				 .enumFieldOption(EnumFieldOption.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  EditEnumOptionCommonDataMetaDataResp resp = client.corehr().v1().commonDataMetaData().editEnumOption(req);

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
