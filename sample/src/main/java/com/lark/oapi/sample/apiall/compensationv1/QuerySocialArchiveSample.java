package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/social_archive/query
public class QuerySocialArchiveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QuerySocialArchiveReq req = QuerySocialArchiveReq.newBuilder()
                .userIdType("open_id")
                .querySocialArchiveReqBody(QuerySocialArchiveReqBody.newBuilder()
                        .userIdList(new String[]{})
                        .effectiveDate("2024-01-01")
                        .build())
                .build();

        // 发起请求
        QuerySocialArchiveResp resp = client.compensation().v1().socialArchive().query(req);

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
