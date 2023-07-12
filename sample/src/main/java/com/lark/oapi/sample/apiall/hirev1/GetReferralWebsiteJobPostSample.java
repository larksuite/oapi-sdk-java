package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.GetReferralWebsiteJobPostReq;
import com.lark.oapi.service.hire.v1.model.GetReferralWebsiteJobPostResp;

// GET /open-apis/hire/v1/referral_websites/job_posts/:job_post_id
public class GetReferralWebsiteJobPostSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetReferralWebsiteJobPostReq req = GetReferralWebsiteJobPostReq.newBuilder()
                .jobPostId("6701528341100366094")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .build();

        // 发起请求
        GetReferralWebsiteJobPostResp resp = client.hire().referralWebsiteJobPost().get(req);

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
