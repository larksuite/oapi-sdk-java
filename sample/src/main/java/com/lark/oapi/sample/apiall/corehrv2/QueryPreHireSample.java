package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.QueryPreHireReq;
import com.lark.oapi.service.corehr.v2.model.QueryPreHireReqBody;
import com.lark.oapi.service.corehr.v2.model.QueryPreHireResp;

// POST /open-apis/corehr/v2/pre_hires/query
public class QueryPreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryPreHireReq req = QueryPreHireReq.newBuilder()
                .pageSize(10)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .queryPreHireReqBody(QueryPreHireReqBody.newBuilder()
                        .preHireIds(new String[]{})
                        .fields(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryPreHireResp resp = client.corehr().v2().preHire().query(req);

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
