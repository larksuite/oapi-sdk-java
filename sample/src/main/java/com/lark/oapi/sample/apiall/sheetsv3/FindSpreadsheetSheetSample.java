package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.Find;
import com.lark.oapi.service.sheets.v3.model.FindCondition;
import com.lark.oapi.service.sheets.v3.model.FindSpreadsheetSheetReq;
import com.lark.oapi.service.sheets.v3.model.FindSpreadsheetSheetResp;

// POST /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/find
public class FindSpreadsheetSheetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        FindSpreadsheetSheetReq req = FindSpreadsheetSheetReq.newBuilder()
                .spreadsheetToken("shtcnmBA*****yGehy8")
                .sheetId("0b**12")
                .find(Find.newBuilder()
                        .findCondition(FindCondition.newBuilder().build())
                        .find("")
                        .build())
                .build();

        // 发起请求
        FindSpreadsheetSheetResp resp = client.sheets().v3().spreadsheetSheet().find(req);

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
