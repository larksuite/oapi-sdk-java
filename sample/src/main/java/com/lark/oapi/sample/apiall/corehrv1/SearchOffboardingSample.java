package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/offboardings/search
public class SearchOffboardingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchOffboardingReq req = SearchOffboardingReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .searchOffboardingReqBody(SearchOffboardingReqBody.newBuilder()
                        .employmentIds(new String[]{})
                        .applyInitiatingTimeStart("2022-01-01 11:22:33")
                        .applyInitiatingTimeEnd("2022-01-01 11:22:33")
                        .applyFinishedTimeStart("1641007353")
                        .applyFinishedTimeEnd("1641007353")
                        .expectedOffboardingDateStart("2022-01-01")
                        .expectedOffboardingDateEnd("2022-01-01")
                        .offboardingDateStart("2022-01-01")
                        .offboardingDateEnd("2022-01-01")
                        .statuses(new String[]{})
                        .reasons(new String[]{})
                        .employeeReasons(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchOffboardingResp resp = client.corehr().v1().offboarding().search(req);

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
