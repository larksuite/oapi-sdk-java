package com.lark.oapi.sample.apiall.sheetsv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v2.model.BatchGetSpreadsheetSheetValuesReq;
import com.lark.oapi.service.sheets.v2.model.BatchGetSpreadsheetSheetValuesResp;
import com.lark.oapi.service.sheets.v2.model.ValueRange;

// GET /open-apis/sheets/v2/spreadsheets/:spreadsheet_token/values_batch_get
public class BatchGetSpreadsheetSheetValuesSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetSpreadsheetSheetValuesReq req = BatchGetSpreadsheetSheetValuesReq.newBuilder()
                .spreadsheetToken("shtxxxxxxxxxxxxxxxxxx") // 替换为实际的电子表格token
                .ranges("0b**12!A1:B2,0b**12!A1:B2") // 替换为实际的范围，用逗号分隔多个范围
                .valueRenderOption("ToString") // 可选：值渲染选项，默认为ToString
                .dateTimeRenderOption("FormattedString") // 可选：日期时间渲染选项，默认为FormattedString
                .userIdType("open_id") // 可选：用户ID类型
                .build();

        // 发起请求
        BatchGetSpreadsheetSheetValuesResp resp = client.sheets().v2().spreadsheetSheetValues().batchGet(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.printf("code:%s,msg:%s,reqId:%s%n"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId());
            return;
        }

        // 业务数据处理
        System.out.println("批量读取成功!");
        System.out.println("表格Token: " + resp.getData().getSpreadsheetToken());
        System.out.println("版本: " + resp.getData().getRevision());
        
        ValueRange[] valueRanges = resp.getData().getValueRanges();
        if (valueRanges != null) {
            for (int i = 0; i < valueRanges.length; i++) {
                ValueRange valueRange = valueRanges[i];
                System.out.println("=== 范围 " + (i + 1) + " ===");
                System.out.println("范围: " + valueRange.getRange());
                System.out.println("主维度: " + valueRange.getMajorDimension());
                
                // 打印单元格值
                String[][] values = valueRange.getValues();
                if (values != null) {
                    System.out.println("单元格数据:");
                    for (String[] value : values) {
                        for (String s : value) {
                            System.out.print(s + "\t");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("该范围无数据");
                }
                System.out.println();
            }
        }

        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}