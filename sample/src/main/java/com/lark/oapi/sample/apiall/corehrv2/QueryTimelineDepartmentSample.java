package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.QueryTimelineDepartmentReq;
import com.lark.oapi.service.corehr.v2.model.QueryTimelineDepartmentReqBody;
import com.lark.oapi.service.corehr.v2.model.QueryTimelineDepartmentResp;

// POST /open-apis/corehr/v2/departments/query_timeline
public class QueryTimelineDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryTimelineDepartmentReq req = QueryTimelineDepartmentReq.newBuilder()
                .userIdType("people_corehr_id")
                .departmentIdType("people_corehr_department_id")
                .queryTimelineDepartmentReqBody(QueryTimelineDepartmentReqBody.newBuilder()
                        .departmentIds(new String[]{})
                        .effectiveDate("2020-01-01")
                        .fields(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryTimelineDepartmentResp resp = client.corehr().v2().department().queryTimeline(req);

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
