package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.QuerySpreadsheetSheetFilterViewConditionReq;
import com.lark.oapi.service.sheets.v3.model.QuerySpreadsheetSheetFilterViewConditionResp;

// HTTP PATH: /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/filter_views/:filter_view_id/conditions/query"
public class QuerySpreadsheetSheetFilterViewConditionSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    QuerySpreadsheetSheetFilterViewConditionReq req = QuerySpreadsheetSheetFilterViewConditionReq.newBuilder()
        .spreadsheetToken("")
        .sheetId("")
        .filterViewId("")
        .build();

    // 发起请求
    QuerySpreadsheetSheetFilterViewConditionResp resp = client.sheets()
        .spreadsheetSheetFilterViewCondition().query(req);

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
