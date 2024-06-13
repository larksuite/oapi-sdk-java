package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.*;

import java.util.HashMap;

// POST /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/replace
public class ReplaceSpreadsheetSheetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ReplaceSpreadsheetSheetReq req = ReplaceSpreadsheetSheetReq.newBuilder()
                .spreadsheetToken("shtcnmBA*****yGehy8")
                .sheetId("0b**12")
                .replace(Replace.newBuilder()
                        .findCondition(FindCondition.newBuilder().build())
                        .find("")
                        .replacement("")
                        .build())
                .build();

        // 发起请求
        ReplaceSpreadsheetSheetResp resp = client.sheets().v3().spreadsheetSheet().replace(req);

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
