package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/bitable/v1/apps/:app_token/tables/:table_id/forms/:form_id/fields/:field_id
public class PatchAppTableFormFieldSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchAppTableFormFieldReq req = PatchAppTableFormFieldReq.newBuilder()
			 .appToken("bascnCMII2ORej2RItqpZZUNMIe")
			 .tableId("tblsRc9GRRXKqhvW")
			 .formId("vewTpR1urY")
			 .fieldId("fldjX7dUj5")
			.appTableFormPatchedField(AppTableFormPatchedField.newBuilder()
				 .preFieldId("")
				 .title("")
				 .description("")
				 .required(false)
				 .visible(false)
				  .build())
			 .build();

	  // 发起请求
	  PatchAppTableFormFieldResp resp = client.bitable().v1().appTableFormField().patch(req);

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
