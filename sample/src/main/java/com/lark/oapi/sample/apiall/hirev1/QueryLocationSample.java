package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.QueryLocationReq;
import com.lark.oapi.service.hire.v1.model.QueryLocationReqBody;
import com.lark.oapi.service.hire.v1.model.QueryLocationResp;

// POST /open-apis/hire/v1/locations/query
public class QueryLocationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryLocationReq req = QueryLocationReq.newBuilder()
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(100)
                .queryLocationReqBody(QueryLocationReqBody.newBuilder()
                        .codeList(new String[]{})
                        .locationType(1)
                        .build())
                .build();

        // 发起请求
        QueryLocationResp resp = client.hire().v1().location().query(req);

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
