package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.SearchProbationReq;
import com.lark.oapi.service.corehr.v2.model.SearchProbationReqBody;
import com.lark.oapi.service.corehr.v2.model.SearchProbationResp;

// POST /open-apis/corehr/v2/probation/search
public class SearchProbationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchProbationReq req = SearchProbationReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .searchProbationReqBody(SearchProbationReqBody.newBuilder()
                        .employmentIds(new String[]{})
                        .departmentIds(new String[]{})
                        .probationStartDateStart("2022-05-18")
                        .probationStartDateEnd("2022-05-20")
                        .probationExpectedEndDateStart("2022-06-20")
                        .probationExpectedEndDateEnd("2022-07-20")
                        .actualProbationEndDateStart("2022-08-20")
                        .actualProbationEndDateEnd("2022-09-20")
                        .initiatingTimeStart("2022-10-20")
                        .initiatingTimeEnd("2022-11-20")
                        .probationStatus("approved")
                        .finalAssessmentResult("approved")
                        .finalAssessmentGrade("grade_a")
                        .build())
                .build();

        // 发起请求
        SearchProbationResp resp = client.corehr().v2().probation().search(req);

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
