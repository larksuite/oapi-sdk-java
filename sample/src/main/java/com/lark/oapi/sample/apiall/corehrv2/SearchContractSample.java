package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.SearchContractReq;
import com.lark.oapi.service.corehr.v2.model.SearchContractReqBody;
import com.lark.oapi.service.corehr.v2.model.SearchContractResp;

// POST /open-apis/corehr/v2/contracts/search
public class SearchContractSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchContractReq req = SearchContractReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .searchContractReqBody(SearchContractReqBody.newBuilder()
                        .employmentIdList(new String[]{})
                        .contractIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchContractResp resp = client.corehr().v2().contract().search(req);

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
