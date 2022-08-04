/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.sample.api;

import com.lark.oapi.Client;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.enums.UserIdTypeEnum;
import com.lark.oapi.service.bitable.v1.model.AppTableRecord;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordReqBody;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordResp;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableRecordResp;
import com.lark.oapi.service.bitable.v1.model.Url;
import java.util.HashMap;
import java.util.Map;

public class BitableSample {


  public static void createTableRecord(Client client) throws Exception {

    Map<String, Object> fields = new HashMap<>();
    fields.put("name", "zlx");
    fields.put("sex", "male");
    fields.put("Date", 1612108800000L);
    fields.put("number", 1234L);
    fields.put("url", Url.newBuilder()
        .link("https://bytedance.feishu.cn/drive/home/")
        .text("我是加多")
        .build());
//    fields.put("Attachment",
//        new Attachment[]{Attachment.newBuilder().fileToken("boxcnnIpo5luPZtLWjuyJpuo9yf").build()});

    CreateAppTableRecordReq req = CreateAppTableRecordReq.newBuilder()
        .userIdType(UserIdTypeEnum.USER_ID)
        .tableId("tbl9a6pWtNVFsSrQ")
        .appToken("bascnpApISZqKuO0uEbcOzGcH6b")
        .appTableRecord(AppTableRecord.newBuilder()
            .fields(fields)
            .build())
        .build();

    // 发起请求
    CreateAppTableRecordResp resp = client.bitable().appTableRecord()
        .create(req, RequestOptions.newBuilder()
            .userAccessToken("u-2Q0ERNI7F6FaiEU3HzuqR90glhox4leHPi005gO025Qz")
            .build());

    // 处理服务端错误
    if (resp.getCode() != 0) {
      System.out.println(String.format("code:%d,msg:%s,err:%s"
          , resp.getCode(), resp.getMsg(), resp.getRequestId()));
      return;
    }

    // 业务处理结果
    System.out.println(Jsons.DEFAULT.toJson(resp));
  }


  public static void batchCreateTableRecord(Client client) throws Exception {
    Map<String, Object> fields = new HashMap<>();
//    fields.put("name", "zlx");
//    fields.put("sex", "male");
//    fields.put("Date", 1612108800000L);
    fields.put("aid", 121212);
    fields.put("tag", Url.newBuilder()
        .link("https://bytedance.feishu.cn/drive/home/")
        .text("我是加多")
        .build());
    AppTableRecord record = AppTableRecord.newBuilder()
        .fields(fields)
        .build();

    BatchCreateAppTableRecordReq req = BatchCreateAppTableRecordReq.newBuilder()
        .userIdType(UserIdTypeEnum.USER_ID)
        .tableId("tbl2CfTdOZ2cuTMD")
        .appToken("bascnXiAbRDW2azUWZECiBc2Hrd")
        .batchCreateAppTableRecordReqBody(BatchCreateAppTableRecordReqBody.newBuilder()
            .records(new AppTableRecord[]{record, record})
            .build())
        .build();

    // 发起请求
    BatchCreateAppTableRecordResp resp = client.bitable().appTableRecord()
        .batchCreate(req, RequestOptions.newBuilder()
            .userAccessToken("u-2Q0ERNI7F6FaiEU3HzuqR90glhox4leHPi005gO025Qz")
            .build());

    // 处理服务端错误
    if (resp.getCode() != 0) {
      System.out.println(String.format("code:%d,msg:%s,err:%s"
          , resp.getCode(), resp.getMsg(), resp.getRequestId()));
      return;
    }

    // 业务处理结果
    System.out.println(Jsons.DEFAULT.toJson(resp));
  }

  public static void main(String arg[]) throws Exception {
    // 构建client
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    Client client = Client.newBuilder(appId, appSecret).build();
    createTableRecord(client);
  }


}
