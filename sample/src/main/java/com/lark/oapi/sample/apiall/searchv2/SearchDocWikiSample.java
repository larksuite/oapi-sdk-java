package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;

import java.util.HashMap;

// POST /open-apis/search/v2/doc_wiki/search
public class SearchDocWikiSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchDocWikiReq req = SearchDocWikiReq.newBuilder()
                .searchDocWikiReqBody(SearchDocWikiReqBody.newBuilder()
                        .query("飞书文档使用指南")
                        .docFilter(DocFilter.newBuilder().build())
                        .wikiFilter(WikiFilter.newBuilder().build())
                        .pageToken("token_1234567890fedcba")
                        .pageSize(0)
                        .build())
                .build();

        // 发起请求
        SearchDocWikiResp resp = client.search().v2().docWiki().search(req);

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
