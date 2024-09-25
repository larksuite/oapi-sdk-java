package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListWebsiteJobPostReq;
import com.lark.oapi.service.hire.v1.model.ListWebsiteJobPostResp;

// GET /open-apis/hire/v1/websites/:website_id/job_posts
public class ListWebsiteJobPostSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListWebsiteJobPostReq req = ListWebsiteJobPostReq.newBuilder()
                .websiteId("111")
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(10)
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .jobLevelIdType("people_admin_job_level_id")
                .updateStartTime("1618500278663")
                .updateEndTime("1618500278663")
                .createStartTime("1618500278663")
                .createEndTime("1618500278663")
                .build();

        // 发起请求
        ListWebsiteJobPostResp resp = client.hire().v1().websiteJobPost().list(req);

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
