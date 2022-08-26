package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.QuerySpreadsheetSheetFloatImageReq;
import com.lark.oapi.service.sheets.v3.model.QuerySpreadsheetSheetFloatImageResp;

// GET /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/float_images/query
public class QuerySpreadsheetSheetFloatImageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    QuerySpreadsheetSheetFloatImageReq req = QuerySpreadsheetSheetFloatImageReq.newBuilder()
        .spreadsheetToken("shtcnmBA*****yGehy8")
        .sheetId("0b**12")
        .build();

    // 发起请求
    QuerySpreadsheetSheetFloatImageResp resp = client.sheets().spreadsheetSheetFloatImage()
        .query(req);

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
