package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.SearchTestReq;
import com.lark.oapi.service.hire.v1.model.SearchTestReqBody;
import com.lark.oapi.service.hire.v1.model.SearchTestResp;

// POST /open-apis/hire/v1/tests/search
public class SearchTestSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchTestReq req = SearchTestReq.newBuilder()
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(10)
                .userIdType("user_id")
                .searchTestReqBody(SearchTestReqBody.newBuilder()
                        .applicationIdList(new String[]{})
                        .testStartTimeMin("1608725989000")
                        .testStartTimeMax("1608726989000")
                        .build())
                .build();

        // 发起请求
        SearchTestResp resp = client.hire().v1().test().search(req);

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
