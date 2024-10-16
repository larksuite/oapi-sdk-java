package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/job_changes/search
public class SearchJobChangeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchJobChangeReq req = SearchJobChangeReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .searchJobChangeReqBody(SearchJobChangeReqBody.newBuilder()
                        .employmentIds(new String[]{})
                        .jobChangeIds(new String[]{})
                        .statuses(new String[]{})
                        .effectiveDateStart("2022-01-01")
                        .effectiveDateEnd("2022-01-01")
                        .updatedTimeStart("1704084635000")
                        .updatedTimeEnd("1704084635000")
                        .targetDepartmentIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchJobChangeResp resp = client.corehr().v2().jobChange().search(req);

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
