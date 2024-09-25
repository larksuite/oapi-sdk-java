package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.SearchPreHireReq;
import com.lark.oapi.service.corehr.v2.model.SearchPreHireReqBody;
import com.lark.oapi.service.corehr.v2.model.SearchPreHireResp;

// POST /open-apis/corehr/v2/pre_hires/search
public class SearchPreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchPreHireReq req = SearchPreHireReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .searchPreHireReqBody(SearchPreHireReqBody.newBuilder()
                        .workerIds(new String[]{})
                        .preHireIds(new String[]{})
                        .personIds(new String[]{})
                        .onboardingDateStart("2006-01-02")
                        .onboardingDateEnd("2006-01-02")
                        .updatedDateStart("2006-01-02")
                        .updatedDateEnd("2006-01-02")
                        .onboardingLocationIds(new String[]{})
                        .onboardingStatus("待入职(preboarding)")
                        .departmentIds(new String[]{})
                        .directManagerIds(new String[]{})
                        .employeeTypeIds(new String[]{})
                        .employeeSubtypeIds(new String[]{})
                        .jobFamilyIds(new String[]{})
                        .keyWord("张三")
                        .rehire("张三")
                        .fields(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchPreHireResp resp = client.corehr().v2().preHire().search(req);

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
