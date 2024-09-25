package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.SearchReferralReq;
import com.lark.oapi.service.hire.v1.model.SearchReferralReqBody;
import com.lark.oapi.service.hire.v1.model.SearchReferralResp;

// POST /open-apis/hire/v1/referrals/search
public class SearchReferralSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchReferralReq req = SearchReferralReq.newBuilder()
                .userIdType("open_id")
                .searchReferralReqBody(SearchReferralReqBody.newBuilder()
                        .talentId("6930815272790114324")
                        .startTime("")
                        .endTime("")
                        .build())
                .build();

        // 发起请求
        SearchReferralResp resp = client.hire().v1().referral().search(req);

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
