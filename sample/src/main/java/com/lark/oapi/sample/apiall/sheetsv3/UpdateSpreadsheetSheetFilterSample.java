package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.Condition;
import com.lark.oapi.service.sheets.v3.model.UpdateSheetFilter;
import com.lark.oapi.service.sheets.v3.model.UpdateSpreadsheetSheetFilterReq;
import com.lark.oapi.service.sheets.v3.model.UpdateSpreadsheetSheetFilterResp;

// PUT /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/filter
public class UpdateSpreadsheetSheetFilterSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateSpreadsheetSheetFilterReq req = UpdateSpreadsheetSheetFilterReq.newBuilder()
                .spreadsheetToken("")
                .sheetId("")
                .updateSheetFilter(UpdateSheetFilter.newBuilder()
                        .col("")
                        .condition(Condition.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateSpreadsheetSheetFilterResp resp = client.sheets().v3().spreadsheetSheetFilter().update(req);

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
