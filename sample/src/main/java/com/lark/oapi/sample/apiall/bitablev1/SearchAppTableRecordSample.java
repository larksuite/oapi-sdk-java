package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/records/search
public class SearchAppTableRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchAppTableRecordReq req = SearchAppTableRecordReq.newBuilder()
                .appToken("NQRxbRkBMa6OnZsjtERcxhNWnNh")
                .tableId("tbl0xe5g8PP3U3cS")
                .userIdType("open_id")
                .pageToken("")
                .pageSize(20)
                .searchAppTableRecordReqBody(SearchAppTableRecordReqBody.newBuilder()
                        .viewId("viex")
                        .fieldNames(new String[]{})
                        .sort(new Sort[]{})
                        .filter(FilterInfo.newBuilder().build())
                        .automaticFields(false)
                        .build())
                .build();

        // 发起请求
        SearchAppTableRecordResp resp = client.bitable().v1().appTableRecord().search(req);

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
