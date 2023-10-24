package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.*;
import java.util.HashMap;

// PUT /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/filter_views/:filter_view_id/conditions/:condition_id
public class UpdateSpreadsheetSheetFilterViewConditionSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UpdateSpreadsheetSheetFilterViewConditionReq req = UpdateSpreadsheetSheetFilterViewConditionReq.newBuilder()
			 .spreadsheetToken("shtcnmBA*****yGehy8")
			 .sheetId("0b**12")
			 .filterViewId("pH9hbVcCXA")
			 .conditionId("E")
			.filterViewCondition(FilterViewCondition.newBuilder()
				 .filterType("")
				 .compareType("")
				 .expected(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  UpdateSpreadsheetSheetFilterViewConditionResp resp = client.sheets().spreadsheetSheetFilterViewCondition().update(req);

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
