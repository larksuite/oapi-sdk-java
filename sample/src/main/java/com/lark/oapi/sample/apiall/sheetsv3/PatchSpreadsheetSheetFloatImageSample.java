package com.lark.oapi.sample.apiall.sheetsv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.sheets.v3.model.FloatImage;
import com.lark.oapi.service.sheets.v3.model.PatchSpreadsheetSheetFloatImageReq;
import com.lark.oapi.service.sheets.v3.model.PatchSpreadsheetSheetFloatImageResp;

// HTTP PATH: /open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/:sheet_id/float_images/:float_image_id"
public class PatchSpreadsheetSheetFloatImageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchSpreadsheetSheetFloatImageReq req = PatchSpreadsheetSheetFloatImageReq.newBuilder()
        .spreadsheetToken("")
        .sheetId("")
        .floatImageId("")
        .floatImage(FloatImage.newBuilder()
            .floatImageToken("")
            .range("")
            .width(0.0)
            .height(0.0)
            .offsetX(0.0)
            .offsetY(0.0)
            .build())
        .build();

    // 发起请求
    PatchSpreadsheetSheetFloatImageResp resp = client.sheets().spreadsheetSheetFloatImage()
        .patch(req);

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
