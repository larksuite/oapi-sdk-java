package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// GET /open-apis/corehr/v1/authorizations/query
public class QueryAuthorizationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryAuthorizationReq req = QueryAuthorizationReq.newBuilder()
                .employmentIdList(new String[]{})
                .roleIdList(new String[]{})
                .pageToken("6969864184272078374")
                .pageSize("20")
                .userIdType("people_corehr_id")
                .updatedAtGte("1729773628")
                .updatedAtLte("1729773628")
                .build();

        // 发起请求
        QueryAuthorizationResp resp = client.corehr().v1().authorization().query(req);

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
