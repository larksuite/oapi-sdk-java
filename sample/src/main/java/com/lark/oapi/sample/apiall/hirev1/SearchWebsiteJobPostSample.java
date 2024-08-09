package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/websites/:website_id/job_posts/search
public class SearchWebsiteJobPostSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchWebsiteJobPostReq req = SearchWebsiteJobPostReq.newBuilder()
                .websiteId("111")
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(10)
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .jobLevelIdType("people_admin_job_level_id")
                .searchWebsiteJobPostReqBody(SearchWebsiteJobPostReqBody.newBuilder()
                        .jobTypeIdList(new String[]{})
                        .cityCodeList(new String[]{})
                        .jobFunctionIdList(new String[]{})
                        .subjectIdList(new String[]{})
                        .keyword("HR")
                        .updateStartTime("1618500278663")
                        .updateEndTime("1618500278663")
                        .createStartTime("1618500278663")
                        .createEndTime("1618500278663")
                        .build())
                .build();

        // 发起请求
        SearchWebsiteJobPostResp resp = client.hire().v1().websiteJobPost().search(req);

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
